package main;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import data.Data;
import data.Event;
import data.Ticket;

public class World extends Event
{
	
	static void printClosestEvents(TreeMap<Integer,Event> distanceAndEvent)
	{
		System.out.println("The closest events to you are");
		Iterator<Map.Entry<Integer, Event>> iterator = distanceAndEvent.entrySet().iterator();
		
		for(int i=0;i<5;i++)
		{
			Map.Entry<Integer, Event> event = iterator.next();
			
			//Print event details
			event.getValue().print();
			
			//Print Distance
			System.out.println("Distance: "+ event.getKey());
			
			//Print Ticket details
			Ticket suggestedTicket=getDetails.getSuggestedTicket(event.getValue());
			System.out.print("Cheapest Ticket: ");
			suggestedTicket.print();
			
			//New line for tidiness
			System.out.println();
		}
	}
	

	public static void main(String args[])
	{

		//Data
		ArrayList<Event> data=new ArrayList<Event>();
		Data.getData(data);
				
		//Data output
		for(Event i : data)
		{
			i.print();
			for(Ticket t: i.ticketInfo)
			{
				t.print();
			}
		}
		
		// Getting the input from the user	
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter your location in the format x,y");
		String input=sc.nextLine();
		
		sc.close();
		
		int i=0;
		int xInput=0;
		int yInput=0;

		while(i<input.length())
		{
			if(input.charAt(i)==',')
			{
				// Parse the input 
				String parseX=input.substring(0,i);
				String parseY=input.substring(i+1,input.length());
				
				//Remove Whitespaces
				parseX=parseX.replaceAll(" ", "");
				parseY=parseY.replaceAll(" ", "");
				
				//Convert to Integer
				xInput=Integer.parseInt(parseX);
				yInput=Integer.parseInt(parseY);
			}
			i++;
		}
		
		//Get suggested event and ticket
		TreeMap<Integer,Event> distanceAndEvent=getDetails.getSuggestedEvent(data, xInput, yInput);
		printClosestEvents(distanceAndEvent);	
	}
}

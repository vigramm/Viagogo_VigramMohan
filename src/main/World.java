package main;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import data.Data;
import data.Event;
import data.Ticket;

public class World extends Event
{

	
	
	//Function that returns closest event based on distance
	static TreeMap<Integer, Event> getSuggestedEvent(ArrayList<Event> data, int xUser, int yUser)
	{
		TreeMap<Integer, Event> suggestedEvent=new TreeMap<Integer, Event>();
		

		for(Event i: data )
		{
			int distance=HelperMathFunctions.modulus(i.c.x-xUser)
					+HelperMathFunctions.modulus(i.c.y-yUser);
			suggestedEvent.put(distance, i);

		}
		return suggestedEvent;
	}
	
	
	// Function that returns Suggested ticket based on lowest price
	static Ticket getSuggestedTicket(Event suggestedEvent )
	{
		Ticket suggestedTicket=new Ticket();
		
		//Variable to keep track of minimum ticket price
		float minPrice=Float.MAX_VALUE;
		for( Ticket t: suggestedEvent.ticketInfo)
		{
			if(t.price<minPrice)
			{
				suggestedTicket=t;
				minPrice=t.price;
			}
		}
		return suggestedTicket;
	}
	
	
	static void printClosestEvents(TreeMap<Integer,Event> distanceAndEvent)
	{
		System.out.println("The closest events to you are");
		Iterator<Map.Entry<Integer, Event>> iterator = distanceAndEvent.entrySet().iterator();
		
		for(int i=0;i<5;i++)
		{
			Map.Entry<Integer, Event> event = iterator.next();
			event.getValue().print();
			System.out.println("Distance: "+ event.getKey());
			Ticket suggestedTicket=getSuggestedTicket(event.getValue());
			System.out.print("Cheapest Ticket: ");
			suggestedTicket.print();
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
		
		System.out.println("Enter your location");
		System.out.println("Enter the coordinate");
		String input=sc.nextLine();
		
		sc.close();
		
		int i=0;
		int xInput=0;
		int yInput=0;

		while(i<input.length())
		{
			if(input.charAt(i)==',')
			{
				String parseX=input.substring(0,i);
				String parseY=input.substring(i+1,input.length());
				xInput=Integer.parseInt(parseX);
				yInput=Integer.parseInt(parseY);
			}
			i++;
		}
		

		
		//Get suggested event and ticket
		
		TreeMap<Integer,Event> distanceAndEvent=getSuggestedEvent(data, xInput, yInput);
		
		printClosestEvents(distanceAndEvent);
		
		
		//Ticket suggestedTicket=getSuggestedTicket(suggestedEvent);
		
		
		

		
//		System.out.println("And the cheapest ticket is");
//		suggestedTicket.print();
		
	}
}

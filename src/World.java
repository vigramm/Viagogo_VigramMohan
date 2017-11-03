import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class World extends Event
{
	// Function to find the modulus
	static int modulus(int x)
	{
		if(x>=0)
		{
			return x;
		}
		else
		{
			return -x;
		}
	}
	
	static float randomFloat(float min, float max)
	{
		//generate random ticket prices
		Random randomTicketPrice= new Random();
		float randomPrice= randomTicketPrice.nextFloat()*(max-min)+min;
		
		return randomPrice;
	}
	
	
	//Function that returns closest event based on distance
	static Event getSuggestedEvent(ArrayList<Event> data, int xUser, int yUser)
	{
		Event suggestedEvent=new Event();
		
		//Variable to keep track of minimum distance
		int minDistance=Integer.MAX_VALUE;
		for(Event i: data )
		{
			int distance=modulus(i.c.x-xUser)+modulus(i.c.y-yUser);
			if(distance<minDistance)
			{
				suggestedEvent=i;
				minDistance=distance;
			}
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
			t.print();
			if(t.price<minPrice)
			{
				suggestedTicket=t;
				minPrice=t.price;
			}
		}
		return suggestedTicket;
	}
	
	static ArrayList<Event> getData(ArrayList<Event> data)
	{
		//To keep track of already generated coordinates
		ArrayList<Coordinates> eventCoordinates=new ArrayList<Coordinates>();
		
		//generate random total Ticket amount
		Random randomtotalTicketAmount= new Random();
		
		//to generate random coordinates
		Random randomX= new Random();
		Random randomY= new Random();
		int xNegative=1, yNegative=1; // to also include negative numbers
		
		int counter=1;
		while(counter<=10)
		{
			
			//Event Identifier Numbers same as counter( 1....total data points)
			int eventIdentifierNumber = counter;
			
			//Random total ticket amount
			int totalTicketAmount = randomtotalTicketAmount.nextInt(20);
			
			//Random X
			int xCoordinate = randomX.nextInt(10)*xNegative;
			
			//Random Y
			int yCoordinate = randomY.nextInt(10)*yNegative;
			
			//New Coordinate with random X and Y
			Coordinates c=new Coordinates(xCoordinate,yCoordinate);

			//to make sure an event does not have the same location
			if(!eventCoordinates.contains(c) && totalTicketAmount!=0)
			{
				
				//Holds Ticket details (ticket Number, Price)
				ArrayList<Ticket> ticketInfo=new ArrayList<Ticket>();
				
				//Keeps track of ticket Number
				int ticketCounter=1;
			
				
				//Add the ticket numbers and Prices for a given event
				while(ticketCounter<=totalTicketAmount)
				{

					//Get random Prices between 1 and 100dollars
					float maxPrice=100.00F;
					float minPrice=1.00F;
					float randomPrice= randomFloat(minPrice, maxPrice);
					
					//New ticket with (Ticket Number, Price)
					//Ticket Number will go from 1 to the total number of tickets
					Ticket newTicket=new Ticket(ticketCounter, randomPrice);
					
					
					//The Tickets are then stored in an ArrayList
					ticketInfo.add(newTicket);
					
					ticketCounter++;
				}
				Event newEvent= new Event(eventIdentifierNumber, totalTicketAmount
						,c, ticketInfo);
			
				
				eventCoordinates.add(c);
				
				data.add(newEvent);
				counter++;
			}
			// To completely randomize the data, if this was not implemented, 
			// the data would only consist of both positive or both negative coordinates
			if(eventIdentifierNumber%2==0)
			{
			xNegative=xNegative*-1;
			}
			
			yNegative=yNegative*-1;			
		}
		return data;
	}
	

	
	
	public static void main(String args[])
	{

		//Data
		ArrayList<Event> data=new ArrayList<Event>();
		getData(data);
				
		
		
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
		System.out.println("Enter the X coordinate");
		int xUser=sc.nextInt();
		
		System.out.println("Enter the Y coordinate");
		int yUser=sc.nextInt();
		
		sc.close();
		
		
		
		//Get suggested event and ticket
		
		Event suggestedEvent=getSuggestedEvent(data, xUser, yUser);
		Ticket suggestedTicket=getSuggestedTicket(suggestedEvent);
		
		
		
		System.out.println("The closest event to you is");
		suggestedEvent.print();
		System.out.println("And the cheapest ticket is");
		suggestedTicket.print();
		
	}
}

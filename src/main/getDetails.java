package main;

import java.util.ArrayList;
import java.util.TreeMap;

import data.Event;
import data.Ticket;

public class getDetails 
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

}

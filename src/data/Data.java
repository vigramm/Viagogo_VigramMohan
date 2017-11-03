package data;

import java.util.ArrayList;
import java.util.Random;
import main.*;

//Class to get Data
public class Data 
{
	public static ArrayList<Event> getData(ArrayList<Event> data)
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
					float minPrice=1.00F;
					float maxPrice=100.00F;
					
					float randomPrice= HelperMathFunctions.randomFloat(minPrice, maxPrice);
					
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
}

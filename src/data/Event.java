package data;
import java.util.ArrayList;

//Class to hold event details
public class Event extends Ticket  
{
	int eventIdentifier;
	public Coordinates c;

	int totalTicketNumber;
	public ArrayList<Ticket> ticketInfo=new ArrayList<Ticket>(); //change to treemaps<ticketno, price>
	
	public Event(int eventIdentifier,	int totalTicketNumber,Coordinates c, ArrayList<Ticket> ticketInfo)
	{
		super();
		this.eventIdentifier=eventIdentifier;
		this.c=c;
		this.totalTicketNumber=totalTicketNumber;
		this.ticketInfo=ticketInfo;
	}
	
	
	public Event()
	{
		super();
		this.eventIdentifier=0;
		this.c=null;
		this.totalTicketNumber=0;
		this.ticketInfo=null;
	}
	
	//Print function for Event details
	public void print()
	{
		System.out.print("Event Indentifier: "+ eventIdentifier+" ");
		System.out.print("Total Available Tickets: "+ totalTicketNumber+" ");
		System.out.print("Location:");
		c.print();
	}
}




import java.util.ArrayList;


public class Event extends Ticket  
{
	int eventIdentifier;
	Coordinates c;

	int totalTicketNumber;
	ArrayList<Ticket> ticketInfo=new ArrayList<Ticket>(); //change to treemaps<ticketno, price>
	
	Event(int eventIdentifier,	int totalTicketNumber,Coordinates c, ArrayList<Ticket> ticketInfo)
	{
		super();
		this.eventIdentifier=eventIdentifier;
		this.c=c;
		this.totalTicketNumber=totalTicketNumber;
		this.ticketInfo=ticketInfo;
	}
	
	
	Event()
	{
		super();
		this.eventIdentifier=0;
		this.c=null;
		this.totalTicketNumber=0;
		this.ticketInfo=null;
	}
	
	//Print function for Event details
	void print()
	{
		System.out.print("Event Indentifier: "+ eventIdentifier+" ");
		System.out.print("Total Available Tickets: "+ totalTicketNumber+" ");
		System.out.print("Location:");
		c.print();
	}
}

//Class to represent a coordinate
class Coordinates 
{	
	int x;
	int y;

	Coordinates(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	Coordinates()
	{
		this.x=0;
		this.y=0;
	}
	
	void print()
	{
		System.out.println("("+x+", "+y+")");
	}
}


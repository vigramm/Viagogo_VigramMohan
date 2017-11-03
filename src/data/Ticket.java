package data;

public class Ticket 
{
	int ticketNumber;
	public float price;
	
	public Ticket(int ticketNumber, float price)
	{
		
		this.ticketNumber=ticketNumber;
		this.price=price;
	}

	public Ticket()
	{
		
		this.ticketNumber=0;
		this.price=0.0F;
	}
	
	//Print function for Ticket
	public void print()
	{
		System.out.println("TicketNumber: "+ticketNumber +" Price: $"+price);
	}
}

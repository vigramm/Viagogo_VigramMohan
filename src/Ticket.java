
public class Ticket 
{
	int ticketNumber;
	float price;
	
	Ticket(int ticketNumber, float price)
	{
		
		this.ticketNumber=ticketNumber;
		this.price=price;
	}

	Ticket()
	{
		
		this.ticketNumber=0;
		this.price=0.0F;
	}
	
	//Print function for Ticket
	void print()
	{
		System.out.println("TicketNumber: "+ticketNumber +" Price: $8"+price);
	}
}

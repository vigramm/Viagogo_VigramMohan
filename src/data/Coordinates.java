package data;

//Class to represent a coordinate
public class Coordinates 
{	
	public int x;
	public int y;

	public Coordinates(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public Coordinates()
	{
		this.x=0;
		this.y=0;
	}
	
	void print()
	{
		System.out.println("("+x+", "+y+")");
	}
}
package main;
import java.util.Random;

//Class to hold the helper math functions
public class HelperMathFunctions 
{
	//Modulus function
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
	
	//Random function
	public static float randomFloat(float min, float max)
	{
		//generate random ticket prices
		Random randomTicketPrice= new Random();
		float randomPrice= randomTicketPrice.nextFloat()*(max-min)+min;
		
		return randomPrice;
	}
	
}

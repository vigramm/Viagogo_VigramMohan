package main;
import java.util.Random;

public class HelperMathFunctions 
{

	public class java {

	}

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
	
	public static float randomFloat(float min, float max)
	{
		//generate random ticket prices
		Random randomTicketPrice= new Random();
		float randomPrice= randomTicketPrice.nextFloat()*(max-min)+min;
		
		return randomPrice;
	}
	
}

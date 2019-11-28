package com.vrk.core.programs;

public class ValidatePrimeNumber2 {
	
	static int count=0,i=1;

	public static void main(String[] args) {
		 
		int number=4;

		int c=primeOrNot(number);
		
		if(c==2) {
			System.out.println("given numenr is primve");
		}else {
			System.out.println("given numenr is not primve");
		}

	}
	
	
	public static int primeOrNot(int num) {
		
		if(i<=num)
		{
		   if(num%i==0)
		   {
		        count++;                
		   }
		  i++;
		primeOrNot(num);
		}
	     return count;
		
	}

}

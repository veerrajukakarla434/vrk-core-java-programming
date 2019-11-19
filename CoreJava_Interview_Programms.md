## Java Coding Programms

* **Problem 1 :**
given input String str = "aaabbbcccddaae";
reuired out put String output=a3b3c3d2a2e1

```Java
package com.vrk.core.programs;

public class StringManiplation1 {

	public static void main(String[] abc) {

		String str = "aaabbbccddaae";
		// Required output : a3b3c2d2a2e1
		String outStr = getOutPutString(str);
		System.out.println("Out put : " + outStr);
	}

	public static String getOutPutString(String str) {

		StringBuilder sb = new StringBuilder();
		int count = 1;
		for (int i = 0; i < str.length(); i++) {
			if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
				count++;
			} else {
				sb.append(str.charAt(i)).append(count);
				count = 1;
			}

		}

		return sb.toString();
	}

}

Out Put : a3b3c3d2a2e1
```
##### Explanation :

* **if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1))   here** 

  * i + 1 < str.length()  condition will traverse the loop exact last element
  * str.charAt(i) == str.charAt(i + 1)  based on above condition there is no chance to get arrayOutofBoundofException
  * if we remove 1st condition there is a chance to get arrayOutofBoundofException
  * if 2 chars are equal then count will increase
  * if not equal that char and count added to string by using StringBuilder and then count will be reseted as 1
  
  
#### Fibonacci series in Java

* In fibonacci series, next number is the sum of previous two numbers for example 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 etc. The first two numbers of fibonacci series are 0 and 1.

* There are two ways to write the fibonacci series program in java:

  * Fibonacci Series without using recursion
  * Fibonacci Series using recursion  

* **problem 2 :**
* Fibonacci Series in Java without using recursion  
  
```Java
public class FibonacciExample1 {

	public static void main(String[] args) {
		
		int n1=0, n2=1, n3=0,  count=10;
		
		System.out.print(n1+" "+n2); //printing 0 and 1   
		
		for(int i=2; i<count; i++) {  //loop starts from 2 because 0 and 1 are already printed  
			
			n3=n1+n2;
			n1=n2;
			n2=n3;
			System.out.print(" "+n3);   
			
		}
		

	}

}

Output : 
0 1 1 2 3 5 8 13 21 34

```
* **problem 3 :**
* Fibonacci Series in Java using recursion  

```Java
package com.vrk.core.programs;

public class FibonacciExample2 {
	static int n1=0, n2=1, n3=0, count=10;
	public static void main(String[] args) {
		
		System.out.print(n1+" "+n2); //printing 0 and 1    
		printFibonacci(count-2); //n-2 because 2 numbers are already printed   
	}
	
	public static void printFibonacci(int count) {
		
		if(count>0) {
		n3=n1+n2;
		n1=n2;
		n2=n3;
		System.out.print(" "+n3);
		printFibonacci(count-1);
		}
		
	}
	
	
}
OutPut:
0 1 1 2 3 5 8 13 21 34
```

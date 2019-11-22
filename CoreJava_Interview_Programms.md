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
* **Problem4:** ->Java Program to count the total number of characters in a string
* In this program, we need to count the number of characters present in the string: **The best of both worlds**
* To count the number of characters present in the string, we will iterate through the string and count the characters. In above example, total numbers of characters present in the string are 19.

* For programming, follow the algorithm given below:

```Java
Algorithm
STEP 1: START
STEP 2: DEFINE String string = "The best of both worlds".
STEP 3: SET count =0.
STEP 4: SET i=0. REPEAT STEP 5 to STEP 6 UNTIL i<string.length
STEP 5: IF (string.charAt(i)!= ' ') then count =count +1.
STEP 6: i=i+1
STEP 7: PRINT count.
STEP 8: END
=================================================================

package com.vrk.core.programs;

public class CountCharacter {

	public static void main(String[] args) {
		String string = "The best of both worlds";    
        int count = 0;  
        
        for(int i=0; i<string.length(); i++) {
        	if(string.charAt(i) != ' ') {
        		count++;
        	}
        }
       System.out.println("Given String charaters count : " + count);
	}

}


Out put : 

Given String charaters count : 19

```

* **Problem 5** : Java Program to count the total number of vowels and consonants in a string

* In this program, our task is to count the total number of vowels and consonants present in the given string.

* As we know that, the characters a, e, i, o, u are known as vowels in the English alphabet. Any character other than that is known as the consonant.

* To solve this problem, First of all, we need to convert every upper-case character in the string to lower-case so that the comparisons can be done with the lower-case vowels only not upper-case vowels, i.e.(A, E, I, O, U). Then, we have to traverse the string using a for or while loop and match each character with all the vowels, i.e., a, e, i, o, u. If the match is found, increase the value of count by 1 otherwise continue with the normal flow of the program. The algorithm of the program is given below.

```Java
Algorithm
STEP 1: START
STEP 2: SET vCount =0, cCount =0
STEP 3: DEFINE string str = "This is a really simple sentence".
STEP 4: CONVERT str to lowercase
STEP 5: SET i =0.
STEP 6: REPEAT STEP 6 to STEP 8 UNTIL i<str.length()
STEP 7: IF any character of str matches with any vowel then
vCount = vCount + 1.
STEP 8: IF any character excepting vowels lies BETWEEN a and z then
cCount = cCount =+1.
STEP 9: i = i + 1
STEP 10: PRINT vCount.
STEP 11: PRINT cCount.
STEP 12: END
=========================================================================
package com.vrk.core.programs;

public class CountVowelConsonant {

	public static void main(String[] args) {
		
		//Counter variable to store the count of vowels and consonant    
        int vCount = 0, cCount = 0;    
        //Declare a string    
        String str = "This is a really simple sentence";    
      //Converting entire string to lower case to reduce the comparisons    
        str = str.toLowerCase(); 
        
        for(int i=0; i<str.length(); i++) {
        	if(str.charAt(i)=='a' ||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o' ||str.charAt(i)=='u') {
        		vCount++;
        	}
        	 //Checks whether a character is a consonant    
            else if(str.charAt(i) >= 'a' && str.charAt(i)<='z') {      
                //Increments the consonant counter    
                cCount++;    
            }    
        }
        
        System.out.println("Number of vowels: " + vCount);    
        System.out.println("Number of consonants: " + cCount);    
	}

}

Out Put :
Number of vowels: 10
Number of consonants: 17
```

* **Problem 6** Factorial Program in Java
* **Factorial Program in Java:** Factorial of n is the product of all positive descending integers. Factorial of n is denoted by n!. For example:
```Java
4! = 4*3*2*1 = 24  
5! = 5*4*3*2*1 = 120  
```
* Here, 4! is pronounced as "4 factorial", it is also called "4 bang" or "4 shriek".
* There are many ways to write the factorial program in java language. Let's see the 2 ways to write the factorial program in java.

  * Factorial Program using loop
  * Factorial Program using recursion
#### Factorial Program using loop in java
  
```Java
package com.vrk.core.programs;

public class FactorialExample {

	public static void main(String args[]){  
		int i,fact=1;  
		int number=5;//It is the number to calculate factorial    
		for(i=1;i<=number;i++){    
			fact=fact*i;    
		}    
		System.out.println("Factorial of "+number+" is: "+fact);    
	} 
}  

Out Put : Factorial of 5 is: 120
```
#### Factorial Program using recursion in java
```Java
package com.vrk.core.programs;

public class FactorialExample2 {

	static int factorial(int n){    
		if (n == 0)    
			return 1;    
		else    
			return(n * factorial(n-1));    
	}    
	public static void main(String args[]){  
		int fact=1;  
		int number=4;//It is the number to calculate factorial    
		fact = factorial(number);   
		System.out.println("Factorial of "+number+" is: "+fact);    
	}  
}  
Out Put :Factorial of 4 is: 24

```
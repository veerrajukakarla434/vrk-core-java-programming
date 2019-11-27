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

* **Problem 7** : Palindrome Program in Java

* Palindrome number in java: A palindrome number is a number that is same after reverse. For example 545, 151, 34543, 343, 171, 48984 are the palindrome numbers. It can also be a string like LOL, MADAM etc.
* **Palindrome number algorithm:**
 * Get the number to check for palindrome
 * Hold the number in temporary variable
 * Reverse the number
 * Compare the temporary number with reversed number
 * If both numbers are same, print "palindrome number"
 * Else print "not palindrome number"
 
* Let's see the palindrome program in java. In this java program, we will get a number variable and check whether number is palindrome or not.
```Java
package com.vrk.core.programs;

public class PalindromeExample {

	public static void main(String args[]){  
		int r,sum=0,temp;    
		int n=454;//It is the number variable to be checked for palindrome  

		temp=n;    
		while(n>0){    
			r=n%10;  //getting remainder  
			sum=(sum*10)+r;    
			n=n/10;    
		}    
		if(temp==sum)    
			System.out.println("palindrome number ");    
		else    
			System.out.println("not palindrome");    
	}  
}  

palindrome number 
``` 

#### Palindrome Program in Java (Another way)

```Java
package com.vrk.core.programs;

import java.util.Scanner;

public class PalindromeExample2 {
 
	public static void main(String args[])  
	   {  
	      String original, reverse = ""; // Objects of String class  
	      Scanner in = new Scanner(System.in);   
	      System.out.println("Enter a string/number to check if it is a palindrome");  
	      original = in.nextLine();   
	      int length = original.length();   
	      for ( int i = length - 1; i >= 0; i-- )  
	         reverse = reverse + original.charAt(i);  
	      if (original.equals(reverse))  
	         System.out.println("Entered string/number is a palindrome.");  
	      else  
	         System.out.println("Entered string/number isn't a palindrome.");   
	   }  
}

Out Put:
Enter a string/number to check if it is a palindrome
veera
Entered string/number isn't a palindrome.
```
* **Problem 8** : Armstrong Number in Java

* Let's write a java program to check whether the given number is armstrong number or not.

* Armstrong Number in Java: A positive number is called armstrong number if it is equal to the sum of cubes of its digits for example 0, 1, 153, 370, 371, 407 etc.

* Let's try to understand why 153 is an Armstrong number.

```Java
153 = (1*1*1)+(5*5*5)+(3*3*3)  
where:  
(1*1*1)=1  
(5*5*5)=125  
(3*3*3)=27  
So:  
1+125+27=153 
```
Let's see the java program to check Armstrong Number.
```Java
package com.vrk.core.programs;

public class ArmstrongExample {

	public static void main(String[] args)  {  
	    int c=0,a,temp;  
	    int n=153;//It is the number to check armstrong  
	    temp=n;  
	    while(n>0)  
	    {  
	    a=n%10;  
	    n=n/10;  
	    c=c+(a*a*a);  
	    }  
	    if(temp==c)  
	    System.out.println("armstrong number");   
	    else  
	        System.out.println("Not armstrong number");   
	   }  
	
}

OutPut:
armstrong number
```
* **Problem 9:** Java Program to determine whether two strings are the anagram

* Two Strings are called the anagram if they contain the same characters. However, the order or sequence of the characters can be different. 
* First of all, Compare the length of the strings, if they are not equal in the length then print the error message and make an exit, otherwise, convert the string into lower-case for the easy comparisons. Sort both the strings using bubble sort or other sorting methods. If the strings are found to be identical after sorting, then print that strings are anagram otherwise print that strings are not the anagram.

```Java
For programming, follow the algorithm given below:

Algorithm
STEP 1: START
STEP 2: DEFINE str1 = "Brag", str2 = "Grab".
STEP 3: CONVERT str1, str2 to lower-case.
STEP 4: IF length of str1, str2 are not equal then PRINT "Not Anagram"
else go to Step 5
STEP 5: CONVERT str1, str2 to character arrays.
STEP 6: SORT the arrays.
STEP 7: COMPARE the arrays, IF equal then PRINT "Anagram"
else
PRINT "Not Anagram"
STEP 8: END
```
Java Programm:

```Java
package com.vrk.core.programs;

import java.util.Arrays;

public class Anagram {

	 public static void main (String [] args) {  
	        String str1="Brag";  
	        String str2="Grab";  
	  
	        //Converting both the string to lower case.  
	        str1 = str1.toLowerCase();  
	        str2 = str2.toLowerCase();  
	  
	        //Checking for the length of strings  
	        if (str1.length() != str2.length()) {  
	            System.out.println("Both the strings are not anagram");  
	        }  
	        else {  
	            //Converting both the arrays to character array  
	            char[] string1 = str1.toCharArray();  
	            char[] string2 = str2.toCharArray();  
	  
	            //Sorting the arrays using in-built function sort ()  
	            Arrays.sort(string1);  
	            Arrays.sort(string2);  
	  
	            //Comparing both the arrays using in-built function equals ()  
	            if(Arrays.equals(string1, string2) == true) {  
	                System.out.println("Both the strings are anagram");  
	            }  
	            else {  
	                System.out.println("Both the strings are not anagram");  
	            }  
	        }  
	    }  
	} 
	
	
	OutPut: 
	Both the strings are anagram
```	 
* **Problem 10:** Java Program to find maximum and minimum elements from given array.

```Java
package com.vrk.core.programs;

public class MaxAndMinElementsFromArray {

	static int max=0;
	static int min=0;
	
	public static void main(String []abc) {
	
	int []aray= {100,-499,-2,6,87,98,405,78,56,43,1};
	int length= aray.length;
	
	for(int i=0; i<length; i++ ) {
		
		if(max<aray[i]) {
			max=aray[i];
		}
		if(min>aray[i]) {
			min=aray[i];
		}
	}
	
	System.out.println("Max Element : "+max);
	System.out.println("Min Element : "+min);

}
}

OutPut:
Max Element : 405
Min Element : -499
```
* **Problem 10** : 
input String str = "arp";
take input as from given str like ar,rp,ap and pring min ascii value of string

```Java
package com.vrk.core.programs;

import java.util.Map;
import java.util.TreeMap;

public class PrintMinimumAsciiString {

	public static void main(String[] abc) {

		String str = "arp";
		StringBuilder sb = null;
		String[] array = new String[str.length()];
		Map<Integer, String> map = new TreeMap<>();

		for (int i = 0; i < str.length(); i++) {
			sb = new StringBuilder(str);
			array[i] = sb.deleteCharAt(i).toString();

			String s = array[i];
			int charAscii = 0;
			for (int j = 0; j < s.length(); j++) {
				charAscii += (int) s.charAt(j);
			}
			map.put(charAscii, array[i]);

		}
		System.out.println("Actual values from map with ascii values  : " + map);
		System.out.println("min Ascii value of element : " + map.values().toArray()[0]);
		System.out.println("max Ascii value of element : " + map.values().toArray()[map.size()-1]);

	}

}
```
OutPut:

```Console
Time Complexity O(n^2)

Actual values from map with ascii values  : {209=ap, 211=ar, 226=rp}
min Ascii value of element : ap
max Ascii value of element : rp

```

* **Problem 11** : Count Duplicate Characters from a given String

```Java
blic class CountDuplicateCharactersFromString {

	public static void main(String[] args) {
		
		String str = "veerraju";
		Map<Character,Integer>map = new LinkedHashMap<>();
		int count=1;
		
		for(int i=0; i<str.length(); i++) {
			
			for(int j=i+1; j<str.length(); j++) {
				
				if(str.charAt(i)==str.charAt(j)) {
					count++;
				}
			}
			if(!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), count);
				count=1;
			}
			
		}
        System.out.println("Time Complexity : O(n^2) "+map);
	
	
	}
}
```
Out Put :

```Console
Time Complexity : O(n^2) {v=1, e=2, r=2, a=1, j=1, u=1}
```
#### 2nd Approach it will five Time Complexity 
```Java
package com.vrk.core.programs;

import java.util.LinkedHashMap;
import java.util.Map;

public class CountDuplicateCharactersFromString1 {

	public static void main(String[] args) {

		String str = "veerraju";
		Map<Character,Integer> charMap = new LinkedHashMap<>();

		char[]crr = str.toCharArray();

		for(Character ch : crr) {

			if(charMap.containsKey(ch)) {

				charMap.put(ch, charMap.get(ch)+1);

			}else {
				charMap.put(ch,1);
			}

		}

		System.out.println("Time Complexity : O(n) "+charMap);
	}
}
```
Out Put:
```Console
Time Complexity : O(n) {v=1, e=2, r=2, a=1, j=1, u=1}
```





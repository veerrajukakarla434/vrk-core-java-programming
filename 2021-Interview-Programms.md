# 2021-Interview-Programms

### Second highest number without using utility methods
```java

public class SecondlargetNumber {

	public static void main(String[] args) {
		
		int [] arr = {7,8,5,4,3,2,3,4,9};
		int temp= 0;
		for(int i=0; i<arr.length; i++) {
			
			for(int j=i+1; j<arr.length; j++) {
				
				if(arr[i]>arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j]=temp;
				}
				
			}
			
		}
		
		for(int k :arr) {
			System.out.println(k);
		}
		
		System.out.println("Second highest number is :" + arr[arr.length-2] );
	}

}

2
3
3
4
4
5
7
8
9
Second highest number is :8
```

### Given an array of strings, return all groups of strings. OR Group anagrams together from a list of words

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagramsTogetherFromWords {

	public static void main(String[] args) {
		String []words = {"Act","Pqr","CAT","rqp","tac", "qrp"};
		
		List<List<String>> result  = groupAnagrams(words);
        result.forEach(t -> System.out.println(t + " "));
        //OR
        for(List<String> list : result) {
        	System.out.println(list);
        }
        
	  
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		 
	       List<List<String>> result = new ArrayList<>();
	       HashMap<String, List<String>> map = new HashMap<>();
	 
	       for(String str: strs){
	       
	          char[] chArr = str.toCharArray();
	          Arrays.sort(chArr);
	          String key = new String(chArr).toLowerCase();
	         
	          if(map.containsKey(key)){
	             map.get(key).add(str);
	 
	          } else {
	             List<String> strList = new ArrayList<>();
	             strList.add(str);
	             map.put(key, strList);
	          }
	        }
	         //System.out.println(map);
	         
	       result.addAll(map.values());
	       return result;
	   }
	
	
}

[Pqr, rqp, qrp] 
[Act, CAT, tac] 

```

###  How to find duplicate characters in a string in java?

```java
import java.util.HashMap;
import java.util.Map;

public class CountDulpicateWordsFromString {

	public static void main(String[] args) {
		String str = "hai how are you you you you you you you you hai are are are how are you veer";

		Map<String, Integer> wordMap = new HashMap<>();
		String[] words = str.split(" ");

		for (String word : words) {
			if (wordMap.containsKey(word)) {
				wordMap.put(word, wordMap.get(word) + 1);
			} else {
				wordMap.put(word, 1);
			}
		}
		
		for(Map.Entry<String, Integer> entry : wordMap.entrySet()) {
			if(entry.getValue()>1) {
				System.out.println(entry.getKey() +" - " + entry.getValue());
			}
			
		}
     
	}

}

Out Put :
hai - 2
how - 2
are - 5
you - 9
```

#### Pring Duplicate words in Assending Order and DessingOrder 
```java
public class CountHighestRepeatingWordsFromText {
	public static void main(String args[]) {

		String str = "hai how are you you you you you you you you hai are are are how are you veer";

		Map<String, Integer> wordMap = new HashMap<>();
		String[] words = str.split(" ");

		for (String word : words) {
			if (wordMap.containsKey(word)) {
				wordMap.put(word, wordMap.get(word) + 1);
			} else {
				wordMap.put(word, 1);
			}
		}
		
		// start
		Map<String, Integer> sortedByCount = wordMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		System.out.println(sortedByCount);
		//end
		
		// start
		 Map<String, Integer> sortedByCount1 = wordMap.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
				System.out.println(sortedByCount1);
				//end
		
		 
	}
}
{veer=1, hai=2, how=2, are=5, you=9}
{you=9, are=5, hai=2, how=2, veer=1}

// For 2nd Most repeated Value given String

      System.out.println(" 2nd most "+ sortedByCount);
		int value = (int)sortedByCount.values().toArray()[sortedByCount.size()-2];
		System.out.println(" 2nd most "+ value);
		
		for(Map.Entry<String, Integer> entry : sortedByCount.entrySet()) {
			if(entry.getValue()==value) {
				System.out.println(" 2nd most repeated word : "+ entry.getKey());
			}
		}
		
 2nd most {veer=1, hai=2, how=2, are=5, you=9}
 2nd most 5
 2nd most repeated word : are
```

``` java
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountHighestRepeatingWordsFromText {
	public static void main(String args[]) {

		String str = "hai how are you you you you you you you you hai are are are how are you veer";

		Map<String, Integer> wordMap = new HashMap<>();
		String[] words = str.split(" ");

		for (String word : words) {
			if (wordMap.containsKey(word)) {
				wordMap.put(word, wordMap.get(word) + 1);
			} else {
				wordMap.put(word, 1);
			}
		}
		
		// start
		Map<String, Integer> sortedByCount = wordMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		System.out.println(sortedByCount);
		//end
		
		// start
		final Map<String, Integer> sortedByCount1 = wordMap.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
				System.out.println(sortedByCount1);
				//end
		
		 System.out.println("2nd most repated number :" + sortedByCount1.values().toArray());		
		 System.out.println("2nd most repated number :" + sortedByCount1.values().toArray()[1]);
		 

	}

```

### Java Program To Check Given Number Is Prime Or Not

``` java
public class Main {

  public static void main(String[] args) {

    int num = 29;
    boolean flag = false;
    for (int i = 2; i <= num / 2; ++i) {
      // condition for nonprime number
      if (num % i == 0) {
        flag = true;
        break;
      }
    }

    if (!flag)
      System.out.println(num + " is a prime number.");
    else
      System.out.println(num + " is not a prime number.");
  }
}
```
### Write a java program to find second largest number in an integer array

``` java
 //Using Collections
 
public class SecondLargestInArrayExample2{  
public static int getSecondLargest(Integer[] a, int total){  
List<Integer> list=Arrays.asList(a);  
Collections.sort(list);  
int element=list.get(total-2);  
return element;  
}  
public static void main(String args[]){  
Integer a[]={1,2,5,6,3,2};  
Integer b[]={44,66,99,77,33,22,55};  
System.out.println("Second Largest: "+getSecondLargest(a,6));  
System.out.println("Second Largest: "+getSecondLargest(b,7));  
}}  
Test it Now
Output:

Second Largest: 5
Second Largest: 77


// OR

import java.util.Arrays;  
public class SecondLargestInArrayExample1{  
public static int getSecondLargest(int[] a, int total){  
Arrays.sort(a);  
return a[total-2];  
}  
public static void main(String args[]){  
int a[]={1,2,5,6,3,2};  
int b[]={44,66,99,77,33,22,55};  
System.out.println("Second Largest: "+getSecondLargest(a,6));  
System.out.println("Second Largest: "+getSecondLargest(b,7));  
}}  
Test it Now
Output:

Second Largest: 5
Second Largest: 77

```
### How do you swap two string variables without using third or temp variable in java?

```java
public class Test {

	public static void main(String[] args) {
		String str = "veerraju";
		String str1="Raju";
		
		System.out.println("Before swap :" + str +"  "+ str1);
		
		str = str+str1;
		
		str1 =str.substring(0,str.length()-str1.length()) ;
		
		str =str.substring(str1.length()); 
		
		System.out.println("After swap :" + str +"  "+ str1);
	}

}

Before swap :veerraju  Raju
After swap :Raju  veerraju

```
* **Coding Problem** : Given an input string of random letters find letters that make up numbers in Java
```java
public class TestExample1 {  
  public static void main(String[] args) {  
	
	  String input = "seveneightninetwothreefive";
	  String[] numberWords =createWordList(); 
	  int out = findNumber(numberWords, input);
	  System.out.println("--------------> : "+out);
	  
  }
  
  public static String[] createWordList() {
	    String[] numberWords = new String[10];
	    numberWords[0] = "zero";
	    numberWords[1] = "one";
	    numberWords[2] = "two";
	    numberWords[3] = "three";
	    numberWords[4] = "four";
	    numberWords[5] = "five";
	    numberWords[6] = "six";
	    numberWords[7] = "seven";
	    numberWords[8] = "eight";
	    numberWords[9] = "nine";
	    return numberWords;
	}
  
  public static String sort(String input) {
	    char[] digits = input.toCharArray();
	    Arrays.sort(digits);
	    return new String(digits);
	}
  
  public static int findNumber(String[] numberWords, String input) {
	    input = sort(input);

	    int length = input.length();
	    double minPower = Math.floor(length / 5d);
	    double maxPower = Math.ceil(length / 3d);
	    int minimum = (int) Math.pow(10d, minPower);
	    int maximum = (int) Math.pow(10d, maxPower);

	    for (int index = minimum; index < maximum; index++) {
	        String test = createNumberString(numberWords,
	                index);
	        test = sort(test);
	        if (test.equals(input)) {
	            return index;
	        }
	    }

	    return -1;
	}
  
  public static String createNumberString(String[] numberWords,
	        int index) {
	    String output = "";

	    while (index > 0) {
	        int digit = index % 10;
	        output = numberWords[digit] + output;
	        index /= 10;
	    }

	    return output;
	}
}

```
* **OR**
```Java
public class JumblledLetters {

	// Function to convert the jumbled
	  // string into digits
	  static String finddigits(String s)
	  {
	 
	    // Strings of digits 0-9
	    String[] num
	      = { "zero", "one", "two",   "three", "four",
	         "five", "six", "seven", "eight", "nine" };
	 
	    // Initialize vector
	    int[] arr = new int[10];
	 
	    // Initialize answer
	    String ans = "";
	 
	    // Size of the string
	    int n = s.length();
	 
	    // Traverse the string
	    for (int i = 0; i < n; i++) {
	      if (s.charAt(i) == 'z')
	        arr[0]++;
	      if (s.charAt(i) == 'w')
	        arr[2]++;
	      if (s.charAt(i) == 'g')
	        arr[8]++;
	      if (s.charAt(i) == 'x')
	        arr[6]++;
	      if (s.charAt(i) == 'v')
	        arr[5]++;
	      if (s.charAt(i) == 'o')
	        arr[1]++;
	      if (s.charAt(i) == 's')
	        arr[7]++;
	      if (s.charAt(i) == 'f')
	        arr[4]++;
	      if (s.charAt(i) == 'h')
	        arr[3]++;
	      if (s.charAt(i) == 'i')
	        arr[9]++;
	    }
	 
	    // Update the elements of the vector
	    arr[7] -= arr[6];
	    arr[5] -= arr[7];
	    arr[4] -= arr[5];
	    arr[1] -= (arr[2] + arr[4] + arr[0]);
	    arr[3] -= arr[8];
	    arr[9] -= (arr[5] + arr[6] + arr[8]);
	 
	    // Print the digits into their
	    // original format
	    for (int i = 0; i < 10; i++) {
	      for (int j = 0; j < arr[i]; j++) {
	        ans += (char)(i + '0');
	      }
	    }
	 
	    // Return answer
	    return ans;
	  }
	 
	  // Driver Code
	  public static void main(String[] args)
	  {
	    String s = "owonneeto";
	    System.out.println(finddigits(s));
	  }
	}
```	

# 2021-Interview-Programms

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


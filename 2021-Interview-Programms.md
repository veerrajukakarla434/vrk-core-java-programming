# 2021-Interview-Programms

### 1) Given an array of strings, return all groups of strings. OR Group anagrams together from a list of words

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


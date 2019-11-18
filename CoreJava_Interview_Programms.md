## Java Coding Programms

* **Problem 1 :**
given input String str = "aaabbbcccddaae";
reuired out put String output=a3b3c3d2a2e1

```Java
package com.vrk.core.programs;

public class StringManiplation1 {

	
	 public static void main(String []abc) {
		 
		 String str = "aaabbbcccddaae";
		 //Required output : a3b3c3d2a2e1
		 String outStr= getOutPutString(str);
		 System.out.println("Out put : "+outStr);
	 }
	
	public static String getOutPutString(String str) {
		
		StringBuilder sb= new StringBuilder();
        int count=1;
        for(int i=0; i<str.length(); i++) {
        	if(i+1<str.length() && str.charAt(i)==str.charAt(i+1)) {
        		count++;
        	}else {
        		sb.append(str.charAt(i)).append(count);
        		count=1;
        	}
        	
        }
		
		return sb.toString();
	}
	
}

Out Put : a3b3c3d2a2e1
```

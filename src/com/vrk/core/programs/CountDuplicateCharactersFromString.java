package com.vrk.core.programs;

import java.util.LinkedHashMap;
import java.util.Map;

public class CountDuplicateCharactersFromString {

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

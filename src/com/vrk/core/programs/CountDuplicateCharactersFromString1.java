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

package com.vrk.core.programs;

import java.util.Map;
import java.util.TreeMap;

public class PrintMinimumAsciiString {

	public static void main(String[] abc) {

		String str = "hanuma";
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
		System.out.println("Actual values from map with ascii calues  : " + map);
		System.out.println("min Ascii value of element : " + map.values().toArray()[0]);

	}

}

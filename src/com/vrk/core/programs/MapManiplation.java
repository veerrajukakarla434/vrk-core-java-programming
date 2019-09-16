package com.vrk.core.programs;

import java.util.HashMap;
import java.util.Map;

public class MapManiplation {

	public static void main(String[] args) {
		
		Map<String, String>map= new HashMap<>();
		map.put("100", "veera");
		map.put("101", "raju");
		map.put("103", "praveen");
		map.put("104", "veera");
		map.put("105", "praveen");
		map.put("106", "veera");
		map.put("107", "veera");
		map.put("108", "veera");
		map.put("109", "satya");
		
		
		Map<String, String>map1= new HashMap<>();
		
		
		for(Map.Entry<String, String> entry : map.entrySet()) {
			map1.put(entry.getValue(), map1.get(entry.getValue())==null ? entry.getKey() : map1.get(entry.getValue())+","+entry.getKey());
		}
		System.out.println(map1);
       
	}
}

package com.vrk.core.programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapManiplation {

	public static void main(String[] args) {
		
		Map<Integer, String>map= new HashMap<>();
		map.put(100, "veera");
		map.put(101, "raju");
		map.put(103, "praveen");
		map.put(104, "veera");
		map.put(105, "praveen");
		map.put(106, "veera");
		map.put(107, "veera");
		map.put(108, "veera");
		map.put(109, "satya");
		
		
		Map<String, List<Integer>>map1= new HashMap<>();
		
		List<Integer> list=new ArrayList<>();
		
		for(Map.Entry<Integer, String> entry : map.entrySet()) {
			map1.containsKey(entry.getValue());
			list.add(entry.getKey());
		}
		System.out.println(map1);
       
	}
}

package com.vrk.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintKeysFromValuesUsingMAP {

	public static void main(String[] args) {
	   
		Map<Integer, String> map = new HashMap<>();
		
		map.put(1, "rajesh");
		map.put(2, "veera");
		map.put(3, "suresh");
		map.put(4, "rajesh");
		map.put(5, "raju");
		map.put(6, "suresh");
		map.put(7, "rajesh");
		map.put(8, "raju");
		map.put(9,"suresh");
		map.put(10, "raju");
		
		
		Map<String, List<Integer>> resultmap = new HashMap<>();
		
		
		for(Map.Entry<Integer, String> emap : map.entrySet()) {
			
			String name = emap.getValue();
	//		resultValue.add(emap.getKey());
			List<Integer> resultList = resultmap.get(name);
			if(resultList==null) {
				resultList = new ArrayList<>();
				resultList.add(emap.getKey());
				resultmap.put(emap.getValue(), resultList);
				
			}else {
				resultList.add(emap.getKey());
			}
			
			
		}
		
		System.out.println(resultmap);
		
		
		
	}

}

package com.vrk.core.programs.I2020;

import java.util.Map;
import java.util.TreeMap;

public class MostFrequentElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {10, 20, 10,10,10,10, 20, 30, 20, 20};
		
		Map<Integer,Integer> hm = new TreeMap<Integer,Integer>();
		Map<Integer,Integer> hm1 = new TreeMap<Integer,Integer>();
		
		for(int i=0; i<arr.length; i++) {
			 
			if(hm.containsKey(arr[i])) {
				hm.put(arr[i], hm.get(arr[i])+1);
			}else {
				hm.put(arr[i], 1);
			}
		}
		
		for(Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			hm1.put(entry.getValue(), entry.getKey());
			
		}
		System.out.println(hm);
		
		System.out.println(hm1.values().toArray()[hm1.size()-1]+" is Maximum Repeated "+hm.get(hm1.values().toArray()[hm1.size()-1])+" times");
		
	}
	
	
	
	
	

}

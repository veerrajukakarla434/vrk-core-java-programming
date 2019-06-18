package com.vrk.core.programs;

public class IntegerMinMax {
	
	public static void main(String abc[]) {
		Integer arr[] = {22,100,5,7,8,99,33,2,67};
		int min=arr[0];
		int max=0;
		int  lenht=arr.length;
		
		for(int i=0; i<lenht; i++) {
			
			if(arr[i]<min) {
				min=arr[i];
			}
			
			if(arr[i] >max) {
				max=arr[i];
			}
			
		}
		
		System.out.println(min+"<--- min max ---> :"+max);
	}
	
	
	
	
	

}

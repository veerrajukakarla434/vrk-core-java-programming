package com.vrk.core.programs;

public class MaxAndMinElementsFromArray {

	static int max=0;
	static int min=0;
	
	public static void main(String []abc) {
	
	int []aray= {100,-499,-2,6,87,98,405,78,56,43,1};
	int length= aray.length;
	
	for(int i=0; i<length; i++ ) {
		
		if(max<aray[i]) {
			max=aray[i];
		}
		if(min>aray[i]) {
			min=aray[i];
		}
	}
	
	System.out.println("Max Element : "+max);
	System.out.println("Min Element : "+min);

}
}
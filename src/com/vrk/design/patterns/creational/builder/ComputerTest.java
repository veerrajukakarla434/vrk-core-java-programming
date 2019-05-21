package com.vrk.design.patterns.creational.builder;

public class ComputerTest {
	
	public static void main(String[] args) {
		//Using builder to get the object in a single line of code and 
                //without any inconsistent state or arguments management issues		
		Computer comp = new Computer.ComputerBuilder("500 GB", "2 GB")
				.setBluetoothEnabled(true)
				.setGraphicsCardEnabled(true)
				.build();
		System.out.println();
		System.out.println(comp);
		
		// without optional parameters  (which will give default values)
		Computer comp1 = new Computer.ComputerBuilder("500 GB", "2 GB")
				.build();
		
		System.out.println();
		System.out.println(comp1);
	}
}
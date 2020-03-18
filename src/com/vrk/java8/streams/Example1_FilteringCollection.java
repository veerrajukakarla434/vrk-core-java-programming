package com.vrk.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 * 
 * @author veerr
 * This class is introduction about filters using for loop
 */
public class Example1_FilteringCollection {
	
	int id;  
    String name;  
    float price; 
    
	public Example1_FilteringCollection(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	

	@Override
	public String toString() {
		return "Example1_FilteringCollection [id=" + id + ", name=" + name + ", price=" + price + "]";
	}



	public static void main(String[] args) {
		
		List<Example1_FilteringCollection> productsList = new ArrayList<Example1_FilteringCollection>();  
        //Adding Products  
        productsList.add(new Example1_FilteringCollection(1,"HP Laptop",25000f));  
        productsList.add(new Example1_FilteringCollection(2,"Dell Laptop",30000f));  
        productsList.add(new Example1_FilteringCollection(3,"Lenevo Laptop",28000f));  
        productsList.add(new Example1_FilteringCollection(4,"Sony Laptop",28000f));  
        productsList.add(new Example1_FilteringCollection(5,"Apple Laptop",90000f));  
        
        for(Example1_FilteringCollection product: productsList) {
        	if(product.price>30000) {
        		System.out.println(product.price);
        	}
        }
       
       //Enhanced For loop
        for(Example1_FilteringCollection product: productsList) {
        	System.out.println();
        	//System.out.println(product);
        	System.out.println();
        }
        
        
        //Using Streams
        	
        	List<Float> productPriceList2  =productsList.stream()
        			.filter(p->p.price<30000)
        			.map(p->p.price)
        			.collect(Collectors.toList());
        	
        	System.out.println("******** List using Streams > : "+productPriceList2 );
        }
        
        
	
}
	
	
# Java Coding Programs With Solutions

#### Arrays 

```console
1) Shift N-Elements to End of the Array With Same Order
2) Move K - Element/Elements End of the Array
3) Move All Zeros End of the Array
4) Move All Zeros Front Of the Array
5) 
```



1) Shift N-Elements to End of the Array With Same Order 

#### Solution One Using % (Modulo operation)
```text
// Implementation of Modulo or Remainder Operator in Java
% operation how it work
       // Dividend
        int a = 4;
        // Divisor
        int b = 7;
        // Mod
        int k = a % b; => 4
        a = 5, b =7 then a % b => 5
        a = 6, b =7 then a % b => 6
        a = 7, b =7 then a % b => 0
        a = 8, b =7 then a % b => 1
        a = 9, b =7 then a % b => 2
        a = 10, b =7 then a % b => 3
        a = 11, b =7 then a % b => 4
```

```java
public class P0002ShiftArrayWithSameOrder {

	public static void main(String[] args) {
		
		int[] original = { 1, 2, 3, 4, 5, 6, 9 };	
		int[] reordered = new int[original.length];
		int shift = 4;
		
		for (int i = 0; i < original.length; i++) {

			// calculate reordered ArrayIndex With respect to shift elements
			int newArrayIndex = (shift + i)%original.length;
			reordered[i] = original[newArrayIndex];
		}
				
	  for(int a : reordered) {
		  System.out.print(a+" ");
	  }
	}
	
}
```
**OutPut**
```java	  
	   Original:  1 2 3 4 5 6 9
	   output  :  5 6 9 1 2 3 4 
```	









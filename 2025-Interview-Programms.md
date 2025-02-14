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

#### Solution 1 Using % (Modulo operation)
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

#### Solution 2
```java
public class ArrayShift {
    public static void shiftNElementsToEnd(int[] arr, int n) {
        if (arr == null || arr.length <= 1 || n <= 0 || n >= arr.length) {
            return;
        }
        
        // Step 1: Create a temporary array to store first n elements
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = arr[i];
        }
        
        // Step 2: Shift remaining elements to the left
        int left = 0;  // Points to position where elements should be placed
        int right = n; // Points to elements that need to be shifted
        
        while (right < arr.length) {
            arr[left] = arr[right];
            left++;
            right++;
        }
        
        // Step 3: Place the temporary stored elements at the end
        int tempIndex = 0;
        while (left < arr.length) {
            arr[left] = temp[tempIndex];
            left++;
            tempIndex++;
        }
    }
    
    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Original Array: " + java.util.Arrays.toString(arr1));
        
        shiftNElementsToEnd(arr1, 3);
        System.out.println("After shifting 3 elements: " + java.util.Arrays.toString(arr1));
        
        int[] arr2 = {10, 20, 30, 40, 50};
        System.out.println("\nOriginal Array: " + java.util.Arrays.toString(arr2));
        
        shiftNElementsToEnd(arr2, 2);
        System.out.println("After shifting 2 elements: " + java.util.Arrays.toString(arr2));
    }
}
```

**Out Put**


![image](https://github.com/user-attachments/assets/0c15dcd5-2b1d-43e3-a74e-f8e69a304558)







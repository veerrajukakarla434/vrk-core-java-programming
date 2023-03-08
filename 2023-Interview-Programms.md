# 2023-Interview-Programms.md

#### Program
```java
//Program to print half/left pyramid using (star) *
//Out Put:	
	
//	* 
//	* * 
//	* * * 
//	* * * * 
//	* * * * * 
public class Pyramid1 {
	
/**
 * step1 total loops 5
 * step2 loop1 will start 1 to 5
 * step3 inner loop will execute when J<=i;
 */
	public static void main(String[] args) {
		
		int rows=5;
		
		for(int i=1; i<=rows; i++) {
			
			for(int j=1; j<=i; j++) {
				
				System.out.print("*"+" ");
				
			}
			
			System.out.println();
		}
	}
}
```

#### Program
```java
//Program to print Inverted half pyramid using *
//Out Put:	
	
/*	
    * * * * * 
	* * * * 
	* * * 
	* * 
	*
*/
public class Pyramid8 {
	
/**
 * step1 total loops 5
 * step2 loop1 will start 5 to 1
 * step3 inner loop will execute when j<=i and print *;
 */
	public static void main(String[] args) {
		
		int rows=5;
		
		for(int i=rows; i>=1; i--) {
			
			for(int j=1; j<=i; j++) {
				
				System.out.print("*"+" ");
				
			}
			
			System.out.println();
		}
	}
}
```



#### Program

```java
//Program to print half/left pyramid using numbers
//Out Put:	
	/*
	1 
	1 2 
	1 2 3 
	1 2 3 4 
	1 2 3 4 5 */
public class Pyramid {
	
/**
 * step1 total loops 5
 * step2 loop1 will start 1 to 5
 * step3 inner loop will execute when J<=i; and print j
 */
	public static void main(String[] args) {
		
		int rows=5;
		
		for(int i=1; i<=rows; i++) {
			
			for(int j=1; j<=i; j++) {
				
				System.out.print(j+" ");
				
			}
			
			System.out.println();
		}
	}
}
```

#### Program
```
//Program to print Inverted half pyramid using numbers
//Out Put:	
	
/*	
	1 2 3 4 5 
	1 2 3 4 
	1 2 3 
	1 2 
	1 
*/
public class Pyramid9 {
	
/**
 * step1 total loops 5
 * step2 loop1 will start 5 to 1
 * step3 inner loop will execute when j<=i and print j;
 */
	public static void main(String[] args) {
		
		int rows=5;
		
		for(int i=rows; i>=1; i--) {
			
			for(int j=1; j<=i; j++) {
				
				System.out.print(j+" ");
				
			}
			
			System.out.println();
		}
	}
}
```
#### Program
```java
//Program to print Inverted half pyramid using numbers
//Out Put:	
	
/*	
	5 5 5 5 5 
	4 4 4 4 
	3 3 3 
	2 2 
	1
*/
public class Pyramid10 {
	
/**
 * step1 total loops 5
 * step2 loop1 will start 5 to 1
 * step3 inner loop will execute when j<=i and print i;
 */
	public static void main(String[] args) {
		
		int rows=5;
		
		for(int i=rows; i>=1; i--) {
			
			for(int j=1; j<=i; j++) {
				
				System.out.print(i+" ");
				
			}
			
			System.out.println();
		}
	}
}
```


#### Program
```java
//Program to print half/left pyramid using numbers
//Out Put:	
/*	1 
	2 2 
	3 3 3 
	4 4 4 4 
	5 5 5 5 5 */
public class Pyramid3 {
	
/**
 * step1 total loops 5
 * step2 loop1 will start 1 to 5
 * step3 inner loop will execute when J<=i;  and print i
 */
	public static void main(String[] args) {
		
		int rows=5;
		
		for(int i=1; i<=rows; i++) {
			
			for(int j=1; j<=i; j++) {
				
				System.out.print(i+" ");
				
			}
			
			System.out.println();
		}
	}
}
```
#### Program
```java
//Program to print half/left pyramid using numbers
//Out Put:	
/*	5 
	4 4 
	3 3 3 
	2 2 2 2 
	1 1 1 1 1 */
public class Pyramid4 {
	
/**
 * step1 total loops 5
 * step2 loop1 will start 5 to 1
 * step3 inner loop will execute when J>=i;  and print i
 */
	public static void main(String[] args) {
		
		
		for(int i=5; i>=1; i--) {
			
			for(int j=5; j>=i; j--) {
				
				System.out.print(i+" ");
				
			}
			
			System.out.println();
		}
	}
}
```
#### Program
```java
//Program to print half/left pyramid using numbers
//Out Put:	
/*	5 
	5 4 
	5 4 3 
	5 4 3 2 
	5 4 3 2 1 */
public class Pyramid5 {
	
/**
 * step1 total loops 5
 * step2 loop1 will start 5 to 1
 * step3 inner loop will execute when J>=i;  and print j
 */
	public static void main(String[] args) {
		
		int row=5;
		
		for(int i=row; i>=1; i--) {
			
			for(int j=row; j>=i; j--) {
				
				System.out.print(j+" ");
				
			}
			
			System.out.println();
		}
	}
}
```
#### Programm
```java
//Program to print Full pyramid using numbers
//Out Put:	
	
/*	
	1 1 1 1 1 
	2 2 2 2 
	3 3 3 
	4 4 
	5 
*/
public class Pyramid12 {
	
/**
 * step1 total loops 5
 * step2 loop1 will start 5 to 1
 * step3 inner loop will execute when j<=i and print k;
 */
	public static void main(String[] args) {
		
		int rows=5;
		int k=1;
		for(int i=rows; i>=1; i--) {
			
			for(int j=1; j<=i; j++) {
				
				System.out.print(k+" ");
				
			}
			k++;
			System.out.println();
		}
	}
}
```
#### Program
```java
//Program to print Inverted half pyramid using numbers
//Out Put:	
	
/*	
	5 4 3 2 1 
	4 3 2 1 
	3 2 1 
	2 1 
	1  
*/
public class Pyramid13 {
	
/**
 * step1 total loops 5
 * step2 loop1 will start 5 to 1
 * step3 inner loop will execute when j<=i and print k;
 */
	public static void main(String[] args) {
		
		int rows=5;
		for(int i=rows; i>=1; i--) {
			
			for(int j=i; j>=1; j--) {
				System.out.print(j+" ");
			}
			
			System.out.println();
		}
	}
}
```
#### Program
```java
//Program to print Inverted half pyramid using numbers
//Out Put:	
	
/*	
	1 
	2 1 
	3 2 1 
	4 3 2 1 
	5 4 3 2 1 
*/
public class Pyramid14 {
	
	public static void main(String[] args) {
		
		int rows=5;
		for(int i=1; i<=rows; i++) {
			
			for(int j=i; j>=1; j--) {
				System.out.print(j+" ");
			}
			
			System.out.println();
		}
	}
}
```

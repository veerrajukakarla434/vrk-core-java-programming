# Java8_Interview_Interview_Questions -> Interview Programms :: Questions & Answers

## Q1) Squarate given list of intergers using Java8
##### List<Integer> numbers = Arrays.asList(1,2,2,3,5,4,6);
  
```java
* Ans1
```java
List<Integer> squeres = numbers.stream().map(i->i*i).collect(Collectors.toList());                      
```
* Ans2 : Distinct squareroot values

```java
List<Integer> squeres = numbers.stream().map(i->i*i).distinct().collect(Collectors.toList()); 
```

* Ans3 :- Using Functional interface
```java
Function<Integer, Integer> square = x -> x * x;	
List<Integer> sqrs1 = numbers.stream().map(square).distinct().collect(Collectors.toList());
```
* Ans4 :- using math function
```java
numbers.stream().distinct().forEach(n -> System.out.println(n + (int)Math.pow(n, 2)));
```
* Ans5 :- using math function
```java
numbers.stream().distinct().forEach(n -> System.out.println(n + "\t" +(int)Math.sqrt(n)));
```

## Q2) Get count, min, max, sum, and average for given numbers using java 8

```java
List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		
		IntSummaryStatistics stats = primes.stream() .mapToInt((x) -> x) .summaryStatistics();

		System.out.println("Highest prime number in List : " + stats.getMax()); 
		System.out.println("Lowest prime number in List : " + stats.getMin());
		System.out.println("Sum of all prime numbers : " + stats.getSum()); 
		System.out.println("Average of all prime numbers : " + stats.getAverage());
```
OutPut:
```Console
Highest prime number in List : 29
Lowest prime number in List : 2
Sum of all prime numbers : 129
Average of all prime numbers : 12.9
```
## Q3 Merge arraylists – Java 8 Stream.flatMap()
```java
 ArrayList<String> listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
         
	         ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("a", "b", "c", "f", "g"));
	         
	         ArrayList<String> listthree = new ArrayList<>(Arrays.asList("h", "i", "j", "k", "l"));
	         
	         
	         List<String> combinedList = Stream.of(listOne, listTwo, listthree)
                     .flatMap(x -> x.stream())
                     .collect(Collectors.toList());
	         
	         System.out.println("Final list :" +combinedList );
```		 
```Console
[a, b, c, d, e, a, b, c, f, g]
```


	

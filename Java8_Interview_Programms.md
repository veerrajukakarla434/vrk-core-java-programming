# Java 8 Interview Programms - Questions & Answers

#### Q1) Squarate given list of intergers using Java8
##### List<Integer> numbers = Arrays.asList(1,2,2,3,5,4,6);
  
```console
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


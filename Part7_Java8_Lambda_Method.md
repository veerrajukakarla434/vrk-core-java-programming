# Lambda expressions & Method references

#### What is lambda expression?

* Lambda expression is a new and important feature of Java which was included in Java SE 8.
* Lambda expression is anonymous function which have set of parameters and a lambda (->) and a function body .
* You can call it function without name.
* It provides a clear and concise way to represent one method interface using an expression. 
* It is very useful in collection library. 
* It helps to iterate, filter and extract data from collection.

* **The Lambda expression is used to provide the implementation of an interface which has functional interface.** 
* It saves a lot of code. 
* In case of lambda expression, we don't need to define the method again for providing the implementation. 
* Here, we just write the implementation code.
* Java lambda expression is treated as a function, so compiler does not create .class file.

#### Why use Lambda Expression
 * To provide the implementation of Functional interface.
 * Less coding.

#### Where to use the Lambdas in Java
* To use lambda expression, you need to either create your own functional interface or use the pre defined functional interface provided by Java. 
* An interface with only single abstract method is called functional interface(or Single Abstract method interface), for example: Runnable, callable, ActionListener etc.

#### Java Lambda Expression Syntax
```java
(argument-list) -> {body} 
```
* Java lambda expression is consisted of three components.

  * 1) **Argument-list:** It can be empty or non-empty as well.

  * 2) **Arrow-token:** It is used to link arguments-list and body of expression.

  * 3) **Body:** It contains expressions and statements for lambda expression.

* No Parameter Syntax
```java
() -> {  
//Body of no parameter lambda  
} 
```
* One Parameter Syntax
```java
(p1) -> {  
//Body of single parameter lambda  
}
```
* Two Parameter Syntax
```java
(p1,p2) -> {  
//Body of multiple parameter lambda  
} 
```
#### Examples

#### Example 1: Java Lambda Expression with no parameter

```java
Example 1: Java Lambda Expression with no parameter
@FunctionalInterface
interface MyFunctionalInterface {

	//A method with no parameter
    public String sayHello();
}
public class Example {

   public static void main(String args[]) {
        // lambda expression
    	MyFunctionalInterface msg = () -> {
    		return "Hello";
    	};
        System.out.println(msg.sayHello());
    }
}

=========================================================================
Example 2: Java Lambda Expression with single parameter
@FunctionalInterface
interface MyFunctionalInterface {

	//A method with single parameter
    public int incrementByFive(int a);
}
public class Example {

   public static void main(String args[]) {
        // lambda expression with single parameter num
    	MyFunctionalInterface f = (num) -> num+5;
        System.out.println(f.incrementByFive(22));
    }
}
=============================================================================
Example 3: Java Lambda Expression with Multiple Parameters
interface StringConcat {

    public String sconcat(String a, String b);
}
public class Example {

   public static void main(String args[]) {
        // lambda expression with multiple arguments
    	StringConcat s = (str1, str2) -> str1 + str2;
        System.out.println("Result: "+s.sconcat("Hello ", "World"));
    }
}
Output:

Result: Hello World
==================================================================================
Example 4: Iterating collections (List) using foreach loop
import java.util.*;  
public class Example{  
    public static void main(String[] args) {       
       List<String> list=new ArrayList<String>();  
       list.add("Rick");         
       list.add("Negan");       
       list.add("Daryl");         
       list.add("Glenn");         
       list.add("Carl");                
       list.forEach(          
           // lambda expression        
           (names)->System.out.println(names)         
       );     
    }  
}

===========================================================================
Example 5: Iterating Map in Java 8 using Lambda expression
package com.beginnersbook;
import java.util.HashMap;
import java.util.Map;
public class IterateMapUsingLambda {
	public static void main(String[] args) {
		Map<String, Integer> prices = new HashMap<>();
		prices.put("Apple", 50);
		prices.put("Orange", 20);
		prices.put("Banana", 10);
		prices.put("Grapes", 40);
		prices.put("Papaya", 50);
		
		/* Iterate without using Lambda
		   for (Map.Entry<String, Integer> entry : prices.entrySet()) {
		   System.out.println("Fruit: " + entry.getKey() + ", Price: " + entry.getValue());
		   }
		*/ 
		
		prices.forEach((k,v)->System.out.println("Fruit: " + k + ", Price: " + v));

	}
}
Output:

Fruit: Apple, Price: 50
Fruit: Grapes, Price: 40
Fruit: Papaya, Price: 50
Fruit: Orange, Price: 20
Fruit: Banana, Price: 10
```


#### Method reference in java 8

* Method reference is a shorthand notation of a lambda expression to call a method. 
* It is nothing but compact way of lambda expression.
#### Example:
* If your lambda expression is like this:
```java
str -> System.out.println(str)
```
* then you can replace it with a method reference like this:
```java
System.out::println
```
#### Types of Method References

* Four types of method references
  
**METHOD REFERENCE** |	**DESCRIPTION** |	**METHOD REFERENCE EXAMPLE**
---------------------|---------------------|---------------------
Reference to **static method**|	Used to refer static methods from a class |	Math::max equivalent to Math.max(x,y)
Reference to **instance method from instance** |	Refer to an instance method using a reference to the supplied object	|System.out::println equivalent to System.out.println(x)
Reference to **instance method from class type**	|Invoke the instance method on a reference to an object supplied by the context|	String::length equivalent to str.length()
Reference to **constructor** |	Reference to a constructor|	ArrayList::new equivalent to new ArrayList()

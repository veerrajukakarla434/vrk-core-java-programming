# Java 8 Tutorials

Interview Questions :

#### What is lambda expression?

* Lambda expression is anonymous function which have set of parameters and a lambda (->) and a function body .You can call it function without name.

* Refer below examplese about this (#### 1) Java 8 Lambda Expressions with examples)

#### What is method reference in java 8?

* Method reference is used refer method of functional interface. It is nothing but compact way of lambda expression.You can simply replace lambda expression with method reference.

Syntax:
class::methodname

#### What is Optional? Why and how can you use it?

* Java 8 has introduced new class Called Optional. This class is basically introduced to avoid NullPointerException in java.

* Optional is a container object used to contain not-null objects. Optional object is used to represent null with absent value.

* Optional class encapsulates optional value which is either present or not.
* It is a wrapper around object and can be use to avoid NullPointerExceptions.

#### What is the difference between PermGenSpace and MetaSpace?

* In jdk 8 onwards PermGenSpace is removed. Earlier PermGenSpace is used for storing the metadata. Metadata means storing the information about classes like bytecodes, names and JIT information.

* Java classes metadata now stored in native heap and this space is called MetaSpace. Metaspace grows automatically by default and will be garbage collected.

* So the major difference between PermGenSpace and MetaSpace is that PermGenSpace was fixed in size and did not grow automatically, but MetaSpace does not have any size constraints.


**JVM** | **Default maximum PermGen size (MB)** | **Default maximum Metaspace size**
------------------ | -------------------------- | -----------------------------
32-bit client JVM| 64| unlimited
32-bit server JVM| 64| unlimited
64-bit JVM |82	| unlimited

![java14_1](https://www.javainuse.com/java14_1.jpg "java14_1")

* For Detailed description please refer : https://www.javainuse.com/java/metaspace https://dzone.com/articles/permgen-and-metaspace

####  What is the difference between Predicate and Function?

* Both are functional interfaces.
* Predicate<T> is single argument function and either it returns true or false.This can be used as the assignment target for a lambda expression or method reference.

* Function<T,R> is also single argument function but it returns an Object.Here T denotes type of input to the function and R denotes type of Result.

* This can also be used as the assignment target for a lambda expression or method reference.


#### Are you aware of Date and Time API introduced in Java 8? What the issues with Old Date and time API?


* Issues with old Date and TIme API:

* **Thread Safety:** You might be already aware that java.util.Date is mutable and not thread safe. Even java.text.SimpleDateFormat is also not Thread-Safe. New Java 8 date and time APIs are thread safe.

* **Performance:** Java 8 ‘s new APIs are better in performance than old Java APIs.

* **More Readable:**  Old APIs such Calendar and Date are poorly designed and hard to understand. Java 8 Date and Time APIs are easy to understand and comply with ISO standards.


#### What is the difference between Collection API and Stream API?

* Differences between Collection API and Stream API are as follow :

* 1. Collection API was introduced in jdk 1.2 while Stream API is introduced in jdk 1.8
* 2. Collection objects are created eagerly while Stream API objects are created lazily.
* 3. Iterate and Consume elements at any number of times for Collection object while iterate and consume elements only one time for Stream object.


### What is a default method in Java 8 ? When to use it ? 

* Default method is also known as defender methods or virtual extension methods. It is a  non abstract method i.e have body, which can be declared inside interface.

* Default method is introduced in Java 8 for backward compatibility. That is if you add a new abstract method to the interface, all the implementing classes shall break. Implementing classes need to implement the added abstract method. This problem is solved by default method of java 8.

#### What is the difference between Iterator and Spliterator ?

* Difference between Iterator and Spliterator  are as follow:

* 1. Introduction : Iterator was introduced in jdk 1.2 while Spliterator  is introduced in jdk 1.8
* 2. Use in API  : Iterator is used for Collection API while Spliterator is used for Stream API
* 3. Parallel programming : Iterator can be used for iterating the elements in Collection in sequential order while  Spliterator can be used for iterating the Stream elements in parallel or sequential order.
* 4. Universal Iterator : Iteartor is universal iterator while Spliterator is not a universal iterator.

#### What is the difference and similarities between Function and Predicate in java 8?

* **Difference:**

* 1. Return Type : Function returns an Object and it is a single argument function.
* Predicate return type is boolean (i.e true or false) and it is also a single argument function.

* **Similarities:**

* 1. Both are functional interfaces i.e both contain single abstract method.


#### Java 8-Internal vs. External Iteration

* Before we understand forEach statement, let us first look at the concept of Internal Iterators vs External Iterators.

* **External Iterators-** This Iterator is also known as active iterator or explicit iterator. For this type of iterator the control over iteration of elements is with the programmer. Which means that the programmer define when and how the next element of iteration is called.

```java
List<String> items = new ArrayList<>();
		items.add("test1");
		items.add("test2");
		items.add("test3");
		items.add("test4");
		items.add("test5");
		
		//Traditional java for-each iterator which is an External Iterator.
		for (String item : items) {
			System.out.println(item);
		}
```

```java
	
	Map<String, String> map = new HashMap<>();
		map.put("1", "test1");
		map.put("2", "test2");
		map.put("3", "test3");
		map.put("4", "test4");
		map.put("5", "test5");
		map.put("6", "test6");

		//Traditional way of iterating map elements using external iterator.
		 for(Map.Entry<String, String> entry :map.entrySet()) {
		  System.out.println(entry.getKey());
		  System.out.println(entry.getValue()); }
```
* **Internal Iterators-** This Iterator is also known as passive iterator, implicit iterator or callback iterator. For this type of iterator the control over the iteration of elements lies with the iterator itself. The programmer only tells the iterator "What operation is to be performed on the elements of the collection". Thus the programmer only declares what is to be done and does not manage and control how the iteration of individual elements take place.

```java

	List<String> items = new ArrayList<>();
		items.add("test1");
		items.add("test2");
		items.add("test3");
		items.add("test4");
		items.add("test5");
		
		//iterate over list items
		//Java 8 forEach iterator which is an Internal Iterator.
		items.forEach(item -> System.out.println(item));
```
```java	
	Map<String, String> map = new HashMap<>();
		map.put("1", "test1");
		map.put("2", "test2");
		map.put("3", "test3");
		map.put("4", "test4");
		map.put("5", "test5");
		map.put("6", "test6");

		  //iterate over map items
		  //Java 8 forEach iterator which is an Internal Iterator.
		 map.forEach((key,value)->{ 
		  System.out.println(key);
		  System.out.println(value);
		  
		  });
```

#### Java Stream Distinct Examples

* 1. Find All Distinct Elements

* In this example, we have list of strings and we will find all distinct strings, collect them into another list using collect() which is java stream terminal operations. After collecting the distinct elements, we will verify it by printing them to console.

```Java
Collection<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");
 
// Get collection without duplicate i.e. distinct only
List<String> distinctElements = list.stream().distinct().collect(Collectors.toList());
 
//Let's verify distinct elements
System.out.println(distinctElements);
```
Output is:

```Console
[A, B, C, D]
```
Example 2 :

```java
public static void main(String[] args) 
    { 
  
        // Creating a list of integers 
        List<Integer> list = Arrays.asList(1, 1, 2, 3, 3, 4, 5, 5); 
  
        System.out.println("The distinct elements are :"); 
  
        // Displaying the distinct elements in the list 
        // using Stream.distinct() method 
        list.stream().distinct().forEach(System.out::println); 
    } 
```
Output :

```Console
The distinct elements are :
1
2
3
4
5
```
Example 3:

```java
// Driver code 
    public static void main(String[] args) 
    { 
  
        // Creating a list of strings 
        List<String> list = Arrays.asList("Geeks", "for", "Geeks", 
                                          "GeeksQuiz", "for", "GeeksforGeeks"); 
  
        System.out.println("The distinct elements are :"); 
  
        // Displaying the distinct elements in the list 
        // using Stream.distinct() method 
        list.stream().distinct().forEach(System.out::println); 
    } 
```
Output:

```Console
The distinct elements are :
Geeks
for
GeeksQuiz
GeeksforGeeks
```
Example 4:

```java
public static void main(String[] args) 
    { 
  
        // Creating a list of strings 
        List<String> list = Arrays.asList("Geeks", "for", "Geeks", 
                                          "GeeksQuiz", "for", "GeeksforGeeks"); 
  
        // Storing the count of distinct elements 
        // in the list using Stream.distinct() method 
        long Count = list.stream().distinct().count(); 
  
        // Displaying the count of distinct elements 
        System.out.println("The count of distinct elements is : " + Count); 
    } 
 ```
 Ourput :
 
 ```Console
 The count of distinct elements is : 4
 ```
 
 #### Stream In Java
 
 * Introduced in Java 8, the Stream API is used to process collections of objects. A stream is a sequence of objects that supports various methods which can be pipelined to produce the desired result.
* The features of Java stream are –

* A stream is not a data structure instead it takes input from the Collections, Arrays or I/O channels.
* Streams don’t change the original data structure, they only provide the result as per the pipelined methods.
* Each intermediate operation is lazily executed and returns a stream as a result, hence various intermediate operations can be pipelined. Terminal operations mark the end of the stream and return the result.
    
        
* Different Operations On Streams-
* **Intermediate Operations:**

* **map:** The map method is used to returns a stream consisting of the results of applying the given function to the elements of this stream.
List number = Arrays.asList(2,3,4,5);
List square = number.stream().map(x->x*x).collect(Collectors.toList());
* **filter:** The filter method is used to select elements as per the Predicate passed as argument.
List names = Arrays.asList("Reflection","Collection","Stream");
List result = names.stream().filter(s->s.startsWith("S")).collect(Collectors.toList());
* **sorted:** The sorted method is used to sort the stream.
List names = Arrays.asList("Reflection","Collection","Stream");
List result = names.stream().sorted().collect(Collectors.toList());

* Terminal Operations:
* **collect:** The collect method is used to return the result of the intermediate operations performed on the stream.
List number = Arrays.asList(2,3,4,5,3);
Set square = number.stream().map(x->x*x).collect(Collectors.toSet());
* **forEach:** The forEach method is used to iterate through every element of the stream.
List number = Arrays.asList(2,3,4,5);
number.stream().map(x->x*x).forEach(y->System.out.println(y));
* **reduce:** The reduce method is used to reduce the elements of a stream to a single value.
The reduce method takes a BinaryOperator as a parameter.
List number = Arrays.asList(2,3,4,5);
int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);





#### 1) Java 8 Lambda Expressions with examples

* **Lambda expression** is a new feature which is introduced in Java 8. A lambda expression is an anonymous function. A function that doesn’t have a name and doesn’t belong to any class. The concept of lambda expression was first introduced in LISP programming language.

* Java Lambda Expression Syntax :
* To create a lambda expression, we specify input parameters (if there are any) on the left side of the lambda operator ->, and place the expression or block of statements on the right side of lambda operator. For example, the lambda expression (x, y) -> x + y specifies that lambda expression takes two arguments x and y and returns the sum of these.

```Java
//Syntax of lambda expression
(parameter_list) -> {function_body}
```

### Where to use the Lambdas in Java
* To use lambda expression, you need to either create your own functional interface or use the pre defined functional interface provided by Java. An interface with only single abstract method is called functional interface(or Single Abstract method interface), for example: Runnable, callable, ActionListener etc.

* **To use function interface:**
  * Pre Java 8: We create anonymous inner classes.
  * Post Java 8: You can use lambda expression instead of anonymous inner classes.

* **Without using Lambda expression:** Prior to java 8 we used the anonymous inner classe to implement the only abstract method of functional interface.

```Java
package com.vrk.java8.lambdaexpression;

import java.awt.*;  
import java.awt.event.*;

public class ButtonListenerOldWay {

	 public static void main(String[] args) {  
	       Frame frame=new Frame("ActionListener Before Java8");  
	    
	       Button b=new Button("Click Here");  
	       b.setBounds(50,100,80,50);  
	  
	       b.addActionListener(new ActionListener(){  
	          public void actionPerformed(ActionEvent e){  
	    	     System.out.println("Hello World!"); 
	          }  
	       });  
	       frame.add(b);
	    
	       frame.setSize(200,200);  
	       frame.setLayout(null);  
	       frame.setVisible(true);   
	    }  
	 
}
```
* **By using Lambda expression:** Instead of creating anonymous inner class, we can create a lambda expression like this:
```Java
package com.vrk.java8.lamdaexpressions;

import java.awt.*;

public class ButtonListenerNewWay {

	public static void main(String[] args) {  
	      Frame frame=new Frame("ActionListener java8");  
	     
	      Button b=new Button("Click Here");  
	      b.setBounds(50,100,80,50); 
	  
	      b.addActionListener(e -> System.out.println("Hello World!")); 
	      frame.add(b);
	  
	      frame.setSize(200,200);  
	      frame.setLayout(null);  
	      frame.setVisible(true);   
	   }  
	
}
```
### Note:
* 1. As you can see that we used less code with lambda expression.
* 2. Backward compatibility: You can use the lambda expression with your old code. Lambdas are backward compatible so you can use them in existing API when you migrate your project to java 8.

**Lets see few more examples of Lambda expressions.***

#### Example 1: Java Lambda Expression with no parameter

```Java
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
Output:

Hello
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
Output:

27
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
Example 4: Iterating collections using foreach loop
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
```

## 2) Java 8 Java Functional Interfaces

* An Interface that contains exactly one abstract method is known as functional interface. It can have any number of default, static methods but can contain only one abstract method. It can also declare methods of object class.

* Functional Interface is also known as Single Abstract Method Interfaces or SAM Interfaces. It is a new feature in Java, which helps to achieve functional programming approach.

* Java 8 introduces an annotation i.e. @FunctionalInterface too, which can be used for compiler level errors when the interface you have annotated violates the contracts of exactly one abstract method.

#### Example 1

```Java
@FunctionalInterface  
interface sayable{  
    void say(String msg);  
}  
public class FunctionalInterfaceExample implements sayable{  
    public void say(String msg){  
        System.out.println(msg);  
    }  
    public static void main(String[] args) {  
        FunctionalInterfaceExample fie = new FunctionalInterfaceExample();  
        fie.say("Hello there");  
    }  
}  

Output : Hello there
```
* **A functional interface can have methods of object class. See in the following example.**
#### Example 2

```Java
@FunctionalInterface  
interface sayable{  
    void say(String msg);   // abstract method  
    // It can contain any number of Object class methods.  
    int hashCode();  
    String toString();  
    boolean equals(Object obj);  
}  
public class FunctionalInterfaceExample2 implements sayable{  
    public void say(String msg){  
        System.out.println(msg);  
    }  
    public static void main(String[] args) {  
        FunctionalInterfaceExample2 fie = new FunctionalInterfaceExample2();  
        fie.say("Hello there");  
    }  
}  
Output : Hello there
```

* **Invalid Functional Interface**
* A functional interface can extends another interface **only when it does not have any abstract method.**

#### Example 3

```Java
interface sayable{  
    void say(String msg);   // abstract method  
}  
@FunctionalInterface  
interface Doable extends sayable{  
    // Invalid '@FunctionalInterface' annotation; Doable is not a functional interface  
    void doIt();  
}  
Output:
compile-time error
```
##### Example 4

* In the following example, a functional interface is extending to a non-functional interface.
```Java
interface Doable{  
    default void doIt(){  
        System.out.println("Do it now");  
    }  
}  
@FunctionalInterface  
interface Sayable extends Doable{  
    void say(String msg);   // abstract method  
}  
public class FunctionalInterfaceExample3 implements Sayable{  
    public void say(String msg){  
        System.out.println(msg);  
    }  
    public static void main(String[] args) {  
        FunctionalInterfaceExample3 fie = new FunctionalInterfaceExample3();  
        fie.say("Hello there");  
        fie.doIt();  
    }  
} 

``````

#### Java Predefined-Functional Interfaces
* Java provides predefined functional interfaces to deal with functional programming by using lambda and method references.

* You can also define your own custom functional interface. Following is the list of functional interface which are placed in java.util.function package.

**Interface** | **Description**
------------| --------------------------
BiConsumer<T,U> | It represents an operation that accepts two input arguments and returns no result
Consumer<T>     | It represents an operation that accepts a single argument and returns no result.
Function<T,R>   | It represents a function that accepts one argument and returns a result.
Predicate<T>   | It represents a predicate (boolean-valued function) of one argument.
etc....        | etc....

#### Java Method References 

* Refer Link https://www.javatpoint.com/java-8-method-reference
* Refer Link https://howtodoinjava.com/java8/lambda-method-references-example/


## 3) Java 8 Stream
* Java provides a new additional package in Java 8 called java.util.stream. This package consists of classes, interfaces and enum to allows functional-style operations on the elements. You can use stream by importing java.util.stream package.
* A Stream in Java can be defined as a sequence of elements from a source that supports aggregate operations on them. The source here refers to a Collections or Arrays who provides data to a Stream.

* Stream keeps the ordering of the data as it is in the source. The aggregate operations or bulk operations are operations which allow us to express common manipulations on stream elements easily and clearly.

* **Stream provides following features:*

  * Stream does not store elements. It simply conveys elements from a source such as a data structure, an array, or an I/O channel, through a pipeline of computational operations.
  * Stream is functional in nature. Operations performed on a stream does not modify it's source. For example, filtering a Stream obtained from a collection produces a new Stream without the filtered elements, rather than removing elements from the source collection.
  * Stream is lazy and evaluates code only when required.
  * The elements of a stream are only visited once during the life of a stream. Like an Iterator, a new stream must be generated to revisit the same elements of the source.
  * You can use stream to filter, collect, print, and convert from one data structure to other etc. In the following examples, we have apply various operations with the help of stream.
  
  
## Java Stream Filter

* Java stream provides a method filter() to filter stream elements on the basis of given predicate. Suppose you want to get only even elements of your list then you can do this easily with the help of filter method.

* This method takes predicate as an argument and returns a stream of consisting of resulted elements.

#### Signature
```Java
Stream<T> filter(Predicate<? super T> predicate)  
```
* **Parameter**
* **predicate:** It takes Predicate reference as an argument. Predicate is a functional interface. So, you can also pass lambda expression here.

* **Return**
* It returns a new stream.

#### Java Example: Filtering Collection without using Stream

* In the following example, we are filtering data without using stream. This approach we are used before the stream package was released.

```Java
import java.util.*;  
class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
}  
public class JavaStreamExample {  
    public static void main(String[] args) {  
        List<Product> productsList = new ArrayList<Product>();  
        //Adding Products  
        productsList.add(new Product(1,"HP Laptop",25000f));  
        productsList.add(new Product(2,"Dell Laptop",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product(4,"Sony Laptop",28000f));  
        productsList.add(new Product(5,"Apple Laptop",90000f));  
        List<Float> productPriceList = new ArrayList<Float>();  
        for(Product product: productsList){  
              
            // filtering data of list  
            if(product.price<30000){  
                productPriceList.add(product.price);    // adding price to a productPriceList  
            }  
        }  
        System.out.println(productPriceList);   // displaying data  
    }  
}

Output:
[25000.0, 28000.0, 28000.0]
```

#### Java Stream Example: Filtering Collection by using Stream

* Here, we are filtering data by using stream. You can see that code is optimized and maintained. Stream provides fast execution.

```Java
import java.util.*;  
import java.util.stream.Collectors;  
class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
}  
public class JavaStreamExample {  
    public static void main(String[] args) {  
        List<Product> productsList = new ArrayList<Product>();  
        //Adding Products  
        productsList.add(new Product(1,"HP Laptop",25000f));  
        productsList.add(new Product(2,"Dell Laptop",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product(4,"Sony Laptop",28000f));  
        productsList.add(new Product(5,"Apple Laptop",90000f));  
        List<Float> productPriceList2 =productsList.stream()  
                                     .filter(p -> p.price > 30000)// filtering data  
                                     .map(p->p.price)        // fetching price  
                                     .collect(Collectors.toList()); // collecting as list  
        System.out.println(productPriceList2);  
    }  
}

OutPut:
90000.0
```
#### Java Stream Iterating Example
* You can use stream to iterate any number of times. Stream provides predefined methods to deal with the logic you implement. In the following example, we are iterating, filtering and passed a limit to fix the iteration.
```Java
import java.util.stream.*;  
public class JavaStreamExample {  
    public static void main(String[] args){  
        Stream.iterate(1, element->element+1)  
        .filter(element->element%5==0)  
        .limit(5)  
        .forEach(System.out::println);  
    }  
}  
```
OutPut: 
```Console
5
10
15
20
25
```

#### Java Stream Example: Filtering and Iterating Collection
```Java
import java.util.*;  
class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
}  
public class JavaStreamExample {  
    public static void main(String[] args) {  
        List<Product> productsList = new ArrayList<Product>();  
        //Adding Products  
        productsList.add(new Product(1,"HP Laptop",25000f));  
        productsList.add(new Product(2,"Dell Laptop",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product(4,"Sony Laptop",28000f));  
        productsList.add(new Product(5,"Apple Laptop",90000f));  
        // This is more compact approach for filtering data  
        productsList.stream()  
                             .filter(product -> product.price == 30000)  
                             .forEach(product -> System.out.println(product.name));    
    }  
}

```
Output:
```Console
Dell Laptop
```
#### Java Stream Example : reduce() Method in Collection
* This method takes a sequence of input elements and combines them into a single summary result by repeated operation. For example, finding the sum of numbers, or accumulating elements into a list.

* In the following example, we are using reduce() method, which is used to sum of all the product prices.
```Java
import java.util.*;  
class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
}  
public class JavaStreamExample {  
    public static void main(String[] args) {  
        List<Product> productsList = new ArrayList<Product>();  
        //Adding Products  
        productsList.add(new Product(1,"HP Laptop",25000f));  
        productsList.add(new Product(2,"Dell Laptop",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product(4,"Sony Laptop",28000f));  
        productsList.add(new Product(5,"Apple Laptop",90000f));  
        // This is more compact approach for filtering data  
        Float totalPrice = productsList.stream()  
                    .map(product->product.price)  
                    .reduce(0.0f,(sum, price)->sum+price);   // accumulating price  
        System.out.println(totalPrice);  
        // More precise code   
        float totalPrice2 = productsList.stream()  
                .map(product->product.price)  
                .reduce(0.0f,Float::sum);   // accumulating price, by referring method of Float class  
        System.out.println(totalPrice2);  
          
    }  
} 
``` 
Output:
```Console
201000.0
201000.0
```
#### Java Stream Example: Sum by using Collectors Methods

* We can also use collectors to compute sum of numeric values. In the following example, we are using Collectors class and it?s specified methods to compute sum of all the product prices.

```Java
import java.util.*;  
import java.util.stream.Collectors;  
class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
}  
public class JavaStreamExample {  
    public static void main(String[] args) {  
        List<Product> productsList = new ArrayList<Product>();  
        //Adding Products  
        productsList.add(new Product(1,"HP Laptop",25000f));  
        productsList.add(new Product(2,"Dell Laptop",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product(4,"Sony Laptop",28000f));  
        productsList.add(new Product(5,"Apple Laptop",90000f));  
        // Using Collectors's method to sum the prices.  
        double totalPrice3 = productsList.stream()  
                        .collect(Collectors.summingDouble(product->product.price));  
        System.out.println(totalPrice3);  
          
    }  
} 
``` 
Output:
```Console
201000.0
```
#### Java Stream Example: Find Max and Min Product Price
* Following example finds min and max product price by using stream. It provides convenient way to find values without using imperative approach.

```Java
import java.util.*;  
class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
}  
public class JavaStreamExample {  
    public static void main(String[] args) {  
        List<Product> productsList = new ArrayList<Product>();  
        //Adding Products  
        productsList.add(new Product(1,"HP Laptop",25000f));  
        productsList.add(new Product(2,"Dell Laptop",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product(4,"Sony Laptop",28000f));  
        productsList.add(new Product(5,"Apple Laptop",90000f));  
        // max() method to get max Product price   
        Product productA = productsList.stream()  
                        .max((product1, product2)->   
                        product1.price > product2.price ? 1: -1).get();  
          
        System.out.println(productA.price);  
        // min() method to get min Product price  
        Product productB = productsList.stream()  
                .max((product1, product2)->   
                product1.price < product2.price ? 1: -1).get();  
        System.out.println(productB.price);  
          
    }  
} 
``` 
Output:
```Console
90000.0
25000.0
```
#### Java Stream Example: count() Method in Collection

```Java
import java.util.*;  
class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
}  
public class JavaStreamExample {  
    public static void main(String[] args) {  
        List<Product> productsList = new ArrayList<Product>();  
        //Adding Products  
        productsList.add(new Product(1,"HP Laptop",25000f));  
        productsList.add(new Product(2,"Dell Laptop",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product(4,"Sony Laptop",28000f));  
        productsList.add(new Product(5,"Apple Laptop",90000f));  
        // count number of products based on the filter  
        long count = productsList.stream()  
                    .filter(product->product.price<30000)  
                    .count();  
        System.out.println(count);  
    }  
}  
```
Output:
```Console
3
```
* **stream allows you to collect your result in any various forms. You can get you result as set, list or map and can perform manipulation on the elements.**

#### Java Stream Example : Convert List into Set

```Java
import java.util.*;  
import java.util.stream.Collectors;  
class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
}  
  
public class JavaStreamExample {  
    public static void main(String[] args) {  
        List<Product> productsList = new ArrayList<Product>();  
  
        //Adding Products  
        productsList.add(new Product(1,"HP Laptop",25000f));  
        productsList.add(new Product(2,"Dell Laptop",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product(4,"Sony Laptop",28000f));  
        productsList.add(new Product(5,"Apple Laptop",90000f));  
          
        // Converting product List into Set  
        Set<Float> productPriceList =   
            productsList.stream()  
            .filter(product->product.price < 30000)   // filter product on the base of price  
            .map(product->product.price)  
            .collect(Collectors.toSet());   // collect it as Set(remove duplicate elements)  
        System.out.println(productPriceList);  
    }  
} 
``` 
Output:
```Console
[25000.0, 28000.0]
```
#### Java Stream Example : Convert List into Map
```Java
import java.util.*;  
import java.util.stream.Collectors;  
class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
}  
  
public class JavaStreamExample {  
    public static void main(String[] args) {  
        List<Product> productsList = new ArrayList<Product>();  
  
        //Adding Products  
        productsList.add(new Product(1,"HP Laptop",25000f));  
        productsList.add(new Product(2,"Dell Laptop",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product(4,"Sony Laptop",28000f));  
        productsList.add(new Product(5,"Apple Laptop",90000f));  
          
        // Converting Product List into a Map  
        Map<Integer,String> productPriceMap =   
            productsList.stream()  
                        .collect(Collectors.toMap(p->p.id, p->p.name));  
              
        System.out.println(productPriceMap);  
    }  
} 
``` 
Output:
```Console
{1=HP Laptop, 2=Dell Laptop, 3=Lenevo Laptop, 4=Sony Laptop, 5=Apple Laptop}
```
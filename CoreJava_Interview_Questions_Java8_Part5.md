# Java 8 Tutorials

#### 1) Java 8 Lambda Expressions 
#### 2) Java 8 Java Functional Interfaces
#### 3) Java 8 Stream




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


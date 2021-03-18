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
#### What is method reference in java 8?

* Method reference is used refer method of functional interface. 
* It is nothing but compact way of lambda expression.
* You can simply replace lambda expression with method reference.
Syntax:
class::methodname

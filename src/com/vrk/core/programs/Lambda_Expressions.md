# Lambda Expressions & Method references

* Lambda expressions are an anonymous function, meaning that A function that doesn’t have a name and doesn’t belong to any class.
* The Lambda expression is used to provide the implementation of an interface which is know as functional interface.
* An interface which has only one abstract method is called functional interface. Java provides an anotation @FunctionalInterface, 
  which is used to declare an interface as functional interface. 
 * (OR)
* An interface with only single abstract method is called functional interface(or **Single Abstract method(SAM)interface**), for example: Runnable, callable, ActionListener etc.

* Java lambda expressions are Java's first step into functional programming.
* Lambda expression provides implementation of functional interface.

#### Why use Lambda Expression OR Advantages 

* One of the benefits of using lambda expression is the reduced amount of code.
* To provide the implementation of Functional interface.

#### Lambda expression vs method in Java

* **A method (or function) in Java has these main parts:**
  * 1. Name
  * 2. Parameter list
  * 3. Body
  * 4. return type.
  
  ```java
  Example :
  public String getName(){
  return "Veerraju"
  }
```
* **A lambda expression in Java has these main parts:**
  * Lambda expression only has body and parameter list.
  * 1. No name – function is anonymous so we don’t care about the name
  * 2. Parameter list
  * 3. Body – This is the main part of the function.
  * 4. No return type – The java 8 compiler is able to infer the return type by checking the code. you need not to mention it explicitly.
  ```java
  () -> {  
   System.out.println("Welcom to Lambda Expression")
}  
```

# Lambda Expressions & Method references

* Lambda expressions are an anonymous function, meaning that A function that doesn’t have a name and doesn’t belong to any class.
* The Lambda expression is used to provide the implementation of an interface which is know as functional interface.
* An interface which has only one abstract method is called functional interface. Java provides an anotation @FunctionalInterface, 
  which is used to declare an interface as functional interface. 
 * (OR)
* An interface with only single abstract method is called functional interface(or **Single Abstract method(SAM)interface**), for example: Runnable, callable, ActionListener etc.

* Java lambda expressions are Java's first step into functional programming.
* Lambda expression provides implementation of functional interface.

* **To use function interface:**
* **Pre Java 8: We create anonymous inner classes.**
* **Post Java 8: You can use lambda expression instead of anonymous inner classes.**

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

#### Java Lambda Expression Syntax

```java
(argument-list) -> {body}  
```
* Java lambda expression is consisted of three components.

* **1) Argument-list: It can be empty or non-empty as well.**
```java
No Parameter Syntax
() -> {  
//Body of no parameter lambda  
}  
```

* **2) Arrow-token: It is used to link arguments-list and body of expression.**
```java
One Parameter Syntax
(p1) -> {  
//Body of single parameter lambda  
}  
```

* **3) Body: It contains expressions and statements for lambda expression.**
```java
Two Parameter Syntax

(p1,p2) -> {  
//Body of multiple parameter lambda  
}  
```

#### Without Lambda Expression
```java
interface Drawable{  
    public void draw();  
}  
public class LambdaExpressionExample {  
    public static void main(String[] args) {  
        int width=10;  
  
        //without lambda, Drawable implementation using anonymous class  
        Drawable d=new Drawable(){  
            public void draw(){System.out.println("Drawing "+width);}  
        };  
        d.draw();  
    }  
}  
```

```java
@FunctionalInterface  //It is optional  
interface Drawable{  
    public void draw();  
}  
  
public class LambdaExpressionExample2 {  
    public static void main(String[] args) {  
        int width=10;  
          
        //with lambda  
        Drawable d2=()->{  
            System.out.println("Drawing "+width);  
        };  
        d2.draw();  
    }  
}  
```






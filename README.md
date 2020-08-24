# vrk-core-java-programming


#### Core Java: java8 (Fetures, Java 11 fetures)
         
       Data Types
       Hello World
       OOPS:
       Inheritance
       Abstraction
       polymarphisum
       Encapsilation
       Loops
       Java Keywords (53)
       Strings
       Threads
       Collection
       List, Set, Map
       Generics
       JDBC - MYSQL

#### Advanced Java: (Mysql)

* JDBC   
* Servlet 
* JSP      
* INterduction about Struts and 
* Spring
    * Spring Core
    * Spring MVC
    * Spring Data
    * Spring ORM (JPA, Hibernate,HIbates...etc)
    * Tomcat, Weblogic,Webspeare ....ect     

##### More Advanced :- Java Microservices
   
* Spring Boot 
* WebServices (RESTFUL, SOAP)
* Exception Handling
* Unit Testing (Junits) Mokito
* Spring cloud
* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

## Java Variables and Data Type

#### Variable Declaration:

* What is a Variable in Java?

 * Variable in Java is a data container that stores the data values during Java program execution. Every variable is assigned data type which designates the type and quantity of value it can hold. Variable is a memory location name of the data. The Java variables have mainly three types : Local, Instance and Static. 
 
* In order to use a variable in a program you to need to perform 2 steps 
**1. Variable Declaration**
**2. Variable Initialization**

#### Variable Declaration:

* To declare a variable, you must specify the data type & give the variable a unique name.

![](https://www.guru99.com/images/uploads/2012/07/VriableTypeNameDeclaration.jpg)

* Examples of other Valid Declarations are 

```console
int a,b,c;

float pi;

double d;

char a;
```

##### Variable Initialization:

To initialize a variable, you must assign it a valid value.

![java-varibale-initialization](https://www.guru99.com/images/uploads/2012/07/java-varibale-initialization.jpg)

Example of other Valid Initializations are 

```console
int a=2,b=4,c=6;

float pi=3.14f;

double do=20.22d;

char a=’v’;
```

#### Types of variables

* In Java, there are three types of variables: 

**1.Local Variables**

**2.Instance Variables**

**3. Static Variables**


#### 1) Local Variables

* Local Variables are a variable that are declared inside the body of a method. 

#### 2) Instance Variables

* Instance variables are defined without the STATIC keyword .They are defined Outside a method declaration. They are Object specific and are known as instance variables. 

#### 3) Static Variables

* Static variables are initialized only once, at the start of the program execution. These variables should be initialized first, before the initialization of any instance variables. 

Example: Types of Variables in Java
```java
class Demo {
    static int a = 1; //static variable  
    int data = 99; //instance variable  
    void method() {
        int b = 90; //local variable  
    }
}
```


#### What is Data Types in Java?

* Data Types in Java are defined as specifiers that allocate different sizes and types of values that can be stored in the variable or an identifier. Java has a rich set of data types. 
* Data types in Java can be divided into two parts : 
* **1.Primitive Data Types :-**  which include integer, character, boolean, and float 
* **2.Non-primitive Data Types :-**  which include classes, arrays and interfaces. 

![DataTypes](https://www.guru99.com/images/java/DataTypes.png)

Primitive Data Types

Primitive Data Types are predefined and available within the Java language. Primitive values do not share state with other primitive values.

There are 8 primitive types: byte, short, int, long, char, float, double, and boolean Integer data types 

```Console
byte (1 byte)
short (2 bytes)
int (4 bytes)
long (8 bytes)
```
![java-varaibles](https://www.guru99.com/images/uploads/2012/07/java-varaibles.jpg)

#### Floating Data Type 
```Console
float (4 bytes)

double (8 bytes)
```
* char 
```java
(2 bytes)
```
* Logical
```java
boolean (1 byte) (true/false)
```

**Data Type** | **Default Value**  | **Default size**
----------|--------------|---------------
byte      |   0       |      1 byte  
short    |    0       |      2 bytes  
int     |     0       |      4 bytes  
long   |     0L       |     8 bytes  
float  |   0.0f      |      4 bytes  
double   |  0.0d      |      8 bytes  
boolean  |  false     |      1 bit  
char    |  '\u0000'    |     2 bytes  

## Object Oriented Programming (OOPs) Concept in Java

* **Object-oriented programming System(OOPs)** is a programming paradigm based on the concept of “objects” that contain data and methods. The primary purpose of object-oriented programming is to increase the flexibility and maintainability of programs. Object oriented programming brings together data and its behaviour(methods) in a single location(object) makes it easier to understand how a program works. We will cover each and every feature of OOPs in detail so that you won’t face any difficultly understanding OOPs Concepts.

![Object-Oriented-Programming-Concepts](https://media.geeksforgeeks.org/wp-content/cdn-uploads/20190717114649/Object-Oriented-Programming-Concepts.jpg)

#### OOPs Concepts – Table of Contents

* 1.What is an Object
* 2.What is a class
* 3.Constructor in Java
* 4.Object Oriented Programming Features •Abstraction
  * Encapsulation
  * Inheritance
  * Polymorphism

* 5.Abstract Class and Methods
* 6.Interfaces in Java


### What is an Object ?

* Object is an instance of a class (which means one class can have at least in ine instance or more)

* Object: is a bundle of data and its behaviour(often known as methods).

* Objects have two characteristics: They have states and behaviors.
```java
Examples of states and behaviors
Example 1:
Object: House
State: Address, Color, Area
Behavior: Open door, close door
```
* So if I had to write a class based on states and behaviours of House. I can do it like this: States can be represented as instance variables and behaviours as methods of the class. We will see how to create classes in the next section of this guide.

```java
class House {
   String address;
   String color;
   double are;
   void openDoor() {
      //Write code here
   }
   void closeDoor() {
      //Write code here
   }
 ...
 ...
}
```
* **Note:** As we have seen above, the states and behaviors of an object, can be represented by variables and methods in the class respectively.

#### Characteristics of Objects:

* If you find it hard to understand Abstraction and Encapsulation, do not worry as I have covered these topics in detail with examples in the next section of this guide.
  * 1.Abstraction
  * 2.Encapsulation
  * 3.Message passing

* **Abstraction:** Abstraction is a process where you show only “relevant” data and “hide” unnecessary details of an object from the user.

* **Encapsulation:**  Encapsulation simply means binding object state(fields) and behaviour(methods) together. If you are creating class, you are doing encapsulation.

* **Message passing :**
  * A single object by itself may not be very useful. An application contains many objects. One object interacts with another object by invoking methods on that object. It is also referred to as Method Invocation. 

* **What is a Class in OOPs Concepts**

* A class can be considered as a blueprint using which you can create as many objects as you like. For example, here we have a class Website that has two data members (also known as fields, instance variables and object states). This is just a blueprint, it does not represent any website, however using this we can create Website objects (or instances) that represents the websites. We have created two objects, while creating objects we provided separate properties to the objects using constructor.

```java
public class Website {
   //fields (or instance variable)
   String webName;
   int webAge;

   // constructor
   Website(String name, int age){
      this.webName = name;
      this.webAge = age;
   }
   public static void main(String args[]){
      //Creating objects
      Website obj1 = new Website("beginnersbook", 5);
      Website obj2 = new Website("google", 18);

     //Accessing object data through reference
     System.out.println(obj1.webName+" "+obj1.webAge);
     System.out.println(obj2.webName+" "+obj2.webAge);
   }
}
```
**Output:**
```java
beginnersbook 5
google 18
```


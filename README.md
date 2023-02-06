# vrk-core-java-programming


#### Core Java: java8 (Fetures)
         
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
       Java I/O
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
* 4.Object Oriented Programming Features 
  * Abstraction
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

#### What is a Constructor ?

* Constructor looks like a method but it is in fact not a method. It’s name is same as class name and it does not return any value. You must have seen this statement in almost all the programs I have shared above:
```java
MyClass obj = new MyClass();
```
* If you look at the right side of this statement, we are calling the default constructor of class myClass to create a new object (or instance).

* We can also have parameters in the constructor, such constructors are known as parametrized constructors.

* Example of constructor
```java
public class ConstructorExample {

   int age;
   String name;
	
   //Default constructor
   ConstructorExample(){
	this.name="Chaitanya";
	this.age=30;
   }
	
   //Parameterized constructor
   ConstructorExample(String n,int a){
	this.name=n;
	this.age=a;
   }
   public static void main(String args[]){
	ConstructorExample obj1 = new ConstructorExample();
	ConstructorExample obj2 = 
		       new ConstructorExample("Steve", 56);
	System.out.println(obj1.name+" "+obj1.age);
	System.out.println(obj2.name+" "+obj2.age);
   }
}
```
**Output:**
```java
Chaitanya 30
Steve 56
```

## Object Oriented Programming features

* **OOPS is about developing an application around its data, i.e. objects which provides the access to their properties and the possible operations in their own way.**

##### 1) Abstraction

* Abstraction is a process where you show only “relevant” data and “hide” unnecessary details of an object from the user. 
* For example, when you login to your bank account online, you enter your user_id and password and press login, what happens when you press login, how the input data sent to server, how it gets verified is all abstracted away from the you. 

* Another example of abstraction: A car in itself is a well-defined object, which is composed of several other smaller objects like a gearing system, steering mechanism, engine, which are again have their own subsystems. But for humans car is a one single object, which can be managed by the help of its subsystems, even if their inner details are unknown.

Example:
```java
// An example abstract class in Java 
abstract class Shape { 
    int color; 
  
    abstract void draw();  
} 
```

#### Abstract Class 

* **Points to Remember**

* A class which contains the abstract keyword in its declaration is known as abstract class.
* Abstract classes may or may not contain abstract methods, i.e., methods without body ( public void get(); )
* But, if a class has at least one abstract method, then the class must be declared abstract.
* If a class is declared abstract, it cannot be instantiated.
* To use an abstract class, you have to inherit it from another class, provide implementations to the abstract methods in it.
* If you inherit an abstract class, you have to provide implementations to all the abstract methods in it.
* It can have constructors and static methods also.
* It can have final methods which will force the subclass not to change the body of the method.

#### Ways to achieve Abstraction
* There are two ways to achieve abstraction in java
  * 1.Abstract class (0 to 100%)
  * 2.Interface (100%)

* Abstract class in Java

A class which is declared as abstract is known as an abstract class. It can have abstract and non-abstract methods. It needs to be extended and its method implemented. It cannot be instantiated.

#### 1) Example of Abstract class that has an abstract method

* In this example, Bike is an abstract class that contains only one abstract method run. Its implementation is provided by the Honda class.

```java
abstract class Bike{  
	abstract void run();  
} 

class Honda4 extends Bike { 
  void run()
  {
  System.out.println("running safely");
  }  

public static void main(String args[]){  
  Bike obj = new Honda4();  
  obj.run();  
 }  
}  
```
OutPut
```Console
running safely
```
#### 2) Understanding the real scenario of Abstract class

* In this example, Shape is the abstract class, and its implementation is provided by the Rectangle and Circle classes.

* Mostly, we don't know about the implementation class (which is hidden to the end user), and an object of the implementation class is provided by the **factory method.**

* A **factory method** is a method that returns the instance of the class. We will learn about the factory method later.

* In this example, if you create the instance of Rectangle class, draw() method of Rectangle class will be invoked.

```java

abstract class Shape{  
 abstract void draw();  
 }  
 
 //In real scenario, implementation is provided by others i.e. unknown by end user  
 class Rectangle extends Shape{  
 void draw(){
 System.out.println("drawing rectangle");
 }  
 }


class Circle1 extends Shape{  
void draw(){
System.out.println("drawing circle");
}  
}  
//In real scenario, method is called by programmer or user  
class TestAbstraction1{  
public static void main(String args[]){  
Shape s=new Circle1();//In a real scenario, object is provided through method, e.g., getShape() method  
s.draw();  
}  
}
```
```Console
drawing circle
```
#### 3) Another example of Abstract class in java

```java
abstract class Bank{    
abstract int getRateOfInterest();    
} 

class SBI extends Bank{    
int getRateOfInterest(){return 7;}    
}   

class PNB extends Bank{    
int getRateOfInterest(){return 8;}    
}    

    
class TestBank{    
public static void main(String args[]){    
Bank b;  
b=new SBI();  
System.out.println("Rate of Interest is: "+b.getRateOfInterest()+" %");    
b=new PNB();  
System.out.println("Rate of Interest is: "+b.getRateOfInterest()+" %");    
}}    
```
```Console
Rate of Interest is: 7 %
Rate of Interest is: 8 %
```
#### 4) Abstract class having constructor, data member and methods

```java
//Example of an abstract class that has abstract and non-abstract methods  
abstract class Bike{  
   Bike(){System.out.println("bike is created");}  
   abstract void run();  
   void changeGear(){System.out.println("gear changed");}  
 }  
//Creating a Child class which inherits Abstract class  
 class Honda extends Bike{  
 void run(){System.out.println("running safely..");}  
 }  

//Creating a Test class which calls abstract and non-abstract methods  
class TestAbstraction2{  
 public static void main(String args[]){  
 Bike obj = new Honda();  
obj.run();  
 obj.changeGear();  
 }  
}  

```
Output
```Console
 bike is created
 running safely..
 gear changed
```
##### 2) Interface

* Interface looks like a class but it is not a class. 
* An interface can have methods and variables just like the class but the methods declared in interface are by default abstract.
* The variables declared in an interface are public, static & final by default. 

* The interface in Java is a mechanism to achieve abstraction. There can be only abstract methods in the Java interface, not method body. It is used to achieve abstraction and multiple inheritance in Java.

* It cannot be instantiated just like the abstract class.
* **Since Java 8, we can have default and static methods in an interface.**
* **Since Java 9, we can have private methods in an interface.**

##### Why use Java interface?

* There are mainly three reasons to use interface. They are given below.
  * It is used to achieve abstraction.
  * By interface, we can support the functionality of multiple inheritance.
  * It can be used to achieve loose coupling.
  
* **What is the difference between abstract class and interface ?**

**Abstract class** | **Interface**
------------ | -------------
Abstract class can have abstract and non-abstract methods | Interface can have only abstract methods. Since Java 8, it can have default and static methods also.
Abstract class doesn't support multiple inheritance	| Interface supports multiple inheritance.
Abstract class can have final, non-final, static and non-static variables.	| Interface has only static and final variables.
Abstract class can provide the implementation of interface.	| Interface can't provide the implementation of abstract class.
The abstract keyword is used to declare abstract class.	| The interface keyword is used to declare interface.
An abstract class can extend another Java class and implement multiple Java interfaces.	| An interface can extend another Java interface only.
An abstract class can be extended using keyword "extends".	| An interface can be implemented using keyword "implements".
A Java abstract class can have class members like private, protected, etc.	| Members of a Java interface are public by default.
public abstract class Shape{ public abstract void draw(); }	| public interface Drawable{ void draw(); }

### Interfaces

* An interface is a 100% abstract class. It can have only static, final, and public fields and abstract methods. It’s frequently referred to as a blueprint of a class as well. Java interfaces allow us to implement multiple inheritance in our code, as a class can implement any number of interfaces. Classes can access an interface using the implements keyword.

* In the example, define two interfaces, Animal and Bird. Animal has two abstract methods, while Bird has two static fields and an abstract method.

```Java
interface Animal {
	public void eat();
	public void sound();
}

interface Bird {
	int numberOfLegs = 2;
	String outerCovering = "feather";

	public void fly();
}
```
The class Eagle implements both interfaces. It defines its own functionality for the three abstract methods. The eat() and sound() methods come from the Animal class, while fly() comes from Bird.
```Java
class Eagle implements Animal, Bird {
	public void eat() {
		System.out.println("Eats reptiles and amphibians.");
	}
	public void sound() {
		System.out.println("Has a high-pitched whistling sound.");
	}
	public void fly() {
		System.out.println("Flies up to 10,000 feet.");
	}
}
```
* In the TestEagle test class, instantiate a new Eagle object (called myEagle) and print out all the fields and methods to the console.
* As static fields don’t belong to a specific object but to a whole class, you need to access them from the Bird interface instead of the myEagle object.
```Java
class TestEagle {
	public static void main(String[] args) {
		Eagle myEagle = new Eagle();

		myEagle.eat();
		myEagle.sound();
		myEagle.fly();

		System.out.println("Number of legs: " + Bird.numberOfLegs);
		System.out.println("Outer covering: " + Bird.outerCovering);
	}
}
```
The Java console returns all the information you wanted to access:
```Console
[Console output of TestEagle]
Eats reptiles and amphibians.
Has a high-pitched whistling sound.
Flies up to 10,000 feet.
Number of legs: 2
Outer covering: feather
```

### Encapsulation
* Encapsulation allows us to protect the data stored in a class from system-wide access. As its name suggests, it safeguards the internal contents of a class like a real-life capsule. You can implement encapsulation in Java by keeping the fields (class variables) private and providing public getter and setter methods to each of them. Java Beans are examples of fully encapsulated classes.

![Encapsulation](https://media.geeksforgeeks.org/wp-content/uploads/Encapsulation.jpg "Encapsulation")

* Encapsulation in Java:
  * Restricts direct access to data members (fields) of a class.
  * Fields are set to private
  * Each field has a getter and setter method
  * Getter methods return the field
  * Setter methods let us change the value of the field

* With encapsulation, you can protect the fields of a class. To do so, declare the fields as private and providing access to them with getter and setter methods.

* The Animal class below is fully encapsulated. It has three private fields and each of them has its own set of getter and setter methods.

```Java
class Animal {
	private String name;
	private double averageWeight;
	private int numberOfLegs;

	// Getter methods
	public String getName() {
		return name;
	}
	public double getAverageWeight() {
		return averageWeight;
	}
	public int getNumberOfLegs() {
		return numberOfLegs;
	}

	// Setter methods
	public void setName(String name) {
		this.name = name;
	}
	public void setAverageWeight(double averageWeight) {
		this.averageWeight = averageWeight;
	}
	public void setNumberOfLegs(int numberOfLegs) {
		this.numberOfLegs = numberOfLegs;
	}
}
```
* The TestAnimal class first sets a value for each field with the setter methods, then prints out the values using the getter methods.
```Java
public class TestAnimal {
	public static void main(String[] args) {
		Animal myAnimal = new Animal();

		myAnimal.setName("Eagle");
		myAnimal.setAverageWeight(1.5);
		myAnimal.setNumberOfLegs(2);

		System.out.println("Name: " + myAnimal.getName());
		System.out.println("Average weight: " + myAnimal.getAverageWeight() + "kg");
		System.out.println("Number of legs: " + myAnimal.getNumberOfLegs());
	}
}
```
* As you can see below, the Java console returns properly all the values you set with the setter methods:
```Console
[Console output of TestAnimal]
Name: Eagle
Average weight: 1.5kg
Number of legs: 2
```

### Inheritance

* Inheritance allows us to extend a class with child classes that inherit the fields and methods of the parent class. It’s an excellent way to achieve code reusability. In Java, we need to use the extends keyword to create a child class.

* In the example, the Eagle class extends the Bird parent class. It inherits all of its fields and methods, plus defines two extra fields that belong only to Eagle.
```Java
class Bird {
	public String reproduction = "egg";
	public String outerCovering = "feather";

	public void flyUp() {
		System.out.println("Flying up...");
	}
	public void flyDown() {
		System.out.println("Flying down...");
	}
}

class Eagle extends Bird {
	public String name = "eagle";
	public int lifespan = 15;
}
```
* The TestEagle class instantiates a new Eagle object and prints out all the information (both the inherited fields and methods and the two extra fields defined in the Eagle class).
```Java
class TestEagle {
	public static void main(String[] args) {		
		Eagle myEagle = new Eagle();

		System.out.println("Name: " + myEagle.name); 			
		System.out.println("Reproduction: " + myEagle.reproduction);
		System.out.println("Outer covering: " + myEagle.outerCovering);
		System.out.println("Lifespan: " + myEagle.lifespan); 		
		myEagle.flyUp();
		myEagle.flyDown(); 		
	}
}
```
* You can see the console output below:
```Console
[Console output of TestEagle]
Reproduction: another egg
Outer covering: feather
Lifespan: 15
Flying up...
Flying down...
```

### Polymorphism

* Polymorphism makes it possible to use the same entity in different forms. In Java, this means that you can declare several methods with the same name until they are different in certain characteristics. Java provides us with two ways to implement polymorphism: method overloading and method overriding.

**Static polymorphism:**

* Method overloading means that you can have several methods with the same name within a class. However, the number, names, or types of their parameters need to be different.

* For example, the Bird() class below has three fly() methods. The first one doesn’t have any parameters, the second one has one parameter (height), and the third one has two parameters (name and height).
```Java
class Bird {
	public void fly() {
		System.out.println("The bird is flying.");
	}
	public void fly(int height) {
		System.out.println("The bird is flying " + height + " feet high.");
	}
	public void fly(String name, int height) {
		System.out.println("The " + name + " is flying " + height + " feet high.");
	}
}
```
* The test class instantiates a new Bird object and calls the fly() method three times. Firstly, without parameters, secondly, with one integer parameter for height, and thirdly, with two parameters for name and height.
```Java
class TestBird {
	public static void main(String[] args) {
		Bird myBird = new Bird();

		myBird.fly();
		myBird.fly(10000);
		myBird.fly("eagle", 10000);
	}
}
```
* In the console, we can see that Java could have differentiated the three polymorphic fly() methods:
```Java
[Console output of TestBird]
The bird is flying.
The bird is flying 10000 feet high.
The eagle is flying 10000 feet high.
```

**Dynamic polymorphism:**

* By using the method overriding feature of Java, you can override the methods of a parent class from its child class.

* The Bird class extends the Animal class in the example below. Both have an eat() method. By default, Bird inherits its parent’s eat() method. However, as it also defines its own eat() method, Java will override the original method and call eat() from the child class.

```Java
class Animal {
	public void eat() {
		System.out.println("This animal eats insects.");
	}
}

class Bird extends Animal {

	public void eat() {
		System.out.println("This bird eats seeds.");
	}

}
```
* The TestBird class first instantiates a new Animal object and calls its eat() method. Then, it also creates a Bird object and calls the polymorphic eat() method again.
```Java
class TestBird {
	public static void main(String[] args) {
		Animal myAnimal = new Animal();
		myAnimal.eat();

		Bird myBird = new Bird();
		myBird.eat();
	}
}
```
* The console returns the values of the relevant methods properly. Therefore Java could have differentiated the two eat() methods indeed.
```Console
[Console output of TestBird]
This animal eats insects.
This bird eats seeds.
```
#### Java Loops:

* Looping in programming languages is a feature which facilitates the execution of a set of instructions/functions repeatedly while some condition evaluates to true.
Java provides three ways for executing the loops. While all the ways provide similar basic functionality, they differ in their syntax and condition checking time.

#### While Loop:
 * The Java while loop is used to iterate a part of the program several times. If the number of iteration is not fixed, it is recommended to use while loop.
 
 ```Console
 Syntax :
while (boolean condition)
{
   loop statements...
}
```
![Loop1](https://media.geeksforgeeks.org/wp-content/uploads/Loop1.png "Loop1")

* Examples
```java
public class WhileExample {  
public static void main(String[] args) {  
    int i=1;  
    while(i<=10){  
        System.out.println(i);  
    i++;  
    }  
}  
} 
```
**OutPut:**

```Console
1
2
3
4
5
6
7
8
9
10
```
##### Java Infinitive While Loop
* If you pass true in the while loop, it will be infinitive while loop.

Syntax:
```java
while(true){  
//code to be executed  
} 
```
* Example:
```java
public class WhileExample2 {  
public static void main(String[] args) {  
    while(true){  
        System.out.println("infinitive while loop");  
    }  
}  
}  
```
**Output:**

```Console
infinitive while loop
infinitive while loop
infinitive while loop
infinitive while loop
infinitive while loop
ctrl+c 
```
### Java do-while Loop

* The Java do-while loop is used to iterate a part of the program several times. If the number of iteration is not fixed and you must have to execute the loop at least once, it is recommended to use do-while loop.

* The Java do-while loop is executed at least once because condition is checked after loop body.
```java
Syntax:
do
{
    statements..
}
while (condition);
```
![](https://media.geeksforgeeks.org/wp-content/uploads/loop3.png "loop3")

* do while loop starts with the execution of the statement(s). There is no checking of any condition for the first time.
* After the execution of the statements, and update of the variable value, the condition is checked for true or false value. If it is evaluated to true, next iteration of loop starts.
* When the condition becomes false, the loop terminates which marks the end of its life cycle.
* It is important to note that the do-while loop will execute its statements atleast once before any condition is checked, and therefore is an example of exit control loop.
```java
public class DoWhileExample2 {  
public static void main(String[] args) {  
    do{  
        System.out.println("infinitive do while loop");  
    }while(true);  
}  
}  

Output:

infinitive do while loop
infinitive do while loop
infinitive do while loop
ctrl+c
```
* **what is difference between while and do while loop**

* do-while loop is similar to while loop, however there is a difference between them: In while loop, condition is evaluated first and then the statements inside loop body gets executed, on the other hand in do-while loop, statements inside do-while gets executed first and then the condition is evaluated.

#### Java For Loop
* The Java for loop is used to iterate a part of the program several times. If the number of iteration is fixed, it is recommended to use for loop.
* Syntax:

```java
for (initialization condition; testing condition; 
                              increment/decrement)
{
    statement(s)
}
```
![loop2](https://media.geeksforgeeks.org/wp-content/uploads/loop2.png "loop2")

* **Initialization condition:** Here, we initialize the variable in use. It marks the start of a for loop. An already declared variable can be used or a variable can be declared, local to loop only.
* **Testing Condition:** It is used for testing the exit condition for a loop. It must return a boolean value. It is also an Entry Control Loop as the condition is checked prior to the execution of the loop statements.
* **Statement execution:** Once the condition is evaluated to true, the statements in the loop body are executed.
* **Increment/ Decrement:** It is used for updating the variable for next iteration.
* **Loop termination:** When the condition becomes false, the loop terminates marking the end of its life cycle.

#### Examples:

```java
class forLoopDemo 
{ 
    public static void main(String args[]) 
    { 
        // for loop begins when x=2 
        // and runs till x <=4 
        for (int x = 2; x <= 4; x++) 
            System.out.println("Value of x:" + x); 
    } 
} 

OutPut:

Value of x:2
Value of x:3
Value of x:4
*****************************

public class ForEachExample {  
public static void main(String[] args) {  
    //Declaring an array  
    int arr[]={12,23,44,56,78};  
    //Printing array using for-each loop  
    for(int i:arr){  
        System.out.println(i);  
    }  
}  
}  

OutPut: 
12
23
44
56
78

**********************************************
```
#### Enhanced For loop
* Enhanced for loop is useful when you want to iterate Array/Collections, it is easy to write and understand.
```java
class ForLoopExample3 {
   public static void main(String args[]){
      int arr[]={2,11,45,9};
      for (int num : arr) {
         System.out.println(num);
      }
   }
}

OutPut:
2
11
45
9

*******************
String arr[]={"hi","hello","bye"};
for (String str : arr) {
         System.out.println(str);
}

OutPut:
hi
hello
bye

```
#### Java Key words
* Java Reserved words are 53 including used, unused and literals 

![Reserved+Words](https://slideplayer.com/slide/9347846/28/images/17/Reserved+Words.jpg "Reserved+Words")

## For Easy Remember Category wise Keywords

### **Keywords for Data types (8):**

* byte, short, int, long, float, double, char and boolean.

### **Keywords for FlowControl (11):** 

* if, else, switch, case, default, do, while, for, break, continue and return.

### **Keywords for ExceptionHandling(6):** 

* try, catch, finally, throw, throws, assert 

### **Keywords for Modifers(11):** 

* public, private, protected, final, abstract, static
* native, synchronized, volatile, transient, strictfp

### **Class Related Keywords(6):**

*  class,interface, package, extends, implements, import

### **Object Related Keywords(4):**
* new, instanceof, super, this

### **void return type Keywords(1):**
 * if a method doesn’t return anything compulsory that method should be with void return type
 
### **UnUsed Keywords(2):**
* goto  in java usage is considered as harmful.
* const  alternatively we should use final keyword.

### **Enum Keyword(1):**
* This keyword has introduced in 1.5 version, to define user defined data types.

### **Reserved Literals(3):**
* true
* false Allowed values for boolean data types
* null Default value for object reference

#### Java Strings
* In Java, string is basically an object that represents sequence of char values. An array of characters works same as Java string.
* Strings are used for storing text.
* A String variable contains a collection of characters surrounded by double quotes:

* **What is String in java**
* Generally, String is a sequence of characters. But in Java, string is an object that represents a sequence of characters. The java.lang.String class is used to create a string object.

* Java String class provides a lot of methods to perform operations on strings such as **compare(), concat(), equals(), split(), length(), replace(), compareTo(), intern(), substring()** etc.

* The java.lang.String class implements Serializable, Comparable and CharSequence interfaces.

![string-implements](https://static.javatpoint.com/images/core/string-implements.png "string-implements")

#### CharSequence Interface
* The CharSequence interface is used to represent the sequence of characters. String, StringBuffer and StringBuilder classes implement it. It means, we can create strings in java by using these three classes.

![charsequence](https://static.javatpoint.com/images/core/charsequence.png "charsequence")

* The Java String is immutable which means it cannot be changed. Whenever we change any string, a new instance is created. For mutable strings, you can use StringBuffer and StringBuilder classes.

* We will discuss immutable string later. Let's first understand what is String in Java and how to create the String object.

* **How to create a string object?**
* There are two ways to create String object:
  * By string literal
  * By new keyword

* **1) String Literal**
* Java String literal is created by using double quotes. For Example:
```java
String s="welcome"; 
```
* Each time you create a string literal, the JVM checks the "string constant pool" first. If the string already exists in the pool, a reference to the pooled instance is returned. If the string doesn't exist in the pool, a new string instance is created and placed in the pool. For example:
```java
String s1="Welcome";  
String s2="Welcome";//It doesn't create a new instance  
```
![string](https://static.javatpoint.com/images/string.JPG "")

* In the above example, only one object will be created. Firstly, JVM will not find any string object with the value "Welcome" in string constant pool, that is why it will create a new object. After that it will find the string with the value "Welcome" in the pool, it will not create a new object but will return the reference to the same instance.

```Console
Note: String objects are stored in a special memory area known as the "string constant pool".
```
#### Why Java uses the concept of String literal?
* To make Java more memory efficient (because no new objects are created if it exists already in the string constant pool).

* **2) By new keyword**
```java
String s=new String("Welcome");//creates two objects and one reference variable  
```
* In such case, JVM will create a new string object in normal (non-pool) heap memory, and the literal "Welcome" will be placed in the string constant pool. The variable s will refer to the object in a heap (non-pool).

```java
Java String Example
public class StringExample{  
public static void main(String args[]){  
String s1="java";//creating string by java string literal  
char ch[]={'s','t','r','i','n','g','s'};  
String s2=new String(ch);//converting char array to string  
String s3=new String("example");//creating java string by new keyword  
System.out.println(s1);  
System.out.println(s2);  
System.out.println(s3);  
}}  

out Put :
java
strings
example
```
#### Why String is Immutable or Final in Java ?

* String pool is possible only because String is immutable in Java. This way Java Runtime saves a lot of heap space because different String variables can refer to the same String variable in the pool. If String would not have been immutable, then String interning would not have been possible because if any variable would have changed the value, it would have been reflected in the other variables too.

* If String is not immutable then it would cause a severe security threat to the application. For example, database username, password are passed as String to get database connection and in socket programming host and port details passed as String. Since String is immutable, its value can’t be changed otherwise any hacker could change the referenced value to cause security issues in the application.

* Since String is immutable, it is safe for multithreading. A single String instance can be shared across different threads. This avoids the use of synchronization for thread safety. Strings are implicitly thread-safe.

* Strings are used in java classloader and immutability provides security that correct class is getting loaded by Classloader. For example, think of an instance where you are trying to load java.sql.Connection class but the referenced value is changed to myhacked.Connection class that can do unwanted things to your database.

* Since String is immutable, its hashcode is cached at the time of creation and it doesn’t need to be calculated again. This makes it a great candidate for the key in a Map and its processing is faster than other HashMap key objects. This is why String is the most widely used as HashMap keys.

#### What is String Pool in Java ?

* As the name suggests, String Pool in java is a pool of Strings stored in Java Heap Memory. We know that String is special class in java and we can create String object using new operator as well as providing values in double quotes.

* Here is a diagram which clearly explains how String Pool is maintained in java heap space and what happens when we use different ways to create Strings.
![String-Pool-Java1](https://cdn.journaldev.com/wp-content/uploads/2012/11/String-Pool-Java1.png "String-Pool-Java1")

* String Pool is possible only because String is immutable in Java and its implementation of String interning concept. String pool is also example of Flyweight design pattern.

* However using new operator, we force String class to create a new String object in heap space. We can use intern() method to put it into the pool or refer to another String object from the string pool having the same value.


```Java
package com.journaldev.util;

public class StringPool {

    /**
     * Java String Pool example
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "Cat";
        String s2 = "Cat";
        String s3 = new String("Cat");
        
        System.out.println("s1 == s2 :"+(s1==s2));
        System.out.println("s1 == s3 :"+(s1==s3));
        System.out.println("s1.equals(s3) :"+(s1.equals(s3)));
        System.out.println("s1.equals(s2) :"+(s1.equals(s2)));
    }

}
```

Output of the above program is:

```Console
s1 == s2 :true
s1 == s3 :false
s1.equals(s3) :true
s1.equals(s2) :true
```

#### How many Strings are getting Created in the String Pool?

* Sometimes in java interview, you will be asked a question around String pool. For example, how many strings are getting created in the below statement;

```Java
String str = new String("Cat");
```

* In the above statement, either 1 or 2 string will be created. If there is already a string literal “Cat” in the pool, then only one string “str” will be created in the pool. If there is no string literal “Cat” in the pool, then it will be first created in the pool and then in the heap space, so a total of 2 string objects will be created.

#### final vs Immutability in Java

* **final :** In Java, final is a modifier which is used for class, method and variable also. When a variable is declared with final keyword, it’s value can’t be modified, essentially, a constant.

* **Immutability :** In simple terms, immutability means unchanging over time or unable to be changed. In Java, we know that String objects are immutable means we cant change anything to the existing String objects.

* final means that you can’t change the object’s reference to point to another reference or another object, but you can still mutate its state (using setter methods e.g). Whereas immutable means that the object’s actual value can’t be changed, but you can change its reference to another one.
* final modifier is applicable for variable but not for objects, Whereas immutability applicable for an object but not for variables.
* By declaring a reference variable as final, we won’t get any immutability nature, Even though reference variable is final. We can perform any type of change in the corresponding Object. But we cant perform reassignment for that variable.
* final ensures that the address of the object remains the same whereas the Immutable suggests that we can’t change the state of the object once created.

```Java
// Java program to illustrate 
// difference between final 
// and immutability 
  
class Geeks { 
    public static void main(String[] args) 
    { 
        final StringBuffer sb = new StringBuffer("Hello"); 
  
        // Even though reference varibale sb is final 
        // We can perform any changes 
        sb.append("GFG"); 
  
        System.out.println(sb); 
  
        // Here we will get Compile time error 
        // Because reassignment is not possible for final variable 
        sb = new StringBuffer("Hello World"); 
  
        System.out.println(sb); 
    } 
} 
```
Output:

```Console
Geeks.java:14: error: cannot assign a value to final variable sb
        sb = new StringBuffer("Hello World");
        ^
1 error

```
* **Pictorial Representation of the above Program**
![Untitled-32](https://media.geeksforgeeks.org/wp-content/uploads/Untitled-32.png "Untitled-32")

* **Explanation:** In the above picture, we can see that we are creating an object of StringBuffer class by making reference final.

* Declaring reference variable as final, does not mean that the object is immutable.
* In the next line we are performing append() operation on the created object and it is successfully changed.
* If the object is immutable, then the above append operation can’t be done.
* But it is executed successfully as we declare reference variable as final. final means we can’t reassign anything to that reference variable again.
* Therefore when we try to create a new object of BufferedReader then it wont created any object by throwing an error to the console.

#### Java String Oerations:

#### Java String intern()

* Let’s try to understand intern() method with a simple program.

```Java
package com.journaldev.string;

public class StringIntern {

	public static void main(String args[]) {

		String s1 = new String("abc"); // goes to Heap Memory, like other objects
		String s2 = "abc"; // goes to String Pool
		String s3 = "abc"; // again, goes to String Pool

		// Let's check out above theories by checking references
		System.out.println("s1==s2? " + (s1 == s2)); // should be false
		System.out.println("s2==s3? " + (s2 == s3)); // should be true

		// Let's call intern() method on s1 now
		s1 = s1.intern(); // this should return the String with same value, BUT from String Pool

		// Let's run the test again
		System.out.println("s1==s2? " + (s1 == s2)); // should be true now

	}
}
```

Output:

```Console
s1==s2? false
s2==s3? true
s1==s2? true
```
**String intern() Example Explanation**
* When we are using new operator, the String is created in the heap space. So “s1” object is created in the heap memory with value “abc”.
* When we create string literal, it’s created in the string pool. So “s2” and “s3” are referring to string object in the pool having value “abc”.
* In the first print statement, s1 and s2 are referring to different objects. Hence s1==s2 is returning false.
* In the second print statement, s2 and s3 are referring to the same object in the pool. Hence s2==s3 is returning true.
* Now, when we are calling s1.intern(), JVM checks if there is any string in the pool with value “abc” is present? Since there is a string object in the pool with value “abc”, its reference is returned.
* Notice that we are calling s1 = s1.intern(), so the s1 is now referring to the string pool object having value “abc”.
* At this point, all the three string objects are referring to the same object in the string pool. Hence s1==s2 is returning true now.

#### Get Length of a String
* To find the length of a string, we use the length() method of the String. For example,
```java
class Main {
  public static void main(String[] args) {

    // create a string
    String greet = "Hello! World";
    System.out.println("String: " + greet);

    // get the length of greet
    int length = greet.length();
    System.out.println("Length: " + length);
  }
}
Output

String: Hello! World
Length: 12
```
##### Join two Strings
* We can join two strings in Java using the concat() method. For example,
```java
class Main {
  public static void main(String[] args) {

    // create first string
    String first = "Java ";
    System.out.println("First String: " + first);

    // create second
    String second = "Programming";
    System.out.println("Second String: " + second);

    // join two strings
    String joinedString = first.concat(second);
    System.out.println("Joined String: " + joinedString);
  }
}
Output

First String: Java 
Second String: Programming     
Joined String: Java Programming
```
#### Compare two Strings
* In Java, we can make comparisons between two strings using the equals() method. For example,
```java
class Main {
  public static void main(String[] args) {

    // create 3 strings
    String first = "java programming";
    String second = "java programming";
    String third = "python programming";

    // compare first and second strings
    boolean result1 = first.equals(second);
    System.out.println("Strings first and second are equal: " + result1);

    // compare first and third strings
    boolean result2 = first.equals(third);
    System.out.println("Strings first and third are equal: " + result2);
  }
}
Output

Strings first and second are equal: true
Strings first and third are equal: false
```
* In the above example, we have created 3 strings named first, second, and third. Here, we are using the equal() method to check if one string is equal to another.

* The equals() method checks the content of strings while comparing them. 

#### Java String compare
* we can compare string in java on the basis of content and reference.

* It is used in authentication (by equals() method), sorting (by compareTo() method), reference matching (by == operator) etc.

* There are three ways to compare string in java:

  * By equals() method
  * By = = operator
  * By compareTo() method
#### 1) String compare by equals() method
* The String equals() method compares the original content of the string. It compares values of string for equality. String class provides two methods:

  * **public boolean equals(Object another)*  compares this string to the specified object.
  * **public boolean equalsIgnoreCase(String another)** compares this String to another string, ignoring case.
```java
class Teststringcomparison1{  
 public static void main(String args[]){  
   String s1="Sachin";  
   String s2="Sachin";  
   String s3=new String("Sachin");  
   String s4="Saurav";  
   System.out.println(s1.equals(s2));//true  
   System.out.println(s1.equals(s3));//true  
   System.out.println(s1.equals(s4));//false  
 }  
}  

Output:true
       true
       false
 ************************************************      
class Teststringcomparison2{  
 public static void main(String args[]){  
   String s1="Sachin";  
   String s2="SACHIN";  
  
   System.out.println(s1.equals(s2));//false  
   System.out.println(s1.equalsIgnoreCase(s2));//true  
 }  
}  

Output:

false
true
```

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

## Data Types in Java

Data types specify the different sizes and values that can be stored in the variable. There are two types of data types in Java: 

1.Primitive data types: 
               The primitive data types include boolean, char, byte, short, int, long, float and double.
			   
2.Non-primitive data types:
             The non-primitive data types include Classes, Interfaces, and Arrays.
      
       

#### Java Data Types


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





# Java Interview Questions

* **1) Java Basics**
* **2) Java OOPS**
* **3) Java Strings**
* **4) Java Exceptions**
* **5) Java Threads**
* **6) Java Generics**
* **7) Java Collections**
* **8) Java 7,8 Futures**

## LANGUAGE FUNDAMENTALS

Java Reserved words are 53 including used, unused and literals 

![Reserved-Keywords1](http://www.java2learn.com/wp-content/uploads/2015/06/Reserved-Keywords1.png  "Reserved-Keywords1")


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

* In details of reserved words Link : https://www.javatpoint.com/java-keywords


### Java Data Types:

![datatype](http://theoryofprogramming.azurewebsites.net/wp-content/uploads/2015/05/datatype.png "datatype")

### Range Of Data types:

![java-basics-user-input-data-type-constructor-18-638](https://image.slidesharecdn.com/lect3-basicsuserinputdatatypeconstructor-150219175632-conversion-gate01/95/java-basics-user-input-data-type-constructor-18-638.jpg?cb=1424368743 "java-basics-user-input-data-type-constructor-18-638") 

### **1) Java Basics:**

* **Differences between JDK, JRE and JVM**

**JVM:**
* JVM (Java Virtual Machine) is an abstract machine. It is called a virtual machine because it doesn't physically exist. It is a specification that provides a runtime environment in which Java bytecode can be executed. It can also run those programs which are written in other languages and compiled to Java bytecode.

* JVMs are available for many hardware and software platforms. JVM, JRE, and JDK are platform dependent because the configuration of each OS is different from each other. However, Java is platform independent. There are three notions of the JVM: specification, implementation, and instance.

* The JVM performs the following main tasks:

* **Loads code**
* **Verifies code**
* **Executes code**
* **Provides runtime environment**   


**JRE:**

* JRE is an acronym for Java Runtime Environment. It is also written as Java RTE. The Java Runtime Environment is a set of software tools which are used for developing Java applications. It is used to provide the runtime environment. It is the implementation of JVM. It physically exists. It contains a set of libraries + other files that JVM uses at runtime.


* JDK is an acronym for Java Development Kit. The Java Development Kit (JDK) is a software development environment which is used to develop Java applications and applets. It physically exists. It contains JRE + development tools.

* JDK is an implementation of any one of the below given Java Platforms released by Oracle Corporation:

* **Standard Edition Java Platform***
* **Enterprise Edition Java Platform**
* **Micro Edition Java Platform**
* The JDK contains a private Java Virtual Machine (JVM) and a few other resources such as an interpreter/loader (java), a compiler (javac), an archiver (jar), a documentation generator (Javadoc), etc. to complete the development of a Java Application.

OR 

* **JDK – Java Development Kit** (in short JDK) is Kit which provides the environment to develop and execute(run) the Java program. JDK is a kit(or package) which includes two things
Development Tools(to provide an environment to develop your java programs)
JRE (to execute your java program).
Note : JDK is only used by Java Developers.

* **JRE – Java Runtime Environment** (to say JRE) is an installation package which provides environment to only run(not develop) the java program(or application)onto your machine. JRE is only used by them who only wants to run the Java Programs i.e. end users of your system.

* **JVM – Java Virtual machine(JVM)** is a very important part of both JDK and JRE because it is contained or inbuilt in both. Whatever Java program you run using JRE or JDK goes into JVM and JVM is responsible for executing the java program line by line hence it is also known as interpreter.

![JDK_JRE_JVM_x](https://media.geeksforgeeks.org/wp-content/uploads/JDK_JRE_JVM_x.jpg "JDK_JRE_JVM_x")

* **How JVM Works – JVM Architecture?**

* JVM(Java Virtual Machine) acts as a run-time engine to run Java applications. JVM is the one that actually calls the main method present in a java code. JVM is a part of JRE(Java Runtime Environment).

* Java applications are called WORA (Write Once Run Anywhere). This means a programmer can develop Java code on one system and can expect it to run on any other Java enabled system without any adjustment. This is all possible because of JVM.

* When we compile a .java file, .class files(contains byte-code) with the same class names present in .java file are generated by the Java compiler. This .class file goes into various steps when we run it. These steps together describe the whole JVM.

![jvm-3](https://media.geeksforgeeks.org/wp-content/uploads/jvm-3.jpg "jvm-3")

### OR

![JVM-Architecture](https://javainterviewpoint-7ac9.kxcdn.com/wp-content/uploads/2016/01/JVM-Architecture.png "JVM-Architecture")

### Class Loader Subsystem

* It is mainly responsible for three activities.
   *  Loading
   *  Linking
   *  Initialization

* **Loading :** The Class loader reads the .class file, generate the corresponding binary data and save it in method area. For each .class file, JVM stores following information in method area.

   *  Fully qualified name of the loaded class and its immediate parent class.
   *  Whether .class file is related to Class or Interface or Enum
   *  Modifier, Variables and Method information etc.

```java

// A Java program to demonstrate working of a Class type 
// object created by JVM to represent .class file in 
// memory. 
import java.lang.reflect.Field; 
import java.lang.reflect.Method; 
  
// Java code to demonstrate use of Class object 
// created by JVM 
public class Test 
{ 
    public static void main(String[] args) 
    { 
        Student s1 = new Student(); 
  
        // Getting hold of Class object created 
        // by JVM. 
        Class c1 = s1.getClass(); 
  
        // Printing type of object using c1. 
        System.out.println(c1.getName()); 
  
        // getting all methods in an array 
        Method m[] = c1.getDeclaredMethods(); 
        for (Method method : m) 
            System.out.println(method.getName()); 
  
        // getting all fields in an array 
        Field f[] = c1.getDeclaredFields(); 
        for (Field field : f) 
            System.out.println(field.getName()); 
    } 
} 
  
// A sample class whose information is fetched above using 
// its Class object. 
class Student 
{ 
    private String name; 
    private int roll_No; 
  
    public String getName()  {  return name;   } 
    public void setName(String name) { this.name = name; } 
    public int getRoll_no()  { return roll_No;  } 
    public void setRoll_no(int roll_no) { 
        this.roll_No = roll_no; 
    } 
} 

```

**Note :** For every loaded .class file, only one object of Class is created.



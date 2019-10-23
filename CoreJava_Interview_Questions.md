# Java Interview Questions

* **1) Java Basics**
* **2) Java OOPS**
* **3) Java Strings**
* **4) Java Exceptions**
* **5) Java Threads**
* **6) Java Generics**
* **7) Java Collections**
* **8) Java 7,8 Futures**

## 1) Java Basics

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

### What is a JVM in Java ?
* A Virtual Machine is a Software implementation of a Physical Machine, Java was developed with the concept of WORA ( Write Once Run Anywhere ) which runs on a VM. The compiler will be compiling the java file into a java .class file.  The .class file is input to JVM which Loads and executes the class file. Below goes the Architecture of JVM.

![JVM-Architecture](https://javainterviewpoint-7ac9.kxcdn.com/wp-content/uploads/2016/01/JVM-Architecture.png "JVM-Architecture")


### How JVM works in Java ?

* As shown in the above architecture diagram JVM is divided into three main subsystems

**1. Class Loader Subsystem**

**2. Runtime Data Area**

**3. Execution Engine**

### 1. Class Loader Subsystem

* Java’s dynamic class loading functionality is handled by the class loader subsystem. It loads, links and initializes the class when it refers to a class for the first time at runtime, not at compile-time.
It performs three major functionality such as 

   *  Loading
   *  Linking
   *  Initialization.
   
#### 1.1 Loading
 
* Classes will be loaded by this component. BootStrap ClassLoader, Extension ClassLoader, Application ClassLoader are the three class loader which will help in achieving it.

   * **BootStrap ClassLoader:** – Responsible for loading classes from the bootstrap classpath, nothing but rt.jar. Highest priority will be given to this loader.

   * **Extension ClassLoader:** – Responsible for loading classes which are inside ext folder (jre\lib)

   * **Application ClassLoader:** –Responsible for loading Application Level Classpath, path mentioned Environment Variable etc.
The above Class Loaders will follow Delegation Hierarchy Algorithm while loading the class files.

#### 1.2 Linking

   * **Verify:** – Bytecode verifier will verify whether the generated bytecode is proper or not if verification fails we will get verification error

   * **Prepare:** – For all static variables memory will be allocated and assigned with default values.

   * **Resolve:** – All symbolic memory references are replaced with the original references from Method Area.


#### 1.3 Initialization

* This is the final phase of Class Loading, here all static variable will be assigned with the original values and static block will be executed.

### 2. Runtime Data Area

* Runtime Data Area is divided into 5 major components

**1. Method Area:** – All the Class level data will be stored here including static variables. Method Area is one per JVM and it is a shared resource.

**2. Heap Area:** – All the Objects and its corresponding instance variables and arrays will be stored here. Heap Area is also one per JVM since Method area and Heap area shares memory for multiple threads the data stored is not thread safe.

**3. Stack Area:** – For every thread, a separate runtime stack will be created. For every method call, one entry will be made in the stack memory which is called as Stack Frame. All local variables will be created in the stack memory. Stack area is thread safe since it is not a shared resource. Stack Frame is divided into three sub-entities such as

   * **Local Variable Array:** – Related to the method how many local variables are involved and the corresponding values will be stored here.
   
   * **Operand stack:** – If any intermediate operation is required to perform, operand stack act as runtime workspace to perform the operation.
   
   * **Frame data:** – All symbols corresponding to the method is stored here. In the case of any exception, the catch block information will be maintained in the frame data.


**4. PC Registers:** – Each thread will have separate PC Registers, to hold address of current executing instruction once the instruction is executed the PC register will be updated with the next instruction

**5. Native Method stacks:** – Native Method Stack holds native method information. For every thread, separate native method stack will be created.


### 3. Execution Engine

* The bytecode which is assigned to the Runtime Data Area will be executed by the Execution Engine. The Execution Engine reads the byte code and executes one by one.

**1. Interpreter:** – Reads the bytecode, interprets it and executes it one by one. The interpreter interprets the bytecode faster but executes slowly. The disadvantage of the interpreter is that when one method called multiple times, every time interpretation is required.

**2. JIT Compiler:** – JIT Compiler neutralizes the disadvantage of the Interpreter ( a single method called multiple times, each time interpretation is required ), The Execution Engine will be using the help of Interpreter in converting but when it found repeated code it uses JIT compiler which compiles the entire bytecode and changes it to native code.  This native code will be used directly for repeated method calls which improve the performance of the system.

  **1. Intermediate Code generator** – produces intermediate code
  
  **2. Code Optimizer** – Code Optimizer is responsible for optimizing the intermediate code generated above
  
  **3. Target Code Generator** – Target Code Generator is responsible for Generating Machine Code/ Native Code
  
  **4. Profiler** – Profiler is a special component, it is responsible for finding the hotspots (i.e) Used to identify whether the      method is called multiple time or not.

**3. Garbage Collector:** Garbage Collector is a part of Execution Engine, it collects/removes the unreferenced objects. Garbage Collection can be triggered by calling “System.gc()”, but the execution is not guaranteed. Garbage collector of JVM collects only those objects that are created by new keyword. So if you have created any object without new, you can use finalize method to perform cleanup.


#### Java Native Interface (JNI):
  * JNI will be interacting with the Native Method Libraries and provides the Native Libraries required for the Execution Engine.

#### Native Method Libraries : 
* It is a Collection of the Native Libraries which is required for the Execution Engine.


## 2) Java OOPS

* Java is a class-based object-oriented programming (OOP) language that is built around the concept of objects. OOP concepts (OOP) intend to improve code readability and reusability by defining how to structure a Java program efficiently. The main principles of object-oriented programming are:

* Java comes with specific code structures for each OOP principle. For example, the extends keyword for inheritance or getter and setter methods for encapsulation.

**1. Abstraction**

**2. Encapsulation**

**3. Inheritance**

**4. Polymorphism**

**5. Association**

**6. Aggregation**

**7. Composition**


### Abstraction:

* Abstraction aims to hide complexity from the users and show them only the relevant information.
* For example, if you want to drive a car, you don’t need to know about its internal workings. The same is true of Java classes. 
You can hide internal implementation details by using abstract classes or interfaces. On the abstract level, you only need to define 
the method signatures (name and parameter list) and let each class implement them in their own way.

* Abstraction in Java:

  * Hides the underlying complexity of data
  * Helps avoid repetitive code
  * Presents only the signature of internal functionality
  * Gives flexibility to programmers to change the implementation of the abstract behaviour
  * Partial abstraction (0-100%) can be achieved with abstract classes
  * **Total abstraction (100%) can be achieved with interfaces**


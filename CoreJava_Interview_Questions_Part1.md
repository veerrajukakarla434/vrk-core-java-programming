# Java Interview Questions

* **1) Java Basics**
* **2) Java OOPS**
* **3) Java Strings**
* **4) Java Exceptions**
* **5) Java Threads**
* **6) Java Generics**
* **7) Java Collections**
* **8) Java 7,8 Futures**

Reference : https://howtodoinjava.com/interview-questions/core-java-interview-questions-series-part-1/

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

* **Can abstract class have Constructor in Java ?**

Yes, an abstract class can have a constructor in Java. You can either explicitly provide a constructor to abstract class or if you don't, the compiler will add default constructor of no argument in abstract class. This is true for all classes and it also applies to an abstract class. For those who want to recall what is an abstract class in Java, it's a class which can not be instantiated with new() operator or any other ways. In order to use an abstract class in Java,  You need to extend it and provide a concrete class. Abstract class is commonly used to define a base class for a type hierarchy with default implementation, which is applicable to all child classes.

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


### Abstract classes

* An abstract class is a superclass (parent class) that cannot be instantiated. You need to instantiate one of its child classes if you want to create a new object. Abstract classes can have both abstract and concrete methods. Abstract methods contain only the method signature, while concrete methods declare a method body as well. Abstract classes are defined with the abstract keyword.

```Java
abstract class Animal {
	// abstract methods
	abstract void move();
	abstract void eat();

	// concrete method
	void label() {
		System.out.println("Animal's data:");
	}
}
```
Extend the Animal abstract class with two child classes: Bird and Fish. Both of them set up their own functionality for the move() and eat() abstract methods.
```Java
class Bird extends Animal {

void move() {
		 System.out.println("Moves by flying.");
     }
	void eat() {
		 System.out.println("Eats birdfood.");
}	 
}

class Fish extends Animal {
		 void move() {
			 System.out.println("Moves by swimming.");
	     }
		 void eat() {
			 System.out.println("Eats seafood.");
		 }
}
```
 Now, test it with the TestBird and TestFish classes. Both call the one concrete (label()) and the two abstract (move() and eat()) methods.
```Java
class TestBird {
	public static void main(String[] args) {
		Animal myBird = new Bird();

		myBird.label();
		myBird.move();
		myBird.eat();
	}
}

class TestFish {
	public static void main(String[] args) {
		Animal myFish = new Fish();

		myFish.label();
		myFish.move();
		myFish.eat();
	}
}
``` 
In the console, the concrete method has been called from the Animal abstract class, while the two abstract methods have been called from Bird() and Fish(), respectively.
```Console
[Console output of TestBird]
Animal's data:
Moves by flying.
Eats birdfood.

[Console output of TestFish]
Animal's data:
Moves by swimming.
Eats seafood.
```

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

* **Can we overload static method in Java Program ?**

* Yes, we can overload static method in Java. In terms of method overloading static method are just like normal methods and in order to overload static method you need to provide another static method with same name but different method signature. Static overloaded method are resolved using Static Binding during compile time.

```Java
/**   
 * Java program to show that we can overload static method in Java.
 */
public class StaticOverloadingTest {
 
    public static void main(String args[]) {
        greet("John"); //will call static method with one String argument
        greet("John", "Good Morning"); //overloaded static method will be call    

    }
 
    /*
     * static method which will be overloaded
     */
    public static void greet(String name){
        System.out.println("Hello " + name);
    }
 
    /*
     * Another static method which overload above Hello method
     * This shows that we can overload static method in Java
     */
    public static void greet(String name, String greeting){
        System.out.println(greeting + " " + name);
    }


}
Output
Hello John
Good Morning John
```
* **That's all on How can we overload static method in Java. In summary, Don't confuse between method overloading and method overriding. In short, you can overload static method in Java but you can not override static method in Java.**

**What is covariant method overriding in Java?**

* In covariant method overriding, the overriding method can return the subclass of the object returned by original or overridden method. This concept was introduced in Java 1.5 (Tiger) version and it's very helpful in case original method is returning general type like Object class, because, then by using covariant method overriding you can return more suitable object and prevent client side type casting. One of the practical use of this concept is in when you override the clone() method in Java.

* Covariant Method Overriding Example

As I said, one of the best example of this is overriding clone() method, which is declared in java.lang.Object class and has a return type of Object. If you have used java.util.Date in your project and has called it's clone method to make a copy, you might know that you need to cast it back to Date as shown below :
```Java
Date d = new Date();
Date clone = (Date) d.clone(); 
```
Example:
```Java
import java.util.Date;

/** 
  * Java program to demonstrate how to use covariant method overriding to avoid
  * casting at client side.
 
  * @author http://javarevisited.blogspot.com
  */
public class CovariantMethodOverridingTest {

    public static void main(String args[]) {
      
        //without covariant overriding, cast at client side needed
        Date d = new Date();
        Date clone = (Date) d.clone();  //casting required
       
        //with covariant method overriding, no client side cast
        Duck duck = new Duck(0xFFFFFF);
        Duck copy = duck.clone(); //no casting
    }

  
}

class Duck implements Cloneable{
    private int color = 0xFFFFFF;
   
    public Duck(int color){
        this.color = color;
    }
   
    public int getColor(){
        return color;
    }

    @Override
    protected Duck clone() {
        Duck clone = null;
        try{
            clone = (Duck) super.clone();
           
        }catch(CloneNotSupportedException ex){
            throw new RuntimeException(ex);
        }
       
        return clone;
    }  
   
}
```
**Can we overload or override the main method in Java?**

**No,** since main() is a static method, you can only overload it, you cannot override it because the static method is resolved at compile time without needing object information hence we cannot override the main method in Java.


* **Difference between super() and this() in java**


 ** * **	|**super()**|**this()**
------------ | ------------ | ------------ 
Definition|	super() - refers immediate parent class instance.	|this() - refers current class instance.
Invoke	|Can be used to invoke immediate parent class method.|	Can be used to invoke current class method.
Constructor	|super() acts as immediate parent class constructor and should be first line in child class constructor.|	this() acts as current class constructor and can be used in parametrized constructors.
Override|	When invoking a superclass version of an overridden method the super keyword is used.|	When invoking a current version of an overridden method the this keyword is used.

**Example**
```Java
class Animal {
   String name;
   Animal(String name) {
      this.name = name;
   }
   public void move() {
      System.out.println("Animals can move");
   }
   public void show() {
      System.out.println(name);
   }
}
class Dog extends Animal {
   Dog() {
      //Using this to call current class constructor
      this("Test");
   }
   Dog(String name) {
      //Using super to invoke parent constructor
      super(name);
   }
   public void move() {
      // invokes the super class method
      super.move();
      System.out.println("Dogs can walk and run");
   }
}
public class Tester {
   public static void main(String args[]) {
      // Animal reference but Dog object
      Animal b = new Dog("Tiger");
      b.show();
      // runs the method in Dog class
      b.move();
   }
}

Output

Tiger
Animals can move
Dogs can walk and run
```

* **Can we override static method in Java?**
* No, you cannot override static method in Java because method overriding is based upon dynamic binding at runtime. Usually static methods are bonded using static binding at compile time before even program runs.

* Basically, keyword static modifies the lifecycle of variable and method. If you specify static method or variable then those are created at the time of class is loaded and not at runtime. Nonstatic variables and methods are only available during runtime.

* **What is method hiding in Java and how to use it?**

When super class and sub class contains same method including parameters and if they are static.

The method in the super class will be hidden by the one that is in the sub class. This mechanism is known as method hiding.

**Example**

```Java
class Demo{
   public static void demoMethod() {
      System.out.println("method of super class");
   }
}
public class Sample extends Demo {
   public static void demoMethod() {
      System.out.println("method of sub class");
   }
   public static void main(String args[] ) {
      Sample.demoMethod();
   }
}
Output
method of sub class
```

* **Method Hiding vs Overriding**

* Hiding doesn't work like overriding, because static methods are not polymorphic. Overriding occurs only with instance methods. It supports late binding, so which method will be called is determined at runtime.

* **On the other hand, method hiding works with static ones. Therefore it's determined at compile time.**

* **Can we prevent overriding a method without using the final modifier?**

* Yes, you can prevent the method overriding in Java without using the final modifier. In fact, there are several ways to accomplish it e.g. you can mark the method private or static, those cannot be overridden.


* **Can we override a private method in Java?**
* No, you cannot. Since the private method is only accessible and visible inside the class they are declared, it's not possible to override them in subclasses. Though, you can override them inside the inner class as they are accessible there.


* **What is covariant method overriding in Java?**
* In covariant method overriding, the overriding method can return the subclass of the object returned by original or overridden method. This concept was introduced in Java 1.5 (Tiger) version and it's very helpful in case original method is returning general type like Object class, because, then by using covariant method overriding you can return more suitable object and prevent client side type casting. One of the practical use of this concept is in when you override the clone() method in Java.


* **Can we change the return type of method to subclass while overriding?**
* Yes, you can, but only from Java 5 onward. This feature is known as covariant method overriding and it was introduced in JDK 5 release. This is immensely helpful if original method return super-class e.g. clone() method return java.lang.Object. By using this, you can directly return the actual type, preventing client-side type casting of the result.


* **Can we change the argument list of an overriding method?**
* No, you cannot. The argument list is part of the method signature and both overriding and overridden method must have the same signature.


* **Can we override a method which throws runtime exception without throws clause?**
* Yes, there is no restriction on unchecked exception while overriding. On the other hand, in the case of checked exception, an overriding exception cannot throw a checked exception which comes higher in type hierarchy e.g. if original method is throwing IOException than overriding method cannot throw java.lang.Exception or java.lang.Throwable.

### 3) Java Strings

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
    }

}
```

Output of the above program is:

```Console
s1 == s2 :true
s1 == s3 :false
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

#### Why Char array is preferred over String for storing password?

* String is immutable in Java and stored in String pool. Once it’s created it stays in the pool until unless garbage collected, so even though we are done with password it’s available in memory for longer duration and there is no way to avoid it. It’s a security risk because anyone having access to memory dump can find the password as clear text.
If we use a char array to store password, we can set it to blank once we are done with it. So we can control for how long it’s available in memory that avoids the security threat with String.

#### String vs StringBuffer Vs StringBuilder

* Objects of String are immutable, and objects of StringBuffer and StringBuilder are mutable.

* String class represents a sequence of characters and provides useful methods to work with characters. String class instances are immutable. So each time you perform string concatenation using string class, a new object will be created with the concatenated string.

* StringBuilder class is used to perform string concatenation operations in more memory efficient way. It internally maintains a char array and manipulate the content in this array only. 
When you need to get the complete concatenated string after performing all operations, it creates a new String with character array content.

* StringBuffer is very much same as StringBuilder class. Only difference is that it is thread-safe. It’s all methods are synchronized.

#### Substring in Java

* A part of string is called substring. In other words, substring is a subset of another string. In case of substring **startIndex is inclusive** and **endIndex is exclusive.**

**Note: Index starts from 0.**

* You can get substring from the given string object by one of the two methods:

* **public String substring(int startIndex):** This method returns new String object containing the substring of the given string from specified startIndex (inclusive).

* **public String substring(int startIndex, int endIndex):** This method returns new String object containing the substring of the given string from specified startIndex to endIndex.

* In case of string:
  * **startIndex: inclusive**
  * **endIndex: exclusive**
  
**Example:**

```Java

String s="hello";  
System.out.println(s.substring(0,2));//he 

===========================================

public class TestSubstring{  
 public static void main(String args[]){ 
 
   String s="SachinTendulkar";
    
   System.out.println(s.substring(6));//Tendulkar  
   System.out.println(s.substring(0,6));//Sachin 
 }  
}  
```

```Java
public class StringExample 
{
    public static void main(String[] args) 
    {
        String blogName = "howtodoinjava.com";
 
        System.out.println(blogName.substring(14, blogName.length()));  //com
             
        System.out.println("hello world".substring(6,9));   //wor
        
        System.out.println("0123456789".substring(3, 7));   //3456
    }
}
```

#### How to create a immutable object in Java? Count all benefits?

* An immutable class is one whose state can not be changed once created. Here, state of object essentially means the values stored in instance variable in class whether they are primitive types or reference types.
  
* To make a class immutable, below steps needs to be followed:

  * Don’t provide “setter” methods or methods that modify fields or objects referred to by fields. Setter methods are meant to change the state of object and this is what we want to prevent here.
  * Make all fields final and private. Fields declared private will not be accessible outside the class and making them final will ensure the even accidentally you can not change them.
  * Don’t allow subclasses to override methods. The simplest way to do this is to declare the class as final. Final classes in java can not be overridden.
  * Always remember that your instance variables will be either mutable or immutable. Identify them and return new objects with copied content for all mutable objects (object references). Immutable variables (primitive types) can be returned safely without extra effort.  

**Also, you should memorize following benefits of immutable class. You might need them during interview. Immutable classes –**

* are simple to construct, test, and use
* are automatically thread-safe and have no synchronization issues
* do not need a copy constructor
* do not need an implementation of clone
* allow hashCode to use lazy initialization, and to cache its return value
* do not need to be copied defensively when used as a field
* make good Map keys and Set elements (these objects must not change state while in the collection)
* have their class invariant established once upon construction, and it never needs to be checked again
* always have “failure atomicity” (a term used by Joshua Bloch) : if an immutable object throws an exception, it’s never left in an undesirable or indeterminate state

**Example**

```Java
ImmutableClass.java
import java.util.Date;
 
/**
* Always remember that your instance variables will be either mutable or immutable.
* Identify them and return new objects with copied content for all mutable objects.
* Immutable variables can be returned safely without extra effort.
* */
public final class ImmutableClass
{
 
    /**
    * Integer class is immutable as it does not provide any setter to change its content
    * */
    private final Integer immutableField1;
 
    /**
    * String class is immutable as it also does not provide setter to change its content
    * */
    private final String immutableField2;
 
    /**
    * Date class is mutable as it provide setters to change various date/time parts
    * */
    private final Date mutableField;
 
    //Default private constructor will ensure no unplanned construction of class
    private ImmutableClass(Integer fld1, String fld2, Date date)
    {
        this.immutableField1 = fld1;
        this.immutableField2 = fld2;
        this.mutableField = new Date(date.getTime());
    }
 
    //Factory method to store object creation logic in single place
    public static ImmutableClass createNewInstance(Integer fld1, String fld2, Date date)
    {
        return new ImmutableClass(fld1, fld2, date);
    }
 
    //Provide no setter methods
 
    /**
    * Integer class is immutable so we can return the instance variable as it is
    * */
    public Integer getImmutableField1() {
        return immutableField1;
    }
 
    /**
    * String class is also immutable so we can return the instance variable as it is
    * */
    public String getImmutableField2() {
        return immutableField2;
    }
 
    /**
    * Date class is mutable so we need a little care here.
    * We should not return the reference of original instance variable.
    * Instead a new Date object, with content copied to it, should be returned.
    * */
    public Date getMutableField() {
        return new Date(mutableField.getTime());
    }
 
    @Override
    public String toString() {
        return immutableField1 +" - "+ immutableField2 +" - "+ mutableField;
    }
}
```
Now its time to test our class:

```Java
TestMain.java
class TestMain
{
    public static void main(String[] args)
    {
        ImmutableClass im = ImmutableClass.createNewInstance(100,"test", new Date());
        System.out.println(im);
        tryModification(im.getImmutableField1(),im.getImmutableField2(),im.getMutableField());
        System.out.println(im);
    }
 
    private static void tryModification(Integer immutableField1, String immutableField2, Date mutableField)
    {
        immutableField1 = 10000;
        immutableField2 = "test changed";
        mutableField.setDate(10);
    }
}
```
Program output:

```Console
100 - test - Tue Oct 30 21:34:08 IST 2012
100 - test - Tue Oct 30 21:34:08 IST 2012
```

#### Immutable classes in JDK
* Apart from your written classes, JDK itself has lots of immutable classes. Given is such a list of immutable classes in Java.

  * String
  * Wrapper classes such as Integer, Long, Double etc.
  * Immutable collection classes such as Collections.singletonMap() etc.
  * java.lang.StackTraceElement
  * Java enums (ideally they should be)
  * java.util.Locale
  * java.util.UUID
  
 ## 4) Java Exceptions
 
 #### What is an exception ?
 
* Exception is an abnormal condition which occurs during the execution of a program and disrupts normal flow of the program. This exception must be handled properly. If it is not handled, program will be terminated abruptly.
 
#### How the exceptions are handled in java? OR Explain exception handling mechanism in java?

* Exceptions in java are handled using try, catch and finally blocks.

* try block : The code or set of statements which are to be monitored for exception are kept in this block.

* catch block : This block catches the exceptions occurred in the try block.

* finally block : This block is always executed whether exception is occurred in the try block or not and occurred exception is caught in the catch block or not.
  
#### What is the difference between error and exception in java?

* Errors are mainly caused by the environment in which an application is running. For example, OutOfMemoryError happens when JVM runs out of memory. Where as exceptions are mainly caused by the application itself. For example, NullPointerException occurs when an application tries to access null object.

#### Can we write only try block without catch and finally blocks?

No, It shows compilation error. The try block must be followed by either catch or finally block. You can remove either catch block or finally block but not both.


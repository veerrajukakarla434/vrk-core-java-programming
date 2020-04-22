# Java Interview Questions - Part2

* **4) Java Exceptions**
* **5) Java Threads**
* **6) Java Generics**
* **7) Java Collections**
* **8) Java 7,8 Futures**

 
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

* No, It shows compilation error. The try block must be followed by either catch or finally block. You can remove either catch block or finally block but not both.


#### What is unreachable catch block error?

* When you are keeping multiple catch blocks, the order of catch blocks must be from most specific to most general ones. i.e sub classes of Exception must come first and super classes later. If you keep super classes first and sub classes later, compiler will show unreachable catch block error.

```Java
public class ExceptionHandling
{
    public static void main(String[] args)
    {
        try
        {
            int i = Integer.parseInt("abc");   //This statement throws NumberFormatException
        }
  
        catch(Exception ex)
        {
            System.out.println("This block handles all exception types");
        }
  
        catch(NumberFormatException ex)
        {
            //Compile time error
            //This block becomes unreachable as
            //exception is already caught by above catch block
        }
    }
}
```

#### Explain the hierarchy of exceptions in java?

#### what are checked and unchecked exceptions in java?

* **Checked exceptions** are the exceptions which are known to compiler. These exceptions are checked at compile time only. Hence the name checked exceptions. These exceptions are also called compile time exceptions. Because, these exceptions will be known during compile time.

* **Unchecked exceptions** are those exceptions which are not at all known to compiler. These exceptions occur only at run time. These exceptions are also called as run time exceptions. All sub classes of java.lang.RunTimeException and java.lang.Error are unchecked exceptions.

* Now, come to hierarchy of exceptions in java.

* java.lang.Throwable :
  *java.lang.Throwable is the super class of all errors and exceptions in java. Throwable class extends java.lang.Object class. The only argument of catch block must be it’s type or it’s sub class type. You can check the documentation of Throwable class here. It has two sub classes.
  
   * 1)java.lang.Error
   * 2)java.lang.Exception
   
####  1) java.lang.Error :
* java.lang.Error is the super class for all types of errors in java. You can follow the documentation of Error class here. Some of the common errors are,

  * java.lang.VirtualMachineError : The most common virtualMachineErrors are StackOverFlowError and OutOfMemoryError.
  * java.lang.AssertionError
  * java.lang.LinkageError : The common LinkageError are NoClassDefFoundError and subclasses of IncompatibleClassChangeError. The most frequent IncompatibleClassChangeErrors are NoSuchMethodError, NoSuchFieldError, AbstractMethodError, IllegalAccessError and InstantiationError.
  
  * All sub classes of Error class are unchecked type of exceptions. i.e They occur during run time only.

#### 2) java.lang.Exception :
* java.lang.Exception is the super class for all types of Exceptions in java. You can follow the documentation of Exception class here. All sub classes of Exception class except sub classes of RunTimeException are checked type of exceptions. Some of the common sub classes of Exception are,

* **java.lang.RunTimeException**
* All sub classes of RunTimeException are unchecked type of exceptions. i.e They occur during run time only. Some common RunTimeException are ArithmeticException, NumberFormatException, NullPointerException, ArrayIndexOutOfBoundsException and ClassCastException.

  * java.lang.InterruptedException
  * java.lang.IOException
  * java.lang.SQLException
  * java.lang.ParseException
* All above classes are placed in java.lang package. Click on class to follow the documentation of that class. The above hierarchy can be represented as,  

![Exceptions](https://i1.wp.com/javaconceptoftheday.com/wp-content/uploads/2014/11/Exceptions.png?w=1200 "Exceptions")
  
#### Difference Between ClassNotFoundException Vs NoClassDefFoundError In Java

* In Java, both ClassNotFoundException and NoClassDefFoundError occur when a particular class is not found at run time. But, they occur at different scenarios. ClassNotFoundException is an exception which occurs when you try to load a class at run time using Class.forName() or loadClass() methods and mentioned classes are not found in the classpath. On the other hand, NoClassDefFoundError is an error which occurs when a particular class is present at compile time but it was missing at run time. In this below example, we will see the differences between ClassNotFoundException Vs NoClassDefFoundError in java and when they occur. 

#### ClassNotFoundException In Java :
* ClassNotFoundException is a run time exception which is thrown when an application tries to load a class at run time using Class.forName() or loadClass() or findSystemClass() methods and the class with specified name are not found in the classpath. For example, you may have come across this exception when you try to connect to MySQL or Oracle databases and you have not updated the classpath with required JAR files. In most of time, this exception occurs when you try to run an application without updating the classpath with required JAR files.

* For example, below program will throw ClassNotFoundException if the mentioned class “oracle.jdbc.driver.OracleDriver” is not found in the classpath.

```Java
public class MainClass
{
    public static void main(String[] args)
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
```
* If you run the above program without updating the classpath with required JAR files, you will get the exception like below,

```Console
java.lang.ClassNotFoundException: oracle.jdbc.driver.OracleDriver
    at java.net.URLClassLoader.findClass(Unknown Source)
    at java.lang.ClassLoader.loadClass(Unknown Source)
    at sun.misc.Launcher$AppClassLoader.loadClass(Unknown Source)
    at java.lang.ClassLoader.loadClass(Unknown Source)
    at java.lang.Class.forName0(Native Method)
    at java.lang.Class.forName(Unknown Source)
    at pack1.MainClass.main(MainClass.java:17)
```

#### NoClassDefFoundError In Java :
* NoClassDefFoundError is an error which is thrown when Java Runtime System tries to load the definition of a class and class definition is no longer available. The required class definition was present at compile time but it was missing at run time. For example, compile the below program.

```Java
class A
{
 
}
 
public class B
{
    public static void main(String[] args)
    {
        A a = new A();
    }
}
```
* When you compile the above program, two .class files will be generated. One is A.class and another one is B.class. If you remove the A.class file and run the B.class file, Java Runtime System will throw NoClassDefFoundError like below,

```Console
Exception in thread "main" java.lang.NoClassDefFoundError: A
        at MainClass.main(MainClass.java:10)
Caused by: java.lang.ClassNotFoundException: A
        at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
        at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:331)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
```
 
**ClassNotFoundException** | **NoClassDefFoundError**
------------ | ------------
It is an exception. It is of type java.lang.Exception.	|It is an error. It is of type java.lang.Error.
It occurs when an application tries to load a class at run time which is not updated in the classpath. |	It occurs when java runtime system doesn’t find a class definition, which is present at compile time, but missing at run time.
It is thrown by the application itself. It is thrown by the methods like Class.forName(), loadClass() and findSystemClass().	|It is thrown by the Java Runtime System.
It occurs when classpath is not updated with required JAR files.	|It occurs when required class definition is missing at run time. 

#### Does finally block get executed If either try or catch blocks are returning the control?

* Yes, finally block will be always executed no matter whether try or catch blocks are returning the control or not.

#### What is Re-throwing an exception in java?

* Exceptions raised in the try block are handled in the catch block. If it is unable to handle that exception, it can re-throw that exception using throw keyword. It is called re-throwing an exception.

```Java
try
{
    String s = null;
    System.out.println(s.length());   //This statement throws NullPointerException
}
catch(NullPointerException ex)
{
    System.out.println("NullPointerException is caught here");
  
    throw ex;     //Re-throwing NullPointerException
}

```

#### What is the difference between final, finally and finalize in java?


**final** |	**finally**|**finalize**
--------|-------|-------
Final is used to apply restrictions on class, method and variable.| Final class can't be inherited, final method can't be overridden and final variable value can't be changed.|	Finally is used to place important code, it will be executed whether exception is handled or not.	|Finalize is used to perform clean up processing just before object is garbage collected.
Final is a keyword.|	Finally is a block.|	Finalize is a method.

#### final keyword :

* final is a keyword which is used to make a variable or a method or a class as “unchangeable“. In simple terms,

A variable which is declared as final, it’s value can not be changed once it is initialized.

```Java
final int i = 10;    //final variable
 
i = 20;      //Compile time error, Value can not be changed
A method declared as final can not be overridden or modified in the sub class.

```

```Java
class SuperClass
{
    final void methodOfSuperClass()
    {
        System.out.println("final Method");
    }
}
 
class SubClass extends SuperClass
{
    void methodOfSuperClass()
    {
        //Compile time error, final method can not be overridden.
    }
}
```
A class declared as final can not be extended.

```Java
final class SuperClass
{
    //final class
}
 
class SubClass extends SuperClass
{
    //Compile time error, can not create a sub class to final class
}
```

#### finally Block :

* finally is a block which is used for exception handling along with try and catch blocks. finally block is always executed whether exception is raised or not and raised exception is handled or not. Most of time, this block is used to close the resources like database connection, I/O resources etc.

```Java
try
{
    //checking the code for exceptions
}
catch(Exception ex)
{
    //Catching the exceptions
}
finally
{
    //This block is always executed
}
```
#### finalize() Method :
* finalize() method is a protected method of java.lang.Object class. It is inherited to every class you create in java. This method is called by garbage collector thread before an object is removed from the memory. finalize() method is used to perform some clean up operations on an object before it is removed from the memory.

```Java
protected void finalize() throws Throwable
{
    //Clean up operations
}
=======================================
class FinalizeExample{  
public void finalize(){System.out.println("finalize called");}  
public static void main(String[] args){  
FinalizeExample f1=new FinalizeExample();  
FinalizeExample f2=new FinalizeExample();  
f1=null;  
f2=null;  
System.gc();  
}
}  
```
#### What is the difference between throw, throws and throwable in java?
**throw In Java :**

* throw is a keyword in java which is used to throw an exception manually. Using throw keyword, you can throw an exception from any method or block. But, that exception must be of type java.lang.Throwable class or it’s sub classes. Below example shows how to throw an exception using throw keyword.

```Java
class ThrowAndThrowsExample
{
    void method() throws Exception
    {
        Exception e = new Exception();
 
        throw e;            //throwing an exception using 'throw'
    }
}
```
#### throws In Java :
* throws is also a keyword in java which is used in the method signature to indicate that this method may throw mentioned exceptions. The caller to such methods must handle the mentioned exceptions either using try-catch blocks or using throws keyword. Below is the syntax for using throws keyword.

```Java
return_type method_name(parameter_list) throws exception_list
{
     //some statements
}
```
#### Throwable In Java :
* Throwable is a super class for all types of errors and exceptions in java. This class is a member of java.lang package. Only instances of this class or it’s sub classes are thrown by the java virtual machine or by the throw statement. The only argument of catch block must be of this type or it’s sub classes. If you want to create your own customized exceptions, then your class must extend this class. 

* Below example shows how to create customized exceptions by extending java.lang.Throwable class.

```Java
class MyException extends Throwable
{
           //Customized Exception class
}
 
class ThrowAndThrowsExample
{
    void method() throws MyException
    {
        MyException e = new MyException();
 
        throw e;
    }
}
```
#### Garbage Collection In Java :
* Whenever you run a java program, JVM creates three threads. 1) main thread   2) Thread Scheduler   3) Garbage Collector Thread. In these three threads, main thread is a user thread and remaining two are daemon threads which run in background.

* The task of main thread is to execute the main() method. The task of thread scheduler is to schedule the threads. The task of garbage collector thread is to sweep out abandoned objects from the heap memory. Abandoned objects or dead objects are those objects which does not have live references. Garbage collector thread before sweeping out an abandoned object, it calls finalize() method of that object. After finalize() method is executed, object is destroyed from the memory. That means clean up operations which you have kept in the finalize() method are executed before an object is destroyed from the memory.

* Garbage collector thread does not come to heap memory whenever an object becomes abandoned. It comes once in a while to the heap memory and at that time if it sees any abandoned objects, it sweeps out those objects after calling finalize() method on them. Garbage collector thread calls finalize() method only once for one object.


## What to Do About Java Memory Leaks: Tools, Fixes, and More ?

* **==> Weak, Soft, and Phantom References in Java (and Why They Matter)**

* This breakdown of weak, soft, and phantom references explains how they impact GC and memory allocation as well as some ideal use cases.

* Almost every Java programmer knows there are Soft and Weak references, but usually, they are not fully understood. Phantom ones are even less well-known.


* SoftReference object: Garbage collector is required to clear all SoftReference objects when memory runs low.
* WeakReference object: When garbage collector senses a weakly referenced object, all references to it are cleared and ultimately taken out of memory.
* PhantomReference object: Garbage collector would not be able to automatically clean up PhantomReference objects, you would need to clean it up manually by clearing all references to it.


**SoftReference:**
*  Soft reference objects are cleared at the discretion of the garbage collector in response to memory demand. Soft references are most often used to implement memory-sensitive caches. All soft references to softly reachable objects are guaranteed to have been cleared before the virtual machine throws an OutOfMemoryError.

**WeakReference:**
*  Weak reference objects do not prevent their referents from being made finalizable, finalized, and then reclaimed. Weak references are most often used to implement canonicalizing mappings. (Here, Canonicalizing mappings means mapping only reachable object instances.)

**PhantomReference:**
*  Phantom reference objects are enqueued after the collector determines that their referents may otherwise be reclaimed. Phantom references are most often used for scheduling pre-mortem cleanup actions in a more flexible way than is possible with the Java finalization mechanism. Unlike soft and weak references, phantom references are not automatically cleared by the garbage collector as they are enqueued. An object that is reachable via phantom references will remain so until all such references are cleared or themselves become unreachable.


**2. Avoid Memory Leaks Related to a WebApp Classloader**
* If you are using Jetty 7.6.6. or higher, you can prevent WebApp classloader pinning. When your code keeps referring to a webapp classloader, memory leaks can easily happen. There are two types of leaks in this case: daemon threads and static fields.

* Static fields are started with the classloader’s value. Even as Jetty stops deploying and then redeploys your webapp, the static reference persists and so the object cannot be cleared from memory.
* Daemon threads that are started outside the lifecycle of a Web application are prone to memory leaks because these threads have references to the classloader that started the threads.
* With Jetty, you can use preventers to help you address problems associated with WebApp classloaders. For instance, app context leak preventer, such as appcontext.getappcontext() helps you keep the static references within the context classloader. Other preventers you can use are the following:

  * AWT leak preventer
  * DOM leak preventer
  * Driver manager leak preventer
  * GC thread leak preventer
  * Java2D leak preventer
  * LDAP leak preventer
  * Login configuration leak preventer
  * Security provider leak preventer


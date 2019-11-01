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
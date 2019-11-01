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

* **Checked Exceptions**
  * Checked exceptions are known to compiler i.e they are the exceptions that are checked at compile time. Checked exceptions are also called compile time exceptions, because they can be known during compile time.

* **Unchecked Exceptions**
  * Unchecked exceptions are not known to compiler.  They are the exceptions that are not checked at compile time, because they occur only at run time.That’s why these exceptions are also called run time exceptions.

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
  
  
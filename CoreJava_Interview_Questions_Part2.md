# Java Interview Questions

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

No, It shows compilation error. The try block must be followed by either catch or finally block. You can remove either catch block or finally block but not both.


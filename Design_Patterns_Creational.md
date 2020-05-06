## Java Design Patterns - Creational 


All Design Patterns refer below links


* https://howtodoinjava.com/gang-of-four-java-design-patterns/

* https://www.javatpoint.com/design-patterns-in-java

* https://refactoring.guru/design-patterns/java

* https://www.journaldev.com/1827/java-design-patterns-example-tutorial

#### How to create immutable class in Java

* **Rules to create immutable classes**

* Don’t provide “setter” methods — methods that modify fields or objects referred to by fields.
  * This principle says that for all mutable properties in your class, do not provide setter methods. Setter methods are meant to change the state of an object and this is what we want to prevent here.

* Make all fields final and private
  * This is another way to increase immutability. Fields declared private will not be accessible outside the class and making them final will ensure the even accidentally you can not change them.
  
* Don’t allow subclasses to override methods
  * The simplest way to do this is to declare the class as final. Final classes in java can not be overridden.

* Special attention when having mutable instance variables
  * Always remember that your instance variables will be either mutable or immutable. Identify them and return new objects with copied content for all mutable objects. Immutable variables can be returned safely without extra effort.
  * A more sophisticated approach is to make the constructor private and construct instances in factory methods.    


#### Java immutable class example

* **ImmutableClass.java**

```Java

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
* **Now its time to test our class:**

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

#### Program output:

```Console
100 - test - Tue Oct 30 21:34:08 IST 2012
100 - test - Tue Oct 30 21:34:08 IST 2012
```
* As it can be seen that even changing the instance variables using their references does not change their value, so the class is immutable.

* **Immutable classes in JDK**
* Apart from your written classes, JDK itself has lots of immutable classes. Given is such a list of immutable classes in Java.

  * String
  * Wrapper classes such as Integer, Long, Double etc.
  * Immutable collection classes such as Collections.singletonMap() etc.
  * java.lang.StackTraceElement
  * Java enums (ideally they should be)
  * java.util.Locale
  * java.util.UUID

## Singleton Design pattern:

* Before going to singleton you should know about volatile keyword.

Refer For Volatile :-> http://tutorials.jenkov.com/java-concurrency/volatile.html , https://javarevisited.blogspot.com/2011/06/volatile-keyword-java-example-tutorial.html

#### Important points on Volatile keyword in Java

* 1. The volatile keyword in Java is only application to a variable and using volatile keyword with class and method is illegal.

* 2. volatile keyword in Java guarantees that value of the volatile variable will always be read from main memory and not from Thread's local cache.

* 3. In Java reads and writes are atomic for all variables declared using Java volatile keyword (including long and double variables).

* **4. Using the volatile keyword in Java on variables reduces the risk of memory consistency errors because any write to a volatile variable in Java establishes a happens-before relationship with subsequent reads of that same variable.**

* 5. From Java 5 changes to a volatile variable are always visible to other threads. What's more, it also means that when a thread reads a volatile variable in Java, it sees not just the latest change to the volatile variable but also the side effects of the code that led up the change.

* 6. Reads and writes are atomic for reference variables are for most primitive variables (all types except long and double) even without the use of volatile keyword in Java.

* **7. An access to a volatile variable in Java never has a chance to block, since we are only doing a simple read or write, so unlike a synchronized block we will never hold on to any lock or wait for any lock.**

* 8. Java volatile variable that is an object reference may be null.

* **9. Java volatile keyword doesn't mean atomic, its common misconception that after declaring volatile ++ will be atomic, to make the operation atomic you still need to ensure exclusive access using synchronized method or block in Java.**

* 10. If a variable is not shared between multiple threads, you don't need to use volatile keyword with that variable.


 
#### Difference between synchronized and volatile keyword in Java

* **What is the difference between volatile and synchronized is another popular core Java question asked on multi-threading and concurrency interviews. Remember volatile is not a replacement of synchronized keyword but can be used as an alternative in certain cases. Here are few differences between volatile and synchronized keyword in Java.**

* 1. The volatile keyword in Java is a field modifier while synchronized modifies code blocks and methods.

* 2. Synchronized obtains and releases the lock on monitor’s Java volatile keyword doesn't require that.

* 3. Threads in Java can be blocked for waiting for any monitor in case of synchronized, that is not the case with the volatile keyword in Java.

* 4. Synchronized method affects performance more than a volatile keyword in Java.

* 5. Since volatile keyword in Java only synchronizes the value of one variable between Thread memory and "main" memory while synchronized synchronizes the value of all variable between thread memory and "main" memory and locks and releases a monitor to boot. Due to this reason synchronized keyword in Java is likely to have more overhead than volatile.

* 6. You can not synchronize on the null object but your volatile variable in Java could be null.

* 7. From Java 5 writing into a volatile field has the same memory effect as a monitor release, and reading from a volatile field has the same memory effect as a monitor acquire


* **In short, volatile keyword in Java is not a replacement of synchronized block or method but in some situation is very handy and can save performance overhead which comes with use of synchronization in Java.**


#### Singleton design pattern in Java

Ref : https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples#lazy-initialization


* Singleton Pattern says that just **"define a class that has only one instance and provides a global point of access to it".**

* In other words, a class must ensure that only single instance should be created and single object can be used by all other classes.

* There are two forms of singleton design pattern

  * Early Instantiation: creation of instance at load time.
  * Lazy Instantiation: creation of instance when required.

#### Advantage of Singleton design pattern

* Saves memory because object is not created at each request. Only single instance is reused again and again.

#### Usage of Singleton design pattern

* Singleton pattern is mostly used in multi-threaded and database applications. It is used in logging, caching, thread pools, configuration settings etc.


#### How to create Singleton design pattern?
* To create the singleton class, we need to have static member of class, private constructor and static factory method.

* **Static member:** It gets memory only once because of static, itcontains the instance of the Singleton class.
* **Private constructor:**  It will prevent to instantiate the Singleton class from outside the class.
* **Static factory method:** This provides the global point of access to the Singleton object and returns the instance to the caller.




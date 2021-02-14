## Java 8-foaEach

* One common requirement in Java application is to iterate through the elements of a collection.
* Prior to Java 8, the three most common ways to iterate through a collection are by using the while loop, for loop, and enhanced for loop. 
* As the Java Collection interface extends Iterable, you can also use the hasNext() and next() methods of Iterable to iterate through collection elements.
* Starting from Java 8, we have a new forEach method in Iterable to loop through elements in a collection – but in a different way. OR
* Introduced in Java 8, the forEach loop provides programmers with **a new, concise and interesting way for iterating over a collection.**

### External vs Internal Iterators

* Based on who controls iterations, Java Iterators can be classified into external and internal iterators.
* External iterators are also known as active or explicit iterators. 
* When using an external iterator, the client code performing the iteration controls the iteration. 
* The client creates the iterator and instructs it when to advance to the next element. 
* The client also checks whether or not all the element has been visited, and so on.
* **Enumerations, iterators, and enhanced for-loop are all examples of external iterators.**
* The enhanced for loop introduced in Java 5 is another example of external iterator. 
```java
An example of the enhanced for loop is this.
for (String name : names) {
    System.out.println(name);
}
```
#### Internal Iterators

* Internal iterators are also known as passive, implicit or callback iterator. 
* When you use an internal iterator, it is the iterator itself that controls the iteration. 
* The client code essentially says to the iterator, “perform this operation on the elements in the collection.”

* Internal iterator has been introduced in Java 8 with the introduction of Lambda expression. 

#### List Iteration using Java 8 forEach

* The code to iterate through the elements of a list using forEach is this.
```java
public static void iterateThroughList(List<String> list){
    list.forEach(name->System.out.println(name));
}
```

* This code declaratively states what is meant to be done with the elements of the List. 
* The internal iterator manages the iterations in the background.

* To make the code clearer, the same iterateThroughList() method can be written using **method reference** like this.
```java
public static void iterateThroughList(List<String> list){
        list.forEach(System.out::println);
}
```
#### Inside Java 8 forEach
* In the example we just saw, we used lambda expressions.
* Let us look inner side of the forEach method and look what is happening inside.
* The signature of the forEach method is this.
```java
default void forEach(Consumer<? super T> action)
```
* The forEach method performs the given action for each element of the Iterable until all elements have been processed or the action throws an exception. 
* The Consumer parameter of forEach is a **functional interface with the accept(Object) method.**

* We can therefore rewrite the previous iterateThroughList() method like this.

```java
public static void iterateThroughList(List<String> list){
    Consumer<String> consumerNames = new Consumer<String>() {
        public void accept(String name) {
            System.out.println(name);
        }
    };
    list.forEach(consumerNames);
}
```







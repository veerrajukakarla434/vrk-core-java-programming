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

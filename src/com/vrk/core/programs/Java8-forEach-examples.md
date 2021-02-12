## Java 8-foaEach

* One common requirement in Java application is to iterate through the elements of a collection.
* Prior to Java 8, the three most common ways to iterate through a collection are by using the while loop, for loop, and enhanced for loop. 
* As the Java Collection interface extends Iterable, you can also use the hasNext() and next() methods of Iterable to iterate through collection elements.
* Starting from Java 8, we have a new forEach method in Iterable to loop through elements in a collection – but in a different way. OR
* Introduced in Java 8, the forEach loop provides programmers with **a new, concise and interesting way for iterating over a collection.**

### External vs Internal Iterators

* Based on who controls iterations, Java Iterators can be classified into external and internal iterators.

+ addition
- deletion

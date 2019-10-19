# Java Design Patterns
https://howtodoinjava.com/design-patterns/creational/
Creational Design Patterns 

#### 1 Builder Design pattern:

The builder pattern, as name implies, is an alternative way to construct complex objects. 
This should be used only when you want to build different immutable objects using same object building process.
Builder pattern is used to create instance of very complex object having telescoping constructor in easiest way.
  
  
# Existing implementations in JDK:

All implementations of java.lang.Appendable are infact good example of use of Builder pattern in java. e.g.
java.lang.StringBuilder#append() [Unsynchronized class]
java.lang.StringBuffer#append() [Synchronized class]
java.nio.ByteBuffer#put() (also on CharBuffer, ShortBuffer, IntBuffer, LongBuffer, FloatBuffer and DoubleBuffer)

# Example
StringBuilder builder = new StringBuilder("Temp");
String data = builder.append(1)
                .append(true)
                .append("friend")
                .toString();
System.out.println(data);
Output:
Temp1truefriend

# 2 Factory Design Pattern:
In Java, factory pattern is used to create instances of different classes of the same type.
Factory pattern introduces loose coupling between classes which is the most important principle one should consider and apply while designing the application architecture.
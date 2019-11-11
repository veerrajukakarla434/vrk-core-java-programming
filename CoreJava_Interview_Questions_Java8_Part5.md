# Java 8 Tutorials

#### 1) Java 8 Lambda Expressions 
#### 2) Java 8 forEach examples




#### 1) Java 8 Lambda Expressions with examples

* **Lambda expression** is a new feature which is introduced in Java 8. A lambda expression is an anonymous function. A function that doesn’t have a name and doesn’t belong to any class. The concept of lambda expression was first introduced in LISP programming language.

* Java Lambda Expression Syntax :
* To create a lambda expression, we specify input parameters (if there are any) on the left side of the lambda operator ->, and place the expression or block of statements on the right side of lambda operator. For example, the lambda expression (x, y) -> x + y specifies that lambda expression takes two arguments x and y and returns the sum of these.

```Java
//Syntax of lambda expression
(parameter_list) -> {function_body}
```

### Where to use the Lambdas in Java
* To use lambda expression, you need to either create your own functional interface or use the pre defined functional interface provided by Java. An interface with only single abstract method is called functional interface(or Single Abstract method interface), for example: Runnable, callable, ActionListener etc.

* **To use function interface:**
  * Pre Java 8: We create anonymous inner classes.
  * Post Java 8: You can use lambda expression instead of anonymous inner classes.

* **Without using Lambda expression:** Prior to java 8 we used the anonymous inner classe to implement the only abstract method of functional interface.

```Java
package com.vrk.java8.lambdaexpression;

import java.awt.*;  
import java.awt.event.*;

public class ButtonListenerOldWay {

	 public static void main(String[] args) {  
	       Frame frame=new Frame("ActionListener Before Java8");  
	    
	       Button b=new Button("Click Here");  
	       b.setBounds(50,100,80,50);  
	  
	       b.addActionListener(new ActionListener(){  
	          public void actionPerformed(ActionEvent e){  
	    	     System.out.println("Hello World!"); 
	          }  
	       });  
	       frame.add(b);
	    
	       frame.setSize(200,200);  
	       frame.setLayout(null);  
	       frame.setVisible(true);   
	    }  
	 
}
```
* **By using Lambda expression:** Instead of creating anonymous inner class, we can create a lambda expression like this:
```Java
package com.vrk.java8.lamdaexpressions;

import java.awt.*;

public class ButtonListenerNewWay {

	public static void main(String[] args) {  
	      Frame frame=new Frame("ActionListener java8");  
	     
	      Button b=new Button("Click Here");  
	      b.setBounds(50,100,80,50); 
	  
	      b.addActionListener(e -> System.out.println("Hello World!")); 
	      frame.add(b);
	  
	      frame.setSize(200,200);  
	      frame.setLayout(null);  
	      frame.setVisible(true);   
	   }  
	
}
```


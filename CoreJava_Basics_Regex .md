# Java Regex - or - Regular Expression
* **The Java Regex or Regular Expression is an API to define a pattern for searching or manipulating strings.**

* It is widely used to define the constraint on strings such as password and email validation ..etc. 
* Java Regex API provides 1 interface and 3 classes in java.util.regex package.
* A regex is used as a search pattern for strings. Using regex, we can find either a single match or multiple matches as well. We can look for any kind of match in a string e.g. a simple character, a fixed string or any complex pattern of characters such email, SSN or domain names.

* **Regular expressions are the key to powerful, flexible, and efficient text processing. It allow you to describe and parse text.**
*  **Regular expressions can add, remove, isolate, and generally fold, spindle, and mutilate all kinds of text and data.**

#### java.util.regex package

* The Matcher and Pattern classes provide the facility of Java regular expression. The java.util.regex package provides following classes and interfaces for regular expressions.

  * MatchResult interface
  * Matcher class
  * Pattern class
  * PatternSyntaxException class

#### Matcher class 

* It implements the MatchResult interface. It is a regex engine which is used to perform match operations on a character sequence.

* Refer all available methods from : https://www.javatpoint.com/java-regex

#### Pattern class

* It is the compiled version of a regular expression. It is used to define a pattern for the regex engine.
* Refer all available methods from : https://www.javatpoint.com/java-regex

#### Regex Metacharacters
* Let’s explore the commonly used metacharacters to understand them better.
  
  * **Start and End of the Line**
  * The start and end are represented with '^' (caret) and '$' (dollar) signs. The caret and dollar are special in that they match a position in the line rather than any actual text characters themselves.

  * For example, the regular expression “cat” finds ‘cat’ anywhere in the string, but “^cat” matches only if the ‘cat’ is at the beginning of the line. e.g. words like ‘category’ or ‘catalogue’.

  * Similarly, “cat$” matches only if the ‘cat’ is at the end of the line. e.g. words like ‘scat’.

  * **Character Classes**
  * The regular-expression construct "[···]", usually called a character class, lets us list the characters we want to allow at that point in the match. Character classes are useful in creating spell-checkers.

  * For example, while “e” matches just an e, and “a” matches just an a, the regular expression [ea] matches either. e.g. sep[ea]r[ea]te will match all the words “seperate” “separate” and “separete”.

  * Another example can be to allow capitalization of a word’s first letter e.g. [Ss]mith will allow the words smith and Smith both.

  * Similarly, <[hH][123456]> will match all heading tags i.e. H1, H2, H3, H4, H5 and H6.
  
  
  
#### Example of Java Regular Expressions




 
  
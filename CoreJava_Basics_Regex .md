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
 
  * **Range of characters**
  * A dash " - " indicates a range of characters. <[hH][1-6]> is similar to <[hH][123456]>. Other useful character ranges are [0-9] and [a-z] which match digits and English lowercase letters.

  * We can specify multiple ranges in single construct e.g. [0123456789abcdefABCDEF] can be written as [0-9a-fA-F]. Note that order in which ranges are given doesn’t matter.

  * Note that a dash is a metacharacter only within a character class, otherwise it matches the normal dash character. Also, if it is the first character listed in the range, it can’t possibly indicate a range, so it will not be meta character in this case. 
  
  * **Negated character classes**
  * If we use negation sign ( ^ ) in a character class then the class matches any character that isn’t listed. e.g. [^1-6] matches a character that’s not 1 through 6.
  
  * **Matching Any Character with Dot**
  * The metacharacter ' . ' is a shorthand for a character class that matches any character. Note that dots are not metacharacters when they are used within character classes. Within character class, it is a simple character only.

  * For example, 06.24.2019 will match 06/24/2019 or 06-24-2019 or 06.24.2019. But
06[.]24[.]2019 will match only 06.24.2019.

  * **Matching Alternation – any one of several sub-expressions**
  
  * Pipe symbol '|' allows you to combine multiple expressions into a single expression that matches any of the individual ones.

  * For example, “Alex” and “Brian” are separate expressions, but "Alex|Brian" is one expression that matches either of both.

  * Similar to dot, pipe is not metacharacter when it is used within character class. Within character class, it is a simple character only.

  * For example, to match the words “First” or “1st”, we can write regex – “(First|1st)” or in shorthand "(Fir|1)st".

  
#### Example of Java Regular Expressions
```Java
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class Main 
{
 public static void main(String[] args) 
 {
  Pattern pattern = Pattern.compile("Alex|Brian");
  Matcher matcher = pattern.matcher("Generally, Alex and Brian share a great bonding.");
   
  while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(" - " + matcher.group());
        }
 }
}
```

Program output.

```Console
Console
Start index: 11 End index: 15  - Alex
Start index: 20 End index: 25  - Brian
```
#### Regex Character classes

**No.** | **Character Class** | **Description**
---------- | --------------------- | --------------------
1	| [abc]	| a, b, or c (simple class)
2	| [^abc] |	Any character except a, b, or c (negation)
3	| [a-zA-Z]	| a through z or A through Z, inclusive (range)
4	| [a-d[m-p]]	 | a through d, or m through p: [a-dm-p] (union)
5	| [a-z&&[def]]	| d, e, or f (intersection)
6	| [a-z&&[^bc]]	| a through z, except for b and c: [ad-z] (subtraction)
7	| [a-z&&[^m-p]]	| a through z, and not m through p: [a-lq-z](subtraction)

 
  
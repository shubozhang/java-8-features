# java-8-features

###Module-01
Lambda expression: 
* To make instances of anonymous classes easier to write and read.
* Another way to write anonymous classes
* What is the type of a lambda expression? It is a functional interface which has only one abstract method.
Functional interface examples:
```java
public interface Runnable{ run(); };

public interface Comparator<T>{ int compare(T t1, T, t2); };

public interface FileFilter{ boolean accept(File pathname); };
```
Note: methods from Object class don't count.

* Can a lambda be put in a variable?
* Is a lambda expression an object?



The lambda syntax

Functional interfaces

Method references

Constructor references

How to process data from the Collection API

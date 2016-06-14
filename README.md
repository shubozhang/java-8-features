# java-8-features

###Module-01
####1. Lambda expression: 
* To make instances of anonymous classes easier to write and read.
* Another way to write anonymous classes
* What is the type of a lambda expression? It is a functional interface which has only one abstract method.

```java
//Functional interface examples:
public interface Runnable{ run(); };

public interface Comparator<T>{ int compare(T t1, T, t2); };

public interface FileFilter{ boolean accept(File pathname); };
```
Note: methods from Object class don't count.

* @FunctionalInterface annotation is optional. Compile can tell that whether the interface is functional or not.

* Can a lambda be put in a variable? Yes. The consequences are a lambda can be taken as a method parameter, and can be returned by a method.
* Is a lambda expression an object? No. A lambda expression is created without using new key word. Exact answer: a lambda is an object without an identity. A lambda expression should not be used as a regular object.

####2. Functional interfaces toolbox

Method references

Constructor references

How to process data from the Collection API

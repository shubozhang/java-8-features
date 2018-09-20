# Java-8-features

### Module-01
#### 1.1 What is a Lambda expression for: 

   * To make instances of anonymous classes easier to write and read.
   * Another way to write anonymous classes
   * What is the type of a lambda expression? It is a functional interface which has only one abstract method.

Functional interface examples:
```java
public interface Runnable{ run(); }

public interface Comparator<T>{ int compare(T t1, T, t2); };

public interface FileFilter{ boolean accept(File pathname); };
```
Note: methods from Object class don't count.

   * What is the type of a lambda expression?
    A functional interface which is an interface with only one abstract method. @Functional Interface annotation is optional. 
    Compiler can tell that whether the interface is functional or not.
    
   * Can a lambda be put in a variable? 
    Yes. The consequences are a lambda can be taken as a method parameter, and can be returned by a method.
    
   * Is a lambda expression an object? 
    No. A lambda expression is created without using new key word. Exact answer: a lambda is an object without an identity. 
    A lambda expression should not be used as a regular object.

#### 1.2. Functional interfaces toolbox
```
new package: java.util.function // with a rich set of functional interfaces
```

4 categories:

//1) Supplier: NO input argument but returns a result.  
// NOTE: This may return different values when it is being called more than once.
```
public interface Supplier<T>{ T get(); };
```


//2) Consumer / BiConsumer: an operation that accepts one or two input arguments and returns no result
```
public interface Consumer<T> { void accept(T t); };
public interface BiConsumer<T, U>{ void accept(T t, U u); };
```

//3) Predicate / BiPredicate: Represents a predicate (boolean-valued function) of one argument.
```
public interface Predicate<T> { boolean test(T t);};
public interface BiPredicate<T, U> { boolean test(T t, U u);};
```

//4) Function / BiFunction : Represents a function that accepts one argument and produces a result.
```
public interface Function<T,R>{ R apply(T t);};
public interface BiFunction<T,U,R> { R apply(T t, U u); }
```

//BinaryOperator / UnaryOperatorRepresents an operation on a single operand that produces a result of the same type as its operand. 
//This is a specialization of Function for the case where the operand and result are of the same type.
```
public interface UnaryOperator<T> extends Function<T,R>{}
public interface BinaryOperator<T> extends BiFunction<T,U,R>{}
```

#### 1.3 Method references
   * ``"::"`` can be used to refer both **non-static and static** methods
```
Consumer<String> c = s -> System.out.println(s);
Consumer<String> c = System.out::println;

Comparator<Integer> c = (i1, i2) -> Integer.compare(i1,i2);
Comparator<Integer> c = Integer::compare;
```

#### 1.4 Process data in Java
* Where are out objects? Most of the time in a Collection(or maybe a List, a Set or a Map)

* Process data with lambdas

```
List<Customer> list
list.forEach(customer -> System.out.println(customer));
```
or 
```
list.forEach(System.out::println);
```

```
// default key word is a new concept in java 8. 
// It allows to change the old interfaces without breaking the existing implementations.
// It also allows new patterns.
// Static methods are also allowed in java 8 interfaces.
public interface Iterable<E> {
    default void forEach(Consumer<E> consumer) {
        for (E e : this) {
            consumer.accept(e);
        }
    }
}
```

* Examples of new patterns

```
Predicate<String> p1 = s -> s.length() < 20;
Predicate<String> p2 = s -> s.length() > 10;

Predicate<String> id = Predicate.isEqual(target);
```

### Module-02 Streams and Collectors
   * Map / filter /reduce
   * what is a Stream?
   * Patterns to build a Stream
   * Operations on a Stream


#### 2.1.Map /Filter /Reduce
* Mapping
    * The mapping step takes a List<Person> and returns a List<Integer>.
    * The size of both lists is the same.

* Filtering
    * The filtering step takes a List<Integer> and return a List<Integer>.
    * But there some elements have been filtered out in the process.

* Reduce
    * This is the reduction step, equivalent to the SQL aggregation.

#### 2.2 What is a Stream? It is a new concept, and not collection.
* Technical answer: a typed interface 
    * An object on which one can define operations
    * An object that does not hold any data(this is just a rule, not forced by compliler).
    * An object that should not change the data in processes (multicore, visibility issue, atomic, volatile) 
    * An object able to process data in one pass
    * An object optimized from the algorithm point of view, and able to process data in parallel.

```java
public interface Stream<T> extends BaseStream<T, Stream<T>>{}
```

2.2 What does it do?
It gives ways to efficiently process large amounts of data... and also smaller ones.

2.3 How efficient?
    * In parallel, to leverage the computing power of multi-core CPUs.
    * Pipelined, to avoid unnecessary intermediary computations.

2.4 Why can't a Collection be a Stream?
Because Stream is a new concept, and we don't want to change the way the Collection API works.

* Build a Stream (many patterns)
    * forEach operation: return type is void
    * Chain consumer is the only way to have several consumers on a single stream, because forEach method does not return anything.

```
List<Person> persons;
Stream<Person> stream = persons.stream();
stream.forEach(p -> System.out.println(p));

or
Consumer<T> c1 = p -> System.out.println(p);
Consumer<T> c2 = System.out::println; // method reference
stream.forEach(c1);
stream.forEach(c2);
```

    * Filter operation: return type is Stream
    * Warning: method calls do not handle priorities

```
List<Person> persons;
Stream<Person> stream = persons.stream();
Stream<Person> filtered = stream.filter(person -> person.getAge() > 20);

or

Predicate<Person> p1 = person -> person.getAge() > 20;

//Predicates combinations examples:
Predicate<Integer> p1 = i -> i > 20;
Predicate<Integer> p2 = i -> i < 30;
Predicate<Integer> p3 = i -> i == 0;

Predicate<Integer> p4 = p1.and(p2).or(p3);
Predicate<Integer> p5 = p3.or(p1).and(p2);

// Predicate interface with static method
public interface Predicate<T>{
    static <T> Predicate<T> isEqual(Object o) {}
}
Predicate<String> p5 = Predicate.isEqual("two");


//Use case
Predicate<String> p6 = Predicate.isEqual("two);
Stream<String> stream1 = Stream.of("one", "two", "three");
Stream<String> stream2 = stream1.filter(p6)
stream2.forEach(System.out::println);
```

* what do I have in this new Stream?
    * the filtered data?
    * Right answer: nothing, since a Stream does not hold any data

``
// this code does nothing but a declaration, no data is processed. 
List<Person> persons;
Stream<Person> stream = persons.stream();
Stream<Person> filtered = stream.filter(person -> person.getAge() > 20);
```

    * The call to the filter method is lazy. forEach method is not lazy.
    * All the methods of Stream that return another Stream are lazy. 
    * An operation on a Stream that returns a Stream is called an intermediary operation.

```
// this code also does nothing, print nothing, and result is empty
List<String> result = new ArrayList<>;
List<Person> persons;

persons.stream().peek(System.out::println).filter(person -> person.getAge() > 20).peek(result::add);
```

* Map Operation
**Stream map(Function)**: lazy

```java
public interface Function<T,R>{
    R apply(T t);
    
    default <V> Function<V,R> compose(Function<V,T> before);
    default <V> Function<T, V> andThen(Function<R,V> after);
    
    static <T> Function<T, T> identity(){ return t -> t; }
}
```

* Flatmapping operation
**Stream<Stream<R>> flatMap()**
** Signature

```
<R> Stream<R> flatMap(Function<T, Stream<R>> flatMapper);
<R> Stream<R> map(Function<T, R> mapper);
```

    * If the flatMap was a regular map, it would return a Stream<Stream<R>>, thus a stream of streams. 
    But it is a flatMap, so the stream of streams is flattened, and becomes a stream.


* Summary
    * The Stream API defines intermediary operations, 3 operations:
**void forEach(Consumer)**: not lazy
**Stream peek(Consumer)**: lazy
**Stream filter(Predicate)**:lazy
**map() and flatMap()**: lazy


FlatMap vs Map

```
flatMap = map + flatten

Define a function g, which returns a list of 3 elements
scala> def g(v:Int) = List(v-1, v, v+1)

Create a list of 3 elements
scala> var list = List(1,2,3)  

function g is applied to each element of the list using flatMap
scala> list.flatMap(x => g(x))    
res1: List[Int] = List(0,1,2,1,2,3,2,3,4)    

function g is applied to each element of the list using map  
scala> list.map(x => g(x))    
res2: List[List[Int]]] = List(List(0, 1, 2), List(1, 2, 3), List(2, 3, 4))    

function g is applied to each element of the list using map and the flatten
scala> list.map(x => g(x)).flatten    
res3: List[Int] = List(0,1,2,1,2,3,2,3,4)

result of flatMap = result of map + flatten 
```


* Reduction
    * What about the reduction step?
    * Two kinds of reduction in the Stream API

```
// First: aggregation = min, max, sum, etc...
List<Integer> ages
Stream<Integer> stream = ages.stream();
Integer sum = stream.reduce(0, (age1, age2) -> age1 + age2);

// 1st arg: identity element of the reduction operation
// 2nd arg: reduction operation, of type BinaryOperator<T>

public interface BiFunction<T,U,R>{
    R apply(T t, U u);
}

public interface BinaryOperator<T> extends BiFunction<T, T, T>{
    T apply(T t1, T t2);
}
```

* Identity Element
    * The bifunction takes two arguments, so what happens if the Stream is empty? And what happens if the Stream has only one element? 

The reduction of an empty Stream is the identity element

If the Stream has only one element, then the reduction is that element.

```
// Aggregations example
Stream<Integer> stream;
BinaryOperation<Integer> sum = (i1, i2) -> i1 + i2;
Integer id = 0;

int red = stream.reduce(id,sum);

Stream<Integer> stream = Stream.empty();
int red = stream.reduce(id, sum);
System.out.println(red);
```


* Reductions: are terminal operations
    * Available reductions: max(), min(), count()
    * Boolean reductions: allMatch(), noneMatch(), anyMatch()
    * Reductions that return an optional: findFirst(), findAny();

They trigger the processing of the data



* Summary:

    * Reduction seen as an aggregation

    * Intermediary / terminal operation

    * Optional: needed because default values can't be always defined.



* Collectors
    * Another type of reduction: mutable reduction
    * Instead of aggregating elements, this reduction put them in a container.

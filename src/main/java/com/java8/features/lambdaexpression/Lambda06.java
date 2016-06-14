package com.java8.features.lambdaexpression;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Stream
 */
public class Lambda06 {

    public static void main(String[] args) {
        Predicate<String> p1 = Predicate.isEqual("two");
        Predicate<String> p2 = Predicate.isEqual("three");
        Stream<String> stream1 = Stream.of("one", "two", "three","four");
        Stream<String> stream2 = stream1.filter(p1.or(p2));

        stream2.forEach(System.out::println);
    }
}

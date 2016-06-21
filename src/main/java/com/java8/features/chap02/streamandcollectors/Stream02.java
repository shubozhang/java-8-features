package com.java8.features.chap02.streamandcollectors;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Intermediary and final operations
 *
 * Only final operation will trigger the implementation.
 */
public class Stream02 {

    public static void main(String[] args) {
        Predicate<String> p1 = Predicate.isEqual("two");
        Predicate<String> p2 = Predicate.isEqual("three");
        Stream<String> stream1 = Stream.of("one", "two", "three","four","five");
        Stream<String> stream2 = Stream.of("one", "two", "three","four","five");

        List<String> list1 = new ArrayList<>();

        stream1.peek(System.out::println).filter(p1.or(p2)).peek(list1::add);

        System.out.println("Intermediary stream is Done");
        System.out.println("size of list = " + list1.size());


        List<String> list2 = new ArrayList<>();

        stream2.filter(p1.or(p2)).peek(list2::add).forEach(System.out::println);

        System.out.println("final stream is Done");
        System.out.println("size of list = " + list2.size());
    }
}

package com.java8.ch02.streamandcollectors;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Stream creation
 */
public class Stream01Creation {

    public static void main(String[] args) {
        example01();
        example02();
        example03();
        example04();
    }

    private static void example01() {
        System.out.println("example01:");
        String[] wordList = {"gently", "down", "the", "stream"};
        Stream<String> words = Stream.of(wordList);
        words.forEach(p -> System.out.println(p));
    }

    private static void example02() {
        System.out.println("example02: ");
        Stream<String> song = Stream.of("gently", "down", "the", "stream");
        song.forEach(System.out::println);
    }

    private static void example03() {
        System.out.println("example03: ");
        //To make a stream with no elements, use the static Stream.empty method:
        Stream<String> silence = Stream.empty();
        silence.findAny();
    }

    private static void example04() {
        //The Stream interface has two static methods for making infinite streams: generate() and iterate
        Predicate<String> p1 = Predicate.isEqual("two");
        Predicate<String> p2 = Predicate.isEqual("three");
        Stream<String> stream1 = Stream.of("one", "two", "three","four");
        Stream<String> stream2 = stream1.filter(p1.or(p2));

        System.out.println("example04: ");
        stream2.forEach(System.out::println);
    }

}

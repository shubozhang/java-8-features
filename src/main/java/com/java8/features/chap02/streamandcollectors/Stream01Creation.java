package com.java8.features.chap02.streamandcollectors;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Stream creation
 */
public class Stream01Creation {

    public static void main(String[] args) {

        //
        String[] wordList = {"gently", "down", "the", "stream"};
        Stream<String> words = Stream.of(wordList);

        //
        Stream<String> song = Stream.of("gently", "down", "the", "stream");

        //To make a stream with no elements, use the static Stream.empty method:
        Stream<String> silence = Stream.empty();

        //The Stream interface has two static methods for making infinite streams: generate() and iterate

        Predicate<String> p1 = Predicate.isEqual("two");
        Predicate<String> p2 = Predicate.isEqual("three");
        Stream<String> stream1 = Stream.of("one", "two", "three","four");
        Stream<String> stream2 = stream1.filter(p1.or(p2));

        stream2.forEach(System.out::println);
    }
}

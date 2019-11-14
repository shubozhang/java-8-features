package com.java8.ch02.streamandcollectors;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Map and FlatMap operations
 */
public class Stream03Map {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> list2 = Arrays.asList(2,4,6);
        List<Integer> list3 = Arrays.asList(1,3,5,7);

        List<List<Integer>> list = Arrays.asList(list1,list2, list3);
        System.out.println(list);

        example01(list);
        example02(list);
        example03(list1);
    }

    // Map example
    private static void example01(List<List<Integer>> list) {
        System.out.println("Example01: ");
        Function<List<?>,Integer> mapper = List::size;
        list.stream().map(l -> l.size()).forEach(System.out::println);

        System.out.println("Example01-using Function mapper: ");
        list.stream().map(mapper).forEach(System.out::println);
    }

    // FlatMap example
    private static void example02(List<List<Integer>> list) {
        System.out.println("Example02 FlatMap: ");
        Function<List<Integer>, Stream<Integer>> flatMapper = l -> l.stream();
        list.stream().map(flatMapper).forEach(System.out::println);

        System.out.println("Example02 FlatMap--user Function flatMapper: ");
        list.stream().flatMap(flatMapper).forEach(System.out::println);
    }


    private static void example03(List<Integer> list) {
        System.out.println("Example03 Max function: ");
        Optional<Integer> max = list.stream().max(Comparator.naturalOrder());
        System.out.println(max.get());
    }
}

package com.java8.features.chap01.lambdaexpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * default method
 */
public class Lambda05 {

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("one","two","three","four");

        List<String> list2 = new ArrayList<>();

        Consumer<String> c1 = s -> System.out.println(s);
        Consumer<String> c2 = System.out::println; // c1 and c2 are same.

        Consumer<String> c3 = s -> list2.add(s);
        Consumer<String> c4 = list2::add; // c3 and c4 are same


        // forEach is a default method
        System.out.println("c1 forEach");
        list1.forEach(c1);

        System.out.println("c2 forEach");
        list1.forEach(c2);

        System.out.println("default forEach");
        list1.forEach(System.out::println);

        // Chain consumers
        System.out.println("c1, c3 chain consumers");
        list1.forEach(c1.andThen(c3));
        System.out.println("Size of list2 = " + list2.size());

        // 2nd way to implement chain consumer
        /*Consumer<String> c5 = c1.andThen(c3);
        list1.forEach(c5);*/
    }
}

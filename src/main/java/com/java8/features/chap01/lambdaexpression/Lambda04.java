package com.java8.features.chap01.lambdaexpression;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Method reference
 */
public class Lambda04 {

    public static void main(String[] args) {
        Consumer<String> c1 = s -> System.out.println(s);

        Consumer<String> c2 = System.out::println;

        Comparator<Integer> c3 = (i1, i2) -> Integer.compare(i1,i2);

        Comparator<Integer> c4 = Integer::compare;
    }
}

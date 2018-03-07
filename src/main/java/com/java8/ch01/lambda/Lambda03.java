package com.java8.ch01.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambda03 {

    static Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    };


    static Comparator<String> comparatorLambda = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());

    // Most of the time, parameter types can be omitted
    static Comparator<String> comparatorLambda1 = (s1, s2) -> Integer.compare(s1.length(), s2.length());

    static Comparator<String> comparatorLambda2 = Comparator.comparing(String :: length);

    public static void main(String[] args) {
        runComparator(comparator);

        runComparator(comparatorLambda);

        runComparator(comparatorLambda1);

        runComparator(comparatorLambda2);

    }

    public static void runComparator(Comparator comparator) {
        List<String> list = Arrays.asList("**","*","****","***");
        Collections.sort(list,comparator);
        System.out.println("starting");
        list.forEach(System.out::println);
        System.out.println("ending");
    }
}

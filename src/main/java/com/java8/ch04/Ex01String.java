package com.java8.ch04;


import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * StringJoiner
 */
public class Ex01String {

    public static void main(String[] args) {
        demo1();

        demo2();
    }

    private static void demo1() {
        String s = "Hello World";
        IntStream stream = s.chars();
        stream.forEach(p -> System.out.println(String.valueOf(p)));
    }

    private static void demo2() {
        String s1 = "Hello";
        String s2 = "World";

        String s = s1 + " " + s2;
        System.out.println(s);

        // Better solution
        StringBuilder sb = new StringBuilder();
        sb.append("Hello").append(" ").append("World");

        String s3 = sb.toString();
        System.out.println(s3);

        StringJoiner sj = new StringJoiner(",");
        sj.add("one").add("two").add("three");
        System.out.println(sj);

        StringJoiner sj1 = new StringJoiner(",","{","]");
        sj1.add("one").add("two").add("three");
        System.out.println(sj1);

        String s4 = String.join(",","one","two","three");
        System.out.println(s4);
    }
}

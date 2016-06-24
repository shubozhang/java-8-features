package com.java8.features.chap04;


import java.util.StringJoiner;
import java.util.stream.Stream;

/**
 * Created by shubo.zhang on 6/24/2016.
 */
public class Ex01String {

    public static void main(String[] args) {
        demo1();

        demo2();
    }

    private static void demo1() {
        String s = "Hello World";
        //Stream stream = (Stream) s.chars();

        //stream.map(String::toUpperCase).forEach(System.out::println);
    }

    private static void demo2() {
        String s1 = "Hello";
        String s2 = "World";

        String s = s1 + " " + s2;

        // Better solution
        StringBuilder sb = new StringBuilder();
        sb.append("Hello").append(" ").append("World");

        String s3 = sb.toString();

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

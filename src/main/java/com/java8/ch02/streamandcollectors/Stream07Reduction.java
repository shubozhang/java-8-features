package com.java8.ch02.streamandcollectors;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


// terminal operation
public class Stream07Reduction {

    public static void main(String[] args) {
        demo1();

        demo2();

        demo3();
    }

    private static void demo1() {
        List<Integer> list = Arrays.asList(10, 11, 12);

        Integer red = list.stream().reduce(0, Integer::sum);

        System.out.println("demo1 red = " + red);
    }

    private static void demo2() {
        List<Integer> list1 = Arrays.asList(10, 11, 12);
        List<Integer> list2 = Arrays.asList(-10, -11);

        // First v1 = max(0, -10); Second v2=max(v1,-11); Lastly, maxValue = v2
        Integer red1 = list1.stream().reduce(0, Integer::max);
        Integer red2 = list2.stream().reduce(0, Integer::max);

        System.out.println("demo2 red1 = " + red1 + " and red2 = " + red2);
    }

    private static void demo3() {
        List<Integer> list1 = Arrays.asList(-10, -11);
        List<Integer> list2 = Arrays.asList();

        Optional<Integer> red1 = list1.stream().reduce(Integer::max); // Return type is optional
        Optional<Integer> red2 = list2.stream().reduce(Integer::max);

        System.out.println("demo3 red1 = " + red1 + " and red2 = " + red2);
    }
}

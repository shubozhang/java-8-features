package com.java8.ch01.lambda;

import java.io.File;
import java.util.function.Function;

/**
 * Created by Shubo on 8/19/2017.
 */
public class Lambda07Function {

    public static void main(String[] args) {

        example01();

        example02();
    }


    //1. how to use Function
    private static void example01() {
        Function<Integer,String> converter = (i)-> Integer.toString(i);

        System.out.println(converter.apply(3).length());
        System.out.println(converter.apply(30).length());
    }


    // 2.  how to pass Function as parameter.
    private static void example02() {
        Function<Integer, String> bi = (a) -> "Result: " + (a * 2);
        String result = calc(bi, 10);

        System.out.println(result);
    }

    private static String calc(Function<Integer, String> bi, Integer i) {
        return bi.apply(i);
    }
}

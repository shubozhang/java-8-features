package com.java8.features.chap01.lambdaexpression;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * Created by Shubo on 8/19/2017.
 */
public class Lambda08Operator {

    public static void main(String[] args) {
        example01();

        example02();
    }

    private static void example01() {
        UnaryOperator<String> i  = (x)-> x.toUpperCase();

        System.out.println(i.apply("java2s.com"));
    }

    private static void example02() {
        BinaryOperator<Integer> adder = (n1, n2) -> n1 + n2;

        System.out.println(adder.apply(3, 4));
    }
}

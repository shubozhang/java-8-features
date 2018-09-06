package com.java8.ch01.lambda;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

// extended function interface
// static <T> UnaryOperator<T> identity() { return t -> t;}
public class Lambda08Operator {

    public static void main(String[] args) {
        example01();

        example02();
    }

    // UnaryOperator
    private static void example01() {
        UnaryOperator<String> i  = (x)-> x.toUpperCase();

        System.out.println(i.apply("java2s.com"));
    }

    // BinaryOperator
    private static void example02() {
        BinaryOperator<Integer> adder = (n1, n2) -> n1 + n2;

        System.out.println(adder.apply(3, 4));
    }
}

package com.java8.features.chap01.lambdaexpression;

import com.java8.features.util.SunPower;

import java.util.Objects;
import java.util.function.Supplier;

public class Lambda04Supplier {

    public static void main(String[] args) {
        example01();
        example02();
        example03();
    }

    // 1. how to use Supplier
    private static void example01() {
        Supplier<String> i  = ()-> "java2s.com";

        System.out.println(i.get());
    }

    // 2. how to pass Supplier as parameter
    private static void example02() {
        SunPower power = new SunPower();
        SunPower p1 = produce(() -> power);
        SunPower p2 = produce(() -> power);
        System.out.println("Check the same object? " + Objects.equals(p1, p2));
    }

    public static SunPower produce(Supplier<SunPower> supp) {
        return supp.get();
    }

    // 3. how to use Constructor as method reference for Supplier.

    private static void example03() {
        System.out.println(maker(Employee::new));
    }
    private static Employee maker(Supplier<Employee> fx) {
        return fx.get();
    }

    static class Employee {
        @Override
        public String toString() {
            return "A EMPLOYEE";
        }
    }
}

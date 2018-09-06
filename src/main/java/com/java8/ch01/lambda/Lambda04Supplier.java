package com.java8.ch01.lambda;

import com.java8.ch01.lambda.model.Student;
import com.java8.ch01.lambda.model.SunPower;

import java.util.Objects;
import java.util.function.Supplier;

// Supplier: only one method T get(), no input arg -> return one result
public class Lambda04Supplier {

    public static void main(String[] args) {
        example01();
        example02();
        example03();
        example04();
    }

    // 1. how to use Supplier
    private static void example01() {
        Supplier<String> i  = ()-> "java2s.com";

        System.out.println("example01: " +i.get());
    }

    // 2. how to pass Supplier as parameter
    private static void example02() {
        SunPower power = new SunPower();
        SunPower p1 = produce(() -> power);
        SunPower p2 = produce(() -> power);
        System.out.println("Example02: check the same object? " + Objects.equals(p1, p2));
    }

    public static SunPower produce(Supplier<SunPower> supp) {
        return supp.get();
    }

    // 3. how to use Constructor as method reference for Supplier.
    private static void example03() {
        System.out.println("example03: " + maker(Employee::new));
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

    //4. how to assign user defined function to Supplier with method reference.
    private static void example04() {
        Supplier<Student> studentGenerator = Lambda04Supplier::employeeMaker;

        for (int i = 0; i < 10; i++) {
            System.out.println("example04: #" + i + ": " + studentGenerator.get());
        }
    }

    public static Student employeeMaker() {
        return new Student("A",2);
    }

}

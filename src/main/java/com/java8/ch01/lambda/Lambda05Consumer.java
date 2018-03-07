package com.java8.ch01.lambda;

import com.java8.util.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Shubo on 8/19/2017.
 */
public class Lambda05Consumer {

    public static void main(String[] args) {
        example01();

        example02();

        new Lambda05Consumer().example03();

        example04();
    }

    // 1. how to use Consumer.
    private static void example01() {
        Consumer<String> consumer1 = s -> System.out.println(s);
        Consumer<String> consumer2 = System.out::println;
        Consumer<String> consumer3 = Lambda05Consumer::getNameInfo;

        testConsumer(consumer1);
        testConsumer(consumer2);
        consumer3.accept("John Doe");
        consumer3.accept("Mike Bibby");
    }


    //  2. how to create consumer with block statement.
    private static void example02() {
        int x = 99;

        Consumer<Integer> myConsumer = (y) ->{
            System.out.println("x = " + x); // Statement A
            System.out.println("y = " + y);
        };

        myConsumer.accept(x);
    }

    // 3. how to pass Consumer as parameter.
    private  void example03() {
        List<Student> students = Arrays.asList(
                new Student("John", 3),
                new Student("Mark", 4)
        );

        acceptAllEmployee(students, e -> System.out.println(e.name)); // operation: print name
        acceptAllEmployee(students, e -> {e.gpa *= 1.5;}); // operation: modify gpa
        acceptAllEmployee(students, e -> System.out.println(e.name + ": " + e.gpa)); // operation: print name and gpa
    }

    // 4. default method / andThen method
    private static void example04() {
        List<String> list1 = Arrays.asList("one","two","three","four");

        List<String> list2 = new ArrayList<>();

        Consumer<String> c1 = s -> System.out.println(s);
        Consumer<String> c2 = System.out::println; // c1 and c2 are same.

        // list2 has 0 element before c3 is called.
        Consumer<String> c3 = s -> list2.add(s);
        Consumer<String> c4 = list2::add; // c3 and c4 are same


        // forEach is a default method
        System.out.println("c1 forEach");
        list1.forEach(c1);

        System.out.println("c2 forEach");
        list1.forEach(c2);

        System.out.println("default forEach");
        list1.forEach(System.out::println);

        // Chain consumers
        System.out.println("c1, c3 chain consumers");
        System.out.println("Before: Size of list2 = " + list2.size());
        list1.forEach(c1.andThen(c3));
        System.out.println("After: Size of list2 = " + list2.size());

        // 2nd way to implement chain consumer
        /*Consumer<String> c5 = c1.andThen(c3);
        list1.forEach(c5);*/
    }

    private static void acceptAllEmployee(List<Student> student, Consumer<Student> printer) {
        for (Student e : student) {
            printer.accept(e);
        }
    }

    private static void testConsumer(Consumer consumer) {
        String[] strs = {"A", "B", "C"};
        Arrays.stream(strs).forEach(consumer);
    }

    private static void getNameInfo(String fullName) {
        String[] names = fullName.split(" ");
        String firstName = names[0];
        String lastName = names[1];
        int length = firstName.length();

        System.out.println("Your input is: " + fullName);
        System.out.println("Saved as First_Name: " + firstName + " Last_Name: " + lastName + " First_Name_length is: " + length);
    }

}

package com.java8.features.chap01.lambdaexpression;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Method reference
 */
public class Lambda04 {

    public static void main(String[] args) {
        Consumer<String> consumer1 = s -> System.out.println(s);
        Consumer<String> consumer2 = System.out::println;
        Consumer<String> consumer3 = Lambda04::getNameInfo;

        testConsumer(consumer1);
        testConsumer(consumer2);
        consumer3.accept("John Doe");
        consumer3.accept("Mike Bibby");

        Comparator<Integer> c3 = (i1, i2) -> Integer.compare(i1,i2);

        Comparator<Integer> c4 = Integer::compare;
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

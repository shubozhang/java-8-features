package com.java8.features.chap04;

import com.java8.features.chap02.streamandcollectors.model.Person;

import java.util.Comparator;

public class Ex04Comparators {

    public static void main(String[] args) {

        demo1();
    }

    private static void demo1() {
        Comparator<Person> compare = Comparator.comparing(Person::getName).thenComparing(Person::getAge);

        Comparator<Person> compare1 = compare.reversed();

        Comparator<String> compare2 = Comparator.naturalOrder();

        Comparator<String> compare3 = Comparator.nullsFirst(Comparator.<String>naturalOrder());

        Comparator<String> compare4 = Comparator.nullsLast(Comparator.<String>naturalOrder());


    }
}

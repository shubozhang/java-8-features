package com.java8.features.chap02.streamandcollectors;

import com.java8.features.chap02.streamandcollectors.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Stream06Terminal {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        Optional<Integer> minAge = persons.stream()
                .map(person -> person.getAge()) // Stream<Integer>
                .filter(age -> age > 20) // Stream<Integer>
                .min(Comparator.naturalOrder()); // terminal operation

        System.out.println(minAge.orElse(0));
    }
}

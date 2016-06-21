package com.java8.features.chap02.streamandcollectors;

import com.java8.features.chap02.streamandcollectors.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collector01 {

    public static void main(String[] args) {

        Person person1 = new Person("A", 25);
        Person person2 = new Person("B", 15);
        Person person3 = new Person("C", 35);
        Person person4 = new Person("D", 25);
        Person person5 = new Person("E", 35);
        Person person6 = new Person("F", 35);

        List<Person> persons = Arrays.asList(person1,person2, person3, person4, person5, person6);

        demo1(persons);

        demo2(persons);

        demo3(persons);

        demo4(persons);
    }

    private static void demo1(List<Person> persons) {
        String result = persons.stream()
                .filter(person -> person.getAge() > 20)
                .map(Person::getName)
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }

    private static void demo2(List<Person> persons) {
        List<String> result = persons.stream()
                .filter(person -> person.getAge() > 20)
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println(result.toString());
    }

    private static void demo3(List<Person> persons) {
        Map<Integer,List<Person>> result = persons.stream()
                .filter(person -> person.getAge() > 20)
                .collect(Collectors.groupingBy(Person::getAge));

        for (Map.Entry<Integer, List<Person>> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
        }
    }

    private static void demo4(List<Person> persons) {
        Map<Integer,Long> result = persons.stream()
                .filter(person -> person.getAge() > 20)
                .collect(Collectors.groupingBy(Person::getAge,Collectors.counting()));

        for (Map.Entry<Integer,Long> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " :" + entry.getValue());
        }
    }
}

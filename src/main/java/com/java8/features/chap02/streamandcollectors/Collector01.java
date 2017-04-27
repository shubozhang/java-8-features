package com.java8.features.chap02.streamandcollectors;

import com.java8.features.chap02.streamandcollectors.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// terminal operation
public class Collector01 {

    public static void main(String[] args) {

        Person person1 = new Person("A", 25, 180, "black");
        Person person2 = new Person("B", 15, 180, "black");
        Person person3 = new Person("C", 35, 180, "black");
        Person person4 = new Person("D", 25, 180, "black");
        Person person5 = new Person("E", 35, 180, "black");
        Person person6 = new Person("F", 35, 180, "black");
        Person person7 = new Person("A", 25, 180, "black");
        Person person8 = new Person("B", 15, 180, "black");

        List<Person> persons = Arrays.asList(person1,person2, person3, person4, person5, person6, person7, person8);

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

        System.out.println("demo1: " + result);
    }

    private static void demo2(List<Person> persons) {
        List<String> result = persons.stream()
                .filter(person -> person.getAge() > 20)
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println("demo2: " + result.toString());
    }

    private static void demo3(List<Person> persons) {
        Map<Integer,List<Person>> result = persons.stream()
                .filter(person -> person.getAge() > 20)
                .collect(Collectors.groupingBy(Person::getAge));

        System.out.println("demo3: ");
        for (Map.Entry<Integer, List<Person>> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
        }
    }

    private static void demo4(List<Person> persons) {
        Map<Integer,Long> result = persons.stream()
                .filter(person -> person.getAge() > 20)
                .collect(Collectors.groupingBy(Person::getAge,Collectors.counting()));

        System.out.println("demo4: ");
        for (Map.Entry<Integer,Long> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " :" + entry.getValue());
        }
    }
}

package com.java8.ch02.streamandcollectors;

import com.java8.ch02.streamandcollectors.model.Person;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream06Terminal {

    public static void main(String[] args) {

        Person person1 = new Person("Arron",40,180,"black");
        Person person2 = new Person("Bob",35,175,"brown");
        Person person3 = new Person("Carlos",18,165,"black");
        Person person4 = new Person("Don",30,155,"blue");

        // Define a fixed-size list
        List<Person> persons = Arrays.asList(person1,person2,person3, person4);

        List<Person> filterByAge = personFilter(persons, new PersonAgePredicate(20));
        System.out.println("filter by age");
        filterByAge.forEach(System.out::println);


        List<Person> filterByHeight = personFilter(persons, new PersonHeightPredicate(170));
        System.out.println("filter by height");
        filterByHeight.forEach(System.out::println);

        List<Person> filterByEyeColor = personFilter(persons, new PersonEyeColorPredicate("black"));
        System.out.println("filter by eyecolor");
        filterByEyeColor.forEach(System.out::println);

        System.out.println("get min age from persons");
        System.out.println(getMinAge(persons));
    }

    public static int getMinAge(List<Person> persons) {
        Optional<Integer> minAge = persons.stream()
                .map(person -> person.getAge()) // Stream<Integer>, intermediary operation
                .min(Comparator.naturalOrder()); // terminate operation

        return minAge.orElse(0);
    }

    public static List<Person> personFilter(List<Person> persons, PersonPredicate personPredicate) {
        List<Person> result = new ArrayList<>();
        Stream<Person> stream = persons.stream();
        stream.filter(personPredicate) //intermediary operation
                .peek(result::add)     //intermediary operation
                .collect(Collectors.toList()); // terminate operation
        return result;
    }

    interface PersonPredicate extends Predicate<Person>{
        public boolean test(Person person);
    }

    static class PersonAgePredicate implements PersonPredicate {
        int age = 20;

        PersonAgePredicate() {}
        PersonAgePredicate(int age) {
            this.age = age;
        }
        @Override
        public boolean test(Person person) {
            return person.getAge() > age;
        }
    }

    static class PersonHeightPredicate implements PersonPredicate {
        int height = 170;

        PersonHeightPredicate() {}
        PersonHeightPredicate(int height) {
            this.height = height;
        }

        @Override
        public boolean test(Person person) {
            return person.getHeight() > height;
        }
    }

    static class PersonEyeColorPredicate implements PersonPredicate {
        String eyeColor = "black";

        PersonEyeColorPredicate() {}
        PersonEyeColorPredicate(String eyeColor) {
            this.eyeColor = eyeColor;
        }

        @Override
        public boolean test(Person person) {
            return eyeColor.equals(person.getEyeColor());
        }
    }
}

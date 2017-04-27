package com.java8.features.chap02.streamandcollectors;

import com.java8.features.chap02.streamandcollectors.model.Person;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collector02 {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        try (
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        Collector02.class.getResourceAsStream("/people.txt")));

                Stream<String> stream = reader.lines();
        ) {

            stream.map(line -> {
                String[] s = line.split(" ");
                Person p = new Person(s[0].trim(), Integer.parseInt(s[1]));
                persons.add(p);
                return p;
            })
                    .forEach(System.out::println);


        } catch (IOException ioe) {
            System.out.println(ioe);
        }


        demo1(persons);
        
        demo2(persons);

        demo3(persons);
    }



    private static void demo1(List<Person> persons) {
        Optional<Person> opt = persons.stream()
                                      .filter(p -> p.getAge() >= 20)
                                      .min(Comparator.comparing(Person::getAge));
        System.out.println("demo1:  "+ opt);
    }

    private static void demo2(List<Person> persons) {

        Optional<Person> opt1 = persons.stream().min(Comparator.comparing(Person::getAge));
        Optional<Person> opt2 = persons.stream().max(Comparator.comparing(Person::getAge));
        System.out.println("demo2: min age is " + opt1 + " and max age is " + opt2);



        Stream<Person> stream2 = persons.stream();
        Optional<Person> opt3 = stream2.min(Comparator.comparing(Person::getAge));
        System.out.println("demo2: min age is " + opt3);

        /*
        * The following implementation will throw exception: Once stream has already been operated upon or closed,
        * it cannot be used again. You have to create a new Stream.
        * */
        /*Optional<Person> opt4 = stream2.max(Comparator.comparing(Person::getAge));
        System.out.println("max age is " + opt4);*/

    }

    private static void demo3(List<Person> persons) {

        Map<Integer, Long> map1 =persons.stream()
                                        .collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));

        System.out.println("demo3: " + map1);


        Map<Integer, String> map2 =persons.stream()
                                            .collect(
                                                    Collectors.groupingBy(Person::getAge,
                                                            Collectors.mapping(Person::getName, Collectors.joining(", "))
                                                    )
                                            );
        System.out.println("demo3: " + map2);

    }
}

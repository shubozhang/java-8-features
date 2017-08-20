package com.java8.features.chap04;

import com.java8.features.chap04.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex08BindingBiMap {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        try (
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(Ex08BindingBiMap.class.getResourceAsStream("/people04.txt")));
                Stream<String> stream = reader.lines();
        ) {

            stream.map(
                    line -> {
                        String[] s = line.split(" ");
                        Person person = new Person(s[0].trim(),Integer.parseInt(s[1]),s[2].trim());
                        persons.add(person);
                        return person;
                    })
                    .forEach(System.out::println);
            System.out.println("End of people list ====================================");

        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        example(persons);
    }

    private static void example(List<Person> persons) {
        Map<Integer,List<Person>> map = persons.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        map.forEach((age,list) -> System.out.println(age + " : " + list));


        Map<Integer,Map<String,List<Person>>> bimap = new HashMap<>();

        persons.forEach(
                person -> bimap.computeIfAbsent(person.getAge(),HashMap::new)
                        .merge(person.getGender(), new ArrayList<>(Arrays.asList(person)),(l1, l2) -> {
                            l1.addAll(l2);
                            return l1;
                        })
        );

        bimap.forEach(
                (age,m) -> System.out.println(age + " : " +m)
        );
    }
}

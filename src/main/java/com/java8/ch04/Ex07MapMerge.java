package com.java8.ch04;

import com.java8.ch04.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex07MapMerge {


    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        try (
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(Ex07MapMerge.class.getResourceAsStream("/people04.txt")));
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

        List<Person> list1 = persons.subList(1,10);
        List<Person> list2 = persons.subList(10,persons.size());

        Ex07MapMerge ex07MapMerge = new Ex07MapMerge();
        ex07MapMerge.testMap01(list1);
        ex07MapMerge.testMap02(list2);


    }

    private  void testMap01(List<Person> list) {
        Map<Integer,List<Person>> map1 = mapByAge(list);
        System.out.println("Map 1 =====================================");
        map1.entrySet().stream().sorted((entry1, entry2) -> {
            return entry1.getKey().compareTo(entry2.getKey());
        }).forEach((entry -> System.out.println(entry.getKey() + "->" + entry.getValue())));

        System.out.println("End of Map 1===============================");
    }

    private  void testMap02(List<Person> list) {
        Map<Integer,List<Person>> map2 = mapByAge(list);
        System.out.println("Map 2 =====================================");
        map2.entrySet().stream()
                .sorted((entry1, entry2) -> {
                    return entry1.getKey().compareTo(entry2.getKey()); })
                .forEach((entry -> System.out.println(entry.getKey() + "->" + entry.getValue())));
        System.out.println("End of Map 2 ==============================");
    }

    private  void testMergeMap(Map<Integer,List<Person>> map1 , Map<Integer,List<Person>> map2 ) {
        map2.entrySet().stream()
                .forEach(
                        entry ->
                                map1.merge(entry.getKey(),entry.getValue(),(mapOne,mapTwo) -> {
                                    mapOne.addAll(mapTwo);
                                    return mapOne;
                                })
                );

        System.out.println("Map 1 merged ==============================");
        map1.entrySet().stream().sorted((entry1, entry2) -> {
            return entry1.getKey().compareTo(entry2.getKey());
        }).forEach((entry -> System.out.println(entry.getKey() + "->" + entry.getValue())));

        System.out.println("End of Map Merge ===============================");
    }
    private  Map<Integer,List<Person>> mapByAge(List<Person> list) {
        Map<Integer,List<Person>> map =
                list.stream().collect(
                        Collectors.groupingBy(Person::getAge)
                );
        return map;
    }
}

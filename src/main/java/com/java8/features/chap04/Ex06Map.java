package com.java8.features.chap04;

import com.java8.features.chap02.streamandcollectors.model.Person;

import java.util.HashMap;
import java.util.Map;

/*
* Method: forEach  takes a BiComsumer as a parameter
*
* get(): in JDK8, key can be null
*
* merge();
* */
public class Ex06Map {

    public static void main(String[] args) {

        demo1();
    }

    private static void demo1() {

        Map<String,Person> map = new HashMap<>();

        Person defaultPerson = new Person("dummy", 0);

        // JDK 8: returns the default value passed as a parameter if there is no value in the map
        Person p = map.getOrDefault("key",defaultPerson);

        map.put("key", new Person()); // will erase the existing person

        map.putIfAbsent("key", new Person()); // will not erase the exist person

        map.replace("key", new Person()); // will erase the existing person

        // Applies the remapping function to all the existing key/person pairs
        Person newPerson = new Person();
        map.replaceAll((key,oldPerson)-> newPerson);


        map.remove("key"); // JDK 7
        map.remove("key", new Person()); // JDK 8

    }

    /*
    * compute()  / computeIfPresent() /computeIfAbsent
    * */


    private static void demo2() {
        Map<String,Person> map = new HashMap<>();

        String key1 = "key";
        Person person1 = new Person();
        Person person2 = new Person();
        //Person oldPerson = new Person();
        //map.compute(key1,person1,(key1,oldPerson) -> person2);
    }
 }

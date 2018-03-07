package com.java8.ch02.streamandcollectors;

import java.util.Optional;

/**
 * Use isPresent() method to check if value exists
 *
 * Use get() to get value
 *
 * orElse("") encapsulates both calls, "" is the default value
 *
 * orElseThrow(MyException::new) , throw exception
 *
 * Best practices: only use optional as a return type.
 */
public class Stream05Optionals {


    public static void main(String[] args) {
        optional01("test1");
        optional01(null);

        optional02("test2");
        optional02(null);

        optional03("test3");
        optional03(null);

    }

    // example 01
    public static void optional01(String s) {
        Optional<String> stringOptional = Optional.ofNullable(s);
        String str;
        if (stringOptional.isPresent()) {
            str = stringOptional.get();
        } else {
            str = "<String is null>";
        }
        System.out.println(str);
    }


    // example 02
    public static void optional02(String s) {
        Optional<String> stringOptional = Optional.ofNullable(s);
        String str = stringOptional.orElse("<String is null>");
        System.out.println(str);
    }


    // example 03
    public static void optional03(String s) {
        Optional<String> stringOptional = Optional.ofNullable(s);
        String str = stringOptional.orElseThrow(NullPointerException::new);
        System.out.println(str);
    }

}

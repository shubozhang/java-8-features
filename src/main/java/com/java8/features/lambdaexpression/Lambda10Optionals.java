package com.java8.features.lambdaexpression;

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
public class Lambda10Optionals {


    public static void main(String[] args) {
        optional01();

        optional02();

        optional03();
    }

    public static void optional01() {
        Optional<String> stringOptional = Optional.of("test");
        String str;
        if (stringOptional.isPresent()) {
            str = stringOptional.get();
        } else {
            str = "";
        }
        System.out.println(str);
    }


    public static void optional02() {
        Optional<String> stringOptional = Optional.of("test");
        String str = stringOptional.orElse("");
        System.out.println(str);
    }


    public static void optional03() {
        Optional<String> stringOptional = Optional.of("test");
        String str = stringOptional.orElseThrow(NullPointerException::new);
        System.out.println(str);
    }

}

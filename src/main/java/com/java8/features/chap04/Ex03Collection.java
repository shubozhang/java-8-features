package com.java8.features.chap04;


import java.util.*;
import java.util.stream.Collectors;

/*
* stream() / parallelStream()
*
* spliterator()
*
* forEach()
* */
public class Ex03Collection {

    public static void main(String[] args) {

        demo1();

        demo2();

        demo3();
    }



    // Not for arrays
    private static void demo1() {
        List<String> strings = Arrays.asList("One","Two","Three");
        strings.forEach(System.out::println);

        Collection<String> list = new ArrayList<>(strings);
        boolean b = list.removeIf(s -> s.length() > 4);
        System.out.println(b);
        System.out.println(list.stream().collect(Collectors.joining(",")));

    }

    private static void demo2() {
        List<String> strings = Arrays.asList("One","Two","Three","Four");
        List<String> list = new ArrayList<>(strings);

        // does not return anything
        list.replaceAll(String::toUpperCase);
        System.out.println(list.stream().collect(Collectors.joining(",")));
    }

    private static void demo3() {
        List<String> strings = Arrays.asList("One","Two","Three","Four");
        List<String> list = new ArrayList<>(strings);

        // does not return anything
        list.sort(Comparator.naturalOrder());
        System.out.println(list.stream().collect(Collectors.joining(",")));
    }
}

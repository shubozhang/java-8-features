package com.java8.ch01.lambda;

import com.java8.ch01.lambda.model.Box;
import com.java8.ch01.lambda.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

// Represents a predicate (boolean-valued function) of one argument.
// boolean test(T t);
public class Lambda06Predicate {

    public static void main(String[] args) {
        example01();

        example02();

        example03();
    }

    // 1. how to use Predicate.
    private static void example01() {
        Predicate<String> i  = (s)-> s.length() > 5;

        System.out.println("example01:" + i.test("java2s.com "));
    }

    // 2. how to create Predicate from method reference and lambda.
    private static void example02() {
        List<Box> inventory = Arrays.asList(new Box(80, "green"),
                new Box(155, "green"), new Box(120, "red"));

        // These two ways are same
        List<Box> greenApples = filter(inventory,Lambda06Predicate::isGreenApple);
        System.out.println("Green apples: " + greenApples);

        List<Box> greenApples2 = filter(inventory,(Box a) -> "green".equals(a.getColor()));
        System.out.println(greenApples2);

        // These two ways are same
        List<Box> heavyApples = filter(inventory,Lambda06Predicate::isHeavyApple);
        System.out.println("Heavy apples: " + heavyApples);

        List<Box> heavyApples2 = filter(inventory,(Box a) -> a.getWeight() > 150);
        System.out.println(heavyApples2);

        // Multi-predicate
        List<Box> weirdApples = filter(inventory,(Box a) -> a.getWeight() < 80 || "brown".equals(a.getColor()));
        System.out.println(weirdApples);
    }
    private static boolean isGreenApple(Box apple) {
        return "green".equals(apple.getColor());
    }

    private static boolean isHeavyApple(Box apple) {
        return apple.getWeight() > 150;
    }

    private static List<Box> filter(List<Box> inventory,Predicate<Box> p) {
        List<Box> result = new ArrayList<>();
        for (Box apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    // 3. how to return Predicate.
    private static void example03() {
        List<Student> employees = Arrays.asList(
                new Student(1, 3, "John"),
                new Student(2, 3, "Jane"),
                new Student(3, 4, "Jack")
        );

        // with predicate
        // "_" can be used in numeric literals
        // "_" must be placed in between numbers  or prefix and number
        System.out.println(findStudents(employees, createCustomPredicateWith(3.5_0)));

        // with function definition, both are same
        Function<Double, Predicate<Student>> customFunction = threshold -> (e -> e.gpa > threshold);
        System.out.println(findStudents(employees, customFunction.apply(2.9_0D)));
    }

    private static Predicate<Student> createCustomPredicateWith(double threshold) {
        return e -> e.gpa > threshold;
    }

    private static List<Student> findStudents(List<Student> employees, Predicate<Student> condition) {
        List<Student> result = new ArrayList<>();

        for (Student e : employees) {
            if (condition.test(e)) {
                result.add(e);
            }
        }

        return result;
    }
}

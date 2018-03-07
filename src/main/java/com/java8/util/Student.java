package com.java8.util;

/**
 * Created by Shubo on 8/19/2017.
 */
public class Student {
    public String name;
    public double gpa;
    public int id;

    public Student(String name, double g) {
        this.name = name;
        this.gpa = g;
    }

    public Student(int id,double g, String name) {
        this.name = name;
        this.gpa = g;
        this.id = id;
    }

    @Override
    public String toString() {
        return name + ": " + gpa + " : " + id;
    }
}

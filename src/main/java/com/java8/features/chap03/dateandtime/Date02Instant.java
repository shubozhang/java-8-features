package com.java8.features.chap03.dateandtime;

import java.time.Duration;
import java.time.Instant;

/*
* 1. Instant is a point on the time line. Precision is the nanosecond.
*
* 2. Instant is immutable.
* */
public class Date02Instant {

    public static void main(String[] args) {

        demo1();
    }

    private static void demo1() {
        System.out.println(Instant.EPOCH);

        System.out.println(Instant.MIN);

        System.out.println(Instant.MAX);

        System.out.println(Instant.now());

    }

}

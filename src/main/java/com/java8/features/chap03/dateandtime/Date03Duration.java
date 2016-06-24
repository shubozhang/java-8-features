package com.java8.features.chap03.dateandtime;

import java.time.Duration;
import java.time.Instant;

/**
 * Duration is the amount of time between two Instant
 *
 * Methods: toNanos(), toMillis(), toSeconds(), toMinutes(), toHours, toDays(), minusNanos(), plusNanos(),
 *          multipliedBy(), dividedBy(), negated(), isZero(), isNegative();
 */
public class Date03Duration {

    public static void main(String[] args) {
        demo1();
    }

    private static void demo1() {
        Instant start = Instant.now();

        int counter = 0;
        for (int i = 0; i < 1000000; i++) {
            counter =+ i;
        }


        Instant end = Instant.now();

        Duration duration = Duration.between(start,end);

        System.out.println("Time elapsed: " + duration.toMillis() + " ms");
    }
}

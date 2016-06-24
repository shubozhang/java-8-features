package com.java8.features.chap03.dateandtime;

import java.time.LocalTime;

/**
 * A LocalTime is a time of day, ex: 10:20
 *
 */
public class Date07LocalTime {

    public static void main(String[] args) {
        LocalTime now = LocalTime.now();

        System.out.println(now);

        LocalTime time = LocalTime.of(10, 20);

        System.out.println(time);

        // Manipulate LocalTime
        LocalTime bedTime = LocalTime.of(23,0);
        LocalTime wakeUpTime = bedTime.plusHours(9);

        System.out.println(wakeUpTime);
    }
}

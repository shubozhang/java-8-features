package com.java8.features.chap03.dateandtime;

import java.time.Duration;
import java.time.Instant;

public class Date02Instant {

    public static void main(String[] args) {

        Instant start = Instant.now();

        Instant end = Instant.now();

        Duration duration = Duration.between(start,end);

        System.out.println(duration.toMillis());
    }
}

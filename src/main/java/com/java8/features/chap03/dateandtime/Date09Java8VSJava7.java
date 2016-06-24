package com.java8.features.chap03.dateandtime;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 * Created by shubo.zhang on 6/24/2016.
 */
public class Date09Java8VSJava7 {

    public static void main(String[] args) {
        demo1();

        demo2();
    }



    // Instant vs Date
    private static void demo1() {
        Instant instant = Instant.ofEpochSecond(1200);

        Date date = Date.from(instant); // API -> legacy
        Instant instant1 = date.toInstant(); // legacy -> new API
    }

    // Instant vs TimeStamp
    private static void demo2() {
        Instant instant = Instant.ofEpochSecond(1200);

        Timestamp timestamp = Timestamp.from(instant); // API -> legacy
        Instant instant1 = timestamp.toInstant(); // legacy -> new API
    }

    private static void demo3() {
        LocalDate localDate = LocalDate.now();
        Date date = Date.from(Instant.from(localDate));

        LocalDate localDate1 = LocalDate.from(date.toInstant());
    }

    private static void demo4() {
        LocalTime localTime = LocalTime.now();

        Time time = (Time) Time.from(Instant.from(localTime));
        LocalTime localTime1 = time.toLocalTime();
    }

}

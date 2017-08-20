package com.java8.features.chap03.dateandtime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * 1. seful to add (or subtract) an amount of time to an Instant of a LocalDate
 *
 * 2. Methods: firstDayOfMonth(), lastDayOfMonth()
 *          firstDayOfYear(), lastDayOfYear()
 *          firstDayOfNextMonth(), firstDayOfNextYear()
 */
public class Date06DateAdjuster {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();

        LocalDate nextSunday = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));

        System.out.println(nextSunday);
    }
}

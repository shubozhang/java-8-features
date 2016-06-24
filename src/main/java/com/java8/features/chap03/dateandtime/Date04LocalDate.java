package com.java8.features.chap03.dateandtime;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * LocalDate is in date precision and immutable
 *
 * Period is the amount of time between LocalDate
 */
public class Date04LocalDate {



    public static void main(String[] args) {
        LocalDate now = LocalDate.now();

        LocalDate dateOfBirth = LocalDate.of(1954, Month.APRIL, 23);

        Period period = dateOfBirth.until(now);

        System.out.println("Number of years = " + period.getYears());

        long days = dateOfBirth.until(now, ChronoUnit.DAYS);
        System.out.println("Number of days " + days);
    }
}



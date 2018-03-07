package com.java8.ch03.dateandtime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Set;

/**
 * Created by shubo.zhang on 6/24/2016.
 */
public class Date08ZoneTime {

    public static void main(String[] args) {

        demo1();

        demo2();

    }



    private static void demo1() {
        Set<String> allZoneIds = ZoneId.getAvailableZoneIds();

        for (String zoneId : allZoneIds) {
            System.out.println(zoneId);
        }

        ZoneId ukTZ = ZoneId.of("Europe/London");
        System.out.println(ukTZ);


        // year/month/day/h/mn/s/nanos
        System.out.println(ZonedDateTime.of(1564, Month.APRIL.getValue(),23,
                                            10,0,0,0,ZoneId.of("Europe/London")));
    }

    private static void demo2() {

        ZonedDateTime currentMeeting = ZonedDateTime.of(
                LocalDate.of(2014,Month.APRIL,12),
                LocalTime.of(9,30),
                ZoneId.of("Europe/London")
        );

        System.out.println("Current meeting: " + currentMeeting);
        ZonedDateTime nextMeeting = currentMeeting.plus(Period.ofMonths(1));

        System.out.println("Next metting: " + nextMeeting);

        ZonedDateTime nextMeetingUS = nextMeeting.withZoneSameInstant(ZoneId.of("US/Central"));
        System.out.println("Next meeting in US " + nextMeetingUS);

        System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(nextMeetingUS));

        System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.format(nextMeetingUS));
    }
}

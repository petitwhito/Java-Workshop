package fr.epita.assistants.travel;

import  com.opencsv.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Travel {
    public static void travelTo(Country source, Country destination) {
        ZoneId zoneId_source = source.countryZone;
        ZoneId zoneId_dest = destination.countryZone;

        LocalDateTime localNow = LocalDateTime.now(zoneId_source);
        ZonedDateTime z = ZonedDateTime.of(localNow, zoneId_source);
        String a = DateTimeFormatter.RFC_1123_DATE_TIME.format(z);
        System.out.println("Boarding in " + source.countryName + ", local date and time is: " + a);

        LocalDateTime localNow_dest = LocalDateTime.now(zoneId_dest);
        int time = source.travelTimes.get(destination.countryName);
        localNow_dest = localNow_dest.minus(time, ChronoUnit.HOURS);
        ZonedDateTime d = ZonedDateTime.of(localNow_dest, zoneId_dest);
        String s = DateTimeFormatter.RFC_1123_DATE_TIME.format(d);
        System.out.println("Landing in " + destination.countryName + ", local date and time on arrival will be: " + s);

    }
}

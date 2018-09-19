package com.solidground.infra.commons.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * @author fdanismaz
 * date: 9/18/18 12:16 PM
 */
public class DateTimeConverter {

    public static LocalDateTime toLocalDateTime(long epochTime, ZoneId zoneId) {
        return Instant.ofEpochMilli(epochTime).atZone(zoneId).toLocalDateTime();
    }

    public static LocalDateTime toLocalDateTime(Instant instant, TimeZone timeZone) {
        if (instant == null || timeZone == null){
            return null;
        }
        return LocalDateTime.ofInstant(instant, timeZone.toZoneId());
    }

    public static String toLocalDateTimeString(long epochTime, ZoneId zoneId, String pattern) {
        DateTimeFormatter formatlayici = DateTimeFormatter.ofPattern(pattern);
        return toLocalDateTimeString(epochTime, zoneId, formatlayici);
    }

    public static String toLocalDateTimeString(long epochTime, ZoneId zoneId, DateTimeFormatter formatlayici) {
        LocalDateTime localDateTime = toLocalDateTime(epochTime, zoneId);
        return localDateTime.format(formatlayici);
    }

    public static LocalDate toLocalDate(Instant instant, TimeZone timeZone) {
        if (instant == null || timeZone == null){
            return null;
        }
        return LocalDateTime.ofInstant(instant, timeZone.toZoneId()).toLocalDate();
    }

    public static long toEpoch(LocalDateTime dateTime, ZoneId zoneId) {
        Instant instant = dateTime.atZone(zoneId).toInstant();
        return TimeUnit.SECONDS.toMillis(instant.getEpochSecond());
    }

    public static long toEpoch(LocalDate date, ZoneId zoneId) {
        Instant instant = date.atStartOfDay().atZone(zoneId).toInstant();
        return TimeUnit.SECONDS.toMillis(instant.getEpochSecond());
    }

    public static long toEpoch(Instant instant) {
        return TimeUnit.SECONDS.toMillis(instant.getEpochSecond());
    }

    public static Instant toInstant(LocalDate date, TimeZone timeZone) {
        if (date == null || timeZone == null){
            return null;
        }
        return date.atStartOfDay(timeZone.toZoneId()).toInstant();
    }

    public static Instant toInstant(LocalDateTime dateTime, TimeZone timeZone) {
        if (dateTime == null || timeZone == null){
            return null;
        }
        return dateTime.toInstant(ZoneOffset.ofHours((int)TimeUnit.MICROSECONDS.toHours(timeZone.getRawOffset())));
    }
}

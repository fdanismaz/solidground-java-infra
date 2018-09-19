package com.solidground.infra.mapping;

import com.solidground.infra.commons.datetime.DateTimeConverter;
import org.mapstruct.Context;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TimeZone;

/**
 * @author fdanismaz
 * date: 9/18/18 12:34 PM
 */
public class DateMapper {

    public Instant toInstant(LocalDateTime localDateTime, @Context TimeZone timeZone) {
        return DateTimeConverter.toInstant(localDateTime, timeZone);
    }

    public LocalDateTime toLocalDateTime(Instant instant, @Context TimeZone timeZone) {
        return DateTimeConverter.toLocalDateTime(instant, timeZone);
    }

    public Instant toInstant(LocalDate localDate, @Context TimeZone timeZone) {
        return DateTimeConverter.toInstant(localDate, timeZone);
    }

    public LocalDate toLocalDate(Instant instant, @Context TimeZone timeZone) {
        return DateTimeConverter.toLocalDate(instant, timeZone);
    }

    public LocalDateTime toLocalDateTime(long epoch, @Context TimeZone timeZone) {
        return DateTimeConverter.toLocalDateTime(epoch, timeZone.toZoneId());
    }

    public long toEpoch(LocalDateTime localDateTime, @Context TimeZone timeZone) {
        return DateTimeConverter.toEpoch(localDateTime, timeZone.toZoneId());
    }
}

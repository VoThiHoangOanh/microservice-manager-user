package com.microservice.sharedmodel.core.converter;

import org.apache.commons.lang3.time.DateUtils;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

public class ZonedDateTimeConverter {

    public static ZonedDateTime parseDate(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
        String[] patternList = {"dd-MM-yyyy", "dd/MM/yyyy", "dd.MM.yyyy", "yyyy-MM-dd"};
        try {
            Date date = DateUtils.parseDateStrictly(source, patternList);
            return ZonedDateTime.ofInstant(date.toInstant(), ZoneOffset.UTC);
        } catch (java.text.ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static ZonedDateTime parseDateTime(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
        String[] patternList = {"dd-MM-yyyy HH:mm:ss", "dd/MM/yyyy HH:mm:ss", "dd.MM.yyyy HH:mm:ss", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"};
        try {
            Date date = DateUtils.parseDateStrictly(source, patternList);
            return ZonedDateTime.ofInstant(date.toInstant(), ZoneOffset.UTC);
        } catch (java.text.ParseException e) {
            throw new RuntimeException(e);
        }
    }

}

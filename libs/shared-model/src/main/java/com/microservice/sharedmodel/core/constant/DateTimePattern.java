package com.microservice.sharedmodel.core.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DateTimePattern {

    public static final String DD_MM = "dd/MM";
    public static final String MM_YYYY = "MM/yyyy";
    public static final String DD_MM_YYYY = "dd-MM-yyyy";
    public static final String HH_MM = "HH:mm";
    public static final String HH_MM_2 = "HH'h'mm";
    public static final String DISPLAY_DATE = "dd/MM/yyyy";
    public static final String DISPLAY_DATE_WITH_HOURS = "dd/MM/yyyy HH:mm";
    public static final String DISPLAY_DATE_TIME = "HH:mm:ss dd/MM/yyyy";
    public static final String AUTH0_DATE = "MM/dd/yyyy";
    public static final String OVERDUE_DATE = "HH:mm dd/MM/yyyy";
    public static final String US_YEAR = "yy";
    public static final String ISO_DATE_TIME = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public static final String ISO_DATE_TIME_WITHOUT_MILLISECONDS = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final String ISO_8601 = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
    public static final String ISO_8601_WITHOUT_MILLISECONDS = "yyyy-MM-dd'T'HH:mm:ssXXX";
    public static final String DB_DATE_TIME = "yyyy-MM-dd HH:mm:ss.SSSSSS";
    public static final String RFC1123_DATE_TIME = "EEE, dd MMM yyyy HH:mm:ss z";
    public static final String ISO_DATE = "yyyy-MM-dd";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String DD_MMM_YYYY = "dd MMM yyyy";
    public static final String MMM_YYYY = "MMM yyyy";
}

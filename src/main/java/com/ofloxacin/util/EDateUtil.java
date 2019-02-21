package com.ofloxacin.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * Created by ChenShuai on 2017/4/13.
 */
public class EDateUtil {

    public static final String yyyyMMdd = "yyyyMMdd";
    public static final String yyyy_MM_dd = "yyyy-MM-dd";

    public static void main(String[] args) {
        if (null == null) {
            println(true);
        }
    }

    public static String format(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date get000000Date(Date date) {
        Calendar calendar = calendar(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date get235959Date(Date date) {
        Calendar calendar = calendar(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getDate(Date date, int filed, int value) {
        Calendar calendar = calendar(date);
        calendar.add(filed, value);
        return calendar.getTime();
    }

    public static Calendar calendar() {
        return Calendar.getInstance();
    }

    public static Calendar calendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static void println(Object object) {
        System.out.println(object);
    }

    public static Date getCurrent() {
        return calendar().getTime();
    }

    public static Date getNext000000Date(Date date) {
        return get000000Date(getDate(date, Calendar.DATE, 1));
    }

    public static Date getPre000000Date(Date date) {
        return get000000Date(getDate(date, Calendar.DATE, -1));
    }

    public static Date getPre235959Date(Date date) {
        return EDateUtil.get235959Date(EDateUtil.getDate(date, Calendar.DATE, -1));
    }

    public static Date getYesterday() {
        return get000000Date(getCurrent());
    }
}

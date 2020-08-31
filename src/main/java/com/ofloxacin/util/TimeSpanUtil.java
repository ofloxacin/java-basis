package com.ofloxacin.util;

/**
 * @author ChenShuai
 * @date 2018/7/12 17:50
 */
public class TimeSpanUtil {

    private static long dateStart;

    private static long number;

    private static long totalSpan;

    public static void init() {
        dateStart = System.currentTimeMillis();
        totalSpan = 0;
        number = 0;
    }

    public static long getSpan() {
        number++;
        long now = System.currentTimeMillis();

        long span = 0;
        if (dateStart != 0) {
            span = now - dateStart;
        }

        totalSpan += span;
        dateStart = now;
        return span;
    }

    public static void printSpan() {
        float span = getSpan() / 1000F;

        String msg = "Elapsed time(" +
                String.format("%3d", number).replace(" ", "0") +
                "): " +
                span +
                "s  total: " + totalSpan / 1000F + "s ";
        System.out.println(msg);
    }

    public static void printSpan(String message) {
        float span = getSpan() / 1000F;

        String msg = "Elapsed time(" +
                String.format("%3d", number).replace(" ", "0") +
                "): " +
                span +
                "s  total: " + totalSpan / 1000F + "s " + message;
        System.out.println(msg);
    }
}

package com.ofloxacin.util;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-06-30
 */
public class ProgressUtil {

    /**
     * 进度条默认长度，50字符
     */
    public static final int DEFAULT_TOTAL_LENGTH = 50;

    /**
     * 进度条打印间隔，1%
     */
    public static final int DEFAULT_STEP = 1;

    /**
     * 打印进度条
     *
     * @param percent 当前进度
     */
    public static void printProcess(int percent) {
        printProcess(DEFAULT_TOTAL_LENGTH, DEFAULT_STEP, percent);
    }

    /**
     * 打印进度条
     *
     * @param totalLength 进度条长度
     * @param percent     当前进度
     */
    public static void printProcess(int totalLength, int percent) {
        printProcess(totalLength, DEFAULT_STEP, percent);
    }

    /**
     * 打印进度条
     *
     * @param totalLength 进度条长度
     * @param step        打印间隔
     * @param percent     当前进度
     */
    public static void printProcess(int totalLength, int step, int percent) {
        if (percent % step != 0) {
            return;
        }
        for (int i = 0; i < totalLength + 5; i++) {
            System.out.print("\b");
        }
        int now = totalLength * percent / 100;
        for (int i = 0; i < now; i++) {
            System.out.print(".");
        }
        for (int i = 0; i < totalLength - now; i++) {
            System.out.print(" ");
        }
        System.out.print(" " + percent + "%");
    }
}

package com.ofloxacin.leetcode;

/**
 * @author chenshuai
 * @version 0.1
 * @name P0007_ReverseInteger
 * @description
 * @date 2019/11/5
 */
public class P0007_ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse1(123));
        System.out.println(reverse1(-12345));
        System.out.println(reverse1(-123456));
        System.out.println(reverse1(Integer.MAX_VALUE));
        System.out.println(reverse1(Integer.MIN_VALUE));
    }

    public static int reverse1(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        return 0;
    }

    public static int reverse2(int x) {
        char[] chars = (x + "").toCharArray();
        int i = 0;
        int j = chars.length - 1;
        if (chars[0] == '-') {
            i = 1;
        }
        for (; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        try {
            return Integer.parseInt(new String(chars));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}

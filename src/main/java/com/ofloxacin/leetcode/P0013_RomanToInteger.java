package com.ofloxacin.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenshuai
 * @version 0.1
 * @name RomanToInteger
 * @description
 * @date 2019/11/6
 */
public class P0013_RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt4("III"));
        System.out.println(romanToInt4("IV"));
        System.out.println(romanToInt4("IX"));
        System.out.println(romanToInt4("LVIII"));
        System.out.println(romanToInt4("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("M", 1000);
        int result = 0;
        char[] chars = (s + " ").toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            Integer num = map.get(chars[i] + "" + chars[i + 1]);
            if (num != null) {
                result += num;
                i++;
                continue;
            }
            result += map.get(chars[i] + "");
        }
        return result;
    }

    public static int romanToInt3(String s) {
        char[] chars = s.toCharArray();
        int[] temp = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'I':
                    temp[i] = 1;
                    break;
                case 'V':
                    temp[i] = 5;
                    break;
                case 'X':
                    temp[i] = 10;
                    break;
                case 'L':
                    temp[i] = 50;
                    break;
                case 'C':
                    temp[i] = 100;
                    break;
                case 'D':
                    temp[i] = 500;
                    break;
                case 'M':
                    temp[i] = 1000;
                    break;
            }
        }
        int total = 0;
        for (int i = 0; i < temp.length - 1; i++) {
            if (temp[i] < temp[i + 1]) {
                total -= temp[i];
            } else {
                total += temp[i];
            }
        }
        total += temp[temp.length - 1];
        return total;
    }

    public static int romanToInt2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char left = s.charAt(i);
            char right = i + 1 == s.length() ? '#' : s.charAt(i + 1);
            if ((left == 'I' && ('V' == right || 'X' == right)) ||
                    (left == 'X' && ('L' == right || 'C' == right)) ||
                    (left == 'C' && ('D' == right || 'M' == right))) {
                result -= map.get(left);
            } else {
                result += map.get(left);
            }
        }
        return result;
    }

    public static int romanToInt4(String s) {
        char[] array = s.toCharArray();
        int result = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            switch (array[i]) {
                case 'I':
                    if (i + 1 != array.length && (array[i + 1] == 'V' || array[i + 1] == 'X')) {
                        result -= 1;
                    } else {
                        result += 1;
                    }
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    if (i + 1 != array.length && (array[i + 1] == 'L' || array[i + 1] == 'C')) {
                        result -= 10;
                    } else {
                        result += 10;
                    }
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    if (i + 1 != array.length && (array[i + 1] == 'D' || array[i + 1] == 'M')) {
                        result -= 100;
                    } else {
                        result += 100;
                    }
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
            }
        }
        return result;
    }
}

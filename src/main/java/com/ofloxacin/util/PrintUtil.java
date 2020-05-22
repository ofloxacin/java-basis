package com.ofloxacin.util;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author chens
 * @date 2018/11/9 11:53
 */
public class PrintUtil {

    public static void println(Object o) {
        String s = o == null ? "null" : o.toString();
        System.out.println(s);
    }

    public static void print(int[] nums) {
        System.out.print(Arrays.stream(nums).mapToObj(Integer::toString).collect(Collectors.joining(",", "[", "]")));
    }

    public static void println(int[] nums) {
        print(nums);
        System.out.println();
    }

    public static void println(int[][] nums) {
        for (int[] num : nums) {
            print(num);
        }
        System.out.println();
    }

    public static void printString(String s) {
        System.out.println(s);
    }

    public static void printJson(Object o) {
        System.out.println(JSON.toJSONString(o, true));
    }
}

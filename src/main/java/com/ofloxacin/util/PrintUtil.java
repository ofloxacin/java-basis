package com.ofloxacin.util;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author chens
 * @date 2018/11/9 11:53
 */
public class PrintUtil {

    public static void print(Object o) {
        String s = o == null ? "null" : o.toString();
        System.out.println(s);
    }

    public static void print(int[] nums) {
        System.out.println(Arrays.stream(nums).mapToObj(Integer::toString).collect(Collectors.joining(",", "[", "]")));
    }

    public static void print(int[][] nums) {
        for (int[] num : nums) {
            print(num);
        }
    }

    public static void printString(String s) {
        System.out.println(s);
    }

    public static void printJson(Object o) {
        System.out.println(JSON.toJSONString(o, true));
    }
}

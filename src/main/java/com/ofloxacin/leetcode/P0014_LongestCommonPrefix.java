package com.ofloxacin.leetcode;

/**
 * @author chenshuai
 * @version 0.1
 * @name P0014_LongestCommonPrefix
 * @description
 * @date 2019/11/9
 */
public class P0014_LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        String[] strs2 = new String[]{"x", "y", "z"};
        String[] strs3 = new String[]{"x"};
        String[] strs4 = new String[]{"x", "x"};
        String[] strs5 = new String[]{"xx"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix(strs2));
        System.out.println(longestCommonPrefix(strs3));
        System.out.println(longestCommonPrefix(strs4));
        System.out.println(longestCommonPrefix(strs5));
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        char[][] arrays = new char[strs.length][];
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = strs[i].toCharArray();
        }
        int j = 0;
        for (; j < arrays[0].length; j++) {
            for (int i = 1; i < arrays.length; i++) {
                if (arrays[i].length == j || arrays[i][j] != arrays[0][j]) {
                    return new String(arrays[0], 0, j);
                }
            }
        }
        return new String(arrays[0], 0, j);
    }
}

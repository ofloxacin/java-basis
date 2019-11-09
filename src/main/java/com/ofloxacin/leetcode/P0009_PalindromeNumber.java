package com.ofloxacin.leetcode;

/**
 * @author chenshuai
 * @version 0.1
 * @name P009_PalindromeNumber
 * @description
 * @date 2019/11/9
 */
public class P0009_PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int[] nums = new int[10];
        int i = 0;
        while (x > 0) {
            nums[i++] = x % 10;
            x = x / 10;
        }
        for (int j = 0; j < i / 2; j++) {
            if (nums[j] != nums[i - 1 - j]) {
                return false;
            }
        }
        return true;
    }
}

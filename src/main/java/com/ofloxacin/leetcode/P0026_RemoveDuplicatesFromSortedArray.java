package com.ofloxacin.leetcode;

/**
 * @author chenshuai
 * @version 0.1
 * @name P0026_RemoveDuplicatesFromSortedArray
 * @description
 * @date 2019/11/11
 */
public class P0026_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 1, 1, 2, 3, 3, 3, 5}));
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3}));
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[i]) {
                continue;
            }
            nums[++i] = nums[j];
        }
        return i + 1;
    }
}

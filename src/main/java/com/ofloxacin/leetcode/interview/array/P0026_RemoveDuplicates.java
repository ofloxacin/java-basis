package com.ofloxacin.leetcode.interview.array;

import org.junit.Test;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-11
 */
public class P0026_RemoveDuplicates {

    @Test
    public void test() {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int i = 0, j = 0;
        while (++j < nums.length) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}

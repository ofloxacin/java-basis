package com.ofloxacin.leetcode.interview.array;

import org.junit.Test;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-11
 */
public class P003_Rotate {

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = new int[]{-1, -100, 3, 99};
        rotate(nums, 3);
        rotate(nums2, 2);
        for (int num : nums) {
            System.out.println(num);
        }
        System.out.println();
        for (int num : nums2) {
            System.out.println(num);
        }
        System.out.println();
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            nums[i] = nums[(i + k) % nums.length];
            nums[(i + k) % nums.length] = n;
        }
    }
}

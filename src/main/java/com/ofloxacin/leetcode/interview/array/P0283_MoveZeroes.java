package com.ofloxacin.leetcode.interview.array;

import com.ofloxacin.util.PrintUtil;
import org.junit.jupiter.api.Test;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-13
 */
public class P0283_MoveZeroes {

    @Test
    public void test() {
        int[] nums1 = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums1);
        PrintUtil.print(nums1);
    }

    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        for (int i = nums.length - count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

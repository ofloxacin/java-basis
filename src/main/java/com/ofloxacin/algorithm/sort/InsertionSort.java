package com.ofloxacin.algorithm.sort;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-29
 */
public class InsertionSort implements Sort {

    @Override
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int pre = i - 1;
            while (pre >= 0 && nums[pre] > temp) {
                nums[pre + 1] = nums[pre];
                pre--;
            }
            nums[pre + 1] = temp;
        }
    }
}

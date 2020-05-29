package com.ofloxacin.algorithm.sort;

import java.util.Comparator;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-29
 */
public class InsertionSort implements Sort {

    @Override
    public void sort(int[] nums, Comparator<Integer> comparator) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if (comparator.compare(nums[j], temp) > 0) {
                    nums[j + 1] = nums[j];
                } else {
                    nums[j + 1] = temp;
                }
            }
        }
    }
}

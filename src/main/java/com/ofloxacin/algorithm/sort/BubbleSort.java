package com.ofloxacin.algorithm.sort;

import java.util.Comparator;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-29
 */
public class BubbleSort implements Sort {

    @Override
    public void sort(int[] nums, Comparator<Integer> comparator) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (comparator.compare(nums[j], nums[j + 1]) > 0) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }
}

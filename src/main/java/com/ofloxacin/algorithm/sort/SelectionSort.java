package com.ofloxacin.algorithm.sort;

import java.util.Comparator;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-29
 */
public class SelectionSort implements Sort {

    @Override
    public void sort(int[] nums, Comparator<Integer> comparator) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (comparator.compare(nums[j], nums[min]) < 0) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }
}

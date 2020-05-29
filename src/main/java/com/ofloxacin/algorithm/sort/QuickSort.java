package com.ofloxacin.algorithm.sort;

import java.util.Comparator;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-29
 */
public class QuickSort implements Sort {

    @Override
    public void sort(int[] nums, Comparator<Integer> comparator) {
        sort(nums, 0, nums.length - 1, comparator);
    }

    private void sort(int[] nums, int left, int right, Comparator<Integer> comparator) {
        if (left > right) {
            return;
        }
        int i = left, j = right;
        while (i < j) {
            while (i < j && comparator.compare(nums[j], nums[left]) >= 0) {
                j--;
            }
            while (i < j && comparator.compare(nums[i], nums[left]) <= 0) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, left, j);
        sort(nums, left, j - 1, comparator);
        sort(nums, j + 1, right, comparator);
    }
}

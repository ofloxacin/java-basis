package com.ofloxacin.algorithm.sort;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-29
 */
public class QuickSort implements Sort {

    @Override
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int left, int right) {
        if (left > right) return;
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] > nums[left]) j--;
            while (i < j && nums[i] > nums[left]) i++;
            if (i < j) swap(nums, i, j);
        }
        swap(nums, left, j);
        sort(nums, left, j - 1);
        sort(nums, j + 1, right);
    }
}

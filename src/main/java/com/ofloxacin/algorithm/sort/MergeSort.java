package com.ofloxacin.algorithm.sort;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-29
 */
public class MergeSort implements Sort {

    @Override
    public void sort(int[] nums) {
        mergeSort(nums, 0, nums.length);
    }

    private void mergeSort(int[] nums, int start, int end) {
        if ((end - start) < 2) return;
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] result = new int[end - start];
        int i = start, j = mid, k = 0;
        while (i < mid && j < end) {
            if (nums[i] <= nums[j]) {
                result[k++] = nums[i++];
            } else {
                result[k++] = nums[j++];
            }
        }
        while (i < mid) result[k++] = nums[i++];
        while (j < end) result[k++] = nums[j++];
        for (int num : result) nums[start++] = num;
    }
}

package com.ofloxacin.algorithm.sort;

import com.ofloxacin.util.PrintUtil;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-29
 */
public class MergeSort implements Sort {

    @Override
    public void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] result = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                result[k++] = nums[i++];
            } else {
                result[k++] = nums[j++];
            }
        }
        while (i <= mid) result[k++] = nums[i++];
        while (j <= high) result[k++] = nums[j++];
        System.arraycopy(result, 0, nums, low, result.length);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 3, 2, 1, 0};
        new MergeSort().sort(nums);
        PrintUtil.println(nums);
    }
}

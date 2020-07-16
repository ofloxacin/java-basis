package com.ofloxacin.algorithm.sort;

import com.ofloxacin.util.PrintUtil;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-07-16
 */
public class MergeSort2 implements Sort {

    @Override
    public void sort(int[] nums) {
        mergeSort(nums);
    }

    private void mergeSort(int[] nums) {
        for (int len = 1; len <= nums.length; len *= 2) {
            for (int low = 0; low + len <= nums.length; low += len * 2) {
                merge(nums, low, low + len - 1, Math.min(nums.length - 1, low + len * 2 - 1));
            }
        }
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
        new MergeSort2().sort(nums);
        PrintUtil.println(nums);
    }
}

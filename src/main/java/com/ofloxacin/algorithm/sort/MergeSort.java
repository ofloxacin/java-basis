package com.ofloxacin.algorithm.sort;

import java.util.Comparator;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-29
 */
public class MergeSort implements Sort {

    @Override
    public void sort(int[] nums, Comparator<Integer> comparator) {
        mergeSort(nums, 0, nums.length, comparator);
    }

    private void mergeSort(int[] nums, int start, int end, Comparator<Integer> comparator) {
        if ((end - start) < 2) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid, comparator);
        mergeSort(nums, mid, end, comparator);
        merge(nums, start, mid, end, comparator);
    }

    private void merge(int[] nums, int start, int mid, int end, Comparator<Integer> comparator) {
        int[] result = new int[end - start];
        int i = start, j = mid, k = 0;
        while (i < mid && j < end) {
            if (comparator.compare(nums[i], nums[j]) <= 0) {
                result[k++] = nums[i++];
            } else {
                result[k++] = nums[j++];
            }
        }
        while (i < mid) {
            result[k++] = nums[i++];
        }
        while (j < end) {
            result[k++] = nums[j++];
        }
        for (int num : result) {
            nums[start++] = num;
        }
    }
}

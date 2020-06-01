package com.ofloxacin.algorithm.sort;

import java.util.Comparator;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-29
 */
public class HeapSort implements Sort {

    @Override
    public void sort(int[] nums, Comparator<Integer> comparator) {
        buildHeap(nums, comparator);
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i, comparator);
        }
    }

    private void buildHeap(int[] nums, Comparator<Integer> comparator) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, i, nums.length, comparator);
        }
    }

    private void heapify(int[] nums, int i, int len, Comparator<Integer> comparator) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int target = i;
        if (left < len && comparator.compare(nums[left], nums[target]) > 0) {
            target = left;
        }
        if (right < len && comparator.compare(nums[right], nums[target]) > 0) {
            target = right;
        }

        if (target != i) {
            swap(nums, i, target);
            heapify(nums, target, len, comparator);
        }
    }
}

package com.ofloxacin.algorithm.sort;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-29
 */
public class HeapSort implements Sort {

    @Override
    public void sort(int[] nums) {
        buildHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }
    }

    private void buildHeap(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--)
            heapify(nums, i, nums.length);
    }

    private void heapify(int[] nums, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int target = i;
        if (left < len && nums[left] > nums[target]) target = left;
        if (right < len && nums[right] > nums[target]) target = right;
        if (target != i) {
            swap(nums, i, target);
            heapify(nums, target, len);
        }
    }
}

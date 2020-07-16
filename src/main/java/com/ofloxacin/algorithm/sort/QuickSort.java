package com.ofloxacin.algorithm.sort;

import com.ofloxacin.util.PrintUtil;

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

    private void sort(int[] nums, int low, int high) {
        if (low >= high) return;
        int i = low, j = high, mid = nums[low];
        while (i < j) {
            while (i < j && nums[j] >= mid) j--;
            nums[i] = nums[j];
            while (i < j && nums[i] < mid) i++;
            nums[j] = nums[i];
        }
        nums[i] = mid;
        sort(nums, low, i - 1);
        sort(nums, i + 1, high);
    }

    public static void main(String[] args) {
        int nums[] = new int[]{5, 4, 3, 2, 1};
        new QuickSort().sort(nums);
        PrintUtil.print(nums);
    }
}

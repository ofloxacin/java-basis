package com.ofloxacin.algorithm.sort;

import com.ofloxacin.util.PrintUtil;

import java.util.Stack;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-07-16
 */
public class QuickSort2 implements Sort {

    @Override
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int low, int high) {
        if (low >= high) return;
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);
        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();
            int i = low, j = high, mid = nums[low];
            while (i < j) {
                while (i < j && nums[j] >= mid) j--;
                nums[i] = nums[j];
                while (i < j && nums[i] < mid) i++;
                nums[j] = nums[i];
            }
            nums[i] = mid;
            if (i + 1 < high) {
                stack.push(i + 1);
                stack.push(high);
            }
            if (i - 1 > low) {
                stack.push(low);
                stack.push(i - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 3, 2, 1};
        new QuickSort2().sort(nums);
        PrintUtil.print(nums);
    }
}

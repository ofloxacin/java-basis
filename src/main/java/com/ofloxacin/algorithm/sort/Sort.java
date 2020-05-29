package com.ofloxacin.algorithm.sort;

import java.util.Comparator;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-29
 */
public interface Sort {

    /**
     * 排序 ASC
     *
     * @param nums
     */
    default void sort(int[] nums) {
        sort(nums, Comparator.comparingInt(o -> o));
    }

    /**
     * 交换数组元素
     *
     * @param nums
     * @param i
     * @param j
     */
    default void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 根据规则排序
     *
     * @param nums
     * @param comparator
     */
    void sort(int[] nums, Comparator<Integer> comparator);
}

package com.ofloxacin.algorithm.sort;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-29
 */
public class CountingSort {

    public void sort(int[] nums, int k) {
        int[] bucket = new int[k];
        for (int num : nums) {
            bucket[num]++;
        }
        int pos = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                nums[pos++] = i;
            }
        }
    }
}

package com.ofloxacin.algorithm.sort;

import java.util.Comparator;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-29
 */
public class CountingSort {

    public void sort(int[] nums, int k, Comparator<Integer> comparator) {
        int[] bucket = new int[k];
        for (int num : nums) {
            bucket[num]++;
        }
        int pos = 0;
        if (comparator.compare(1, 0) > 0) {
            for (int i = 0; i < bucket.length; i++) {
                while (bucket[i]-- > 0) {
                    nums[pos++] = i;
                }
            }
        } else {
            for (int i = bucket.length - 1; i >= 0; i--) {
                while (bucket[i]-- > 0) {
                    nums[pos++] = i;
                }
            }
        }
    }
}

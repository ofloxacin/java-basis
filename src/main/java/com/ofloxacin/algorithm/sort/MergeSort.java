package com.ofloxacin.algorithm.sort;

import java.util.Arrays;
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
        int[] result = mergeSort(nums, comparator);
        System.arraycopy(result, 0, nums, 0, result.length);
    }

    private int[] mergeSort(int[] nums, Comparator<Integer> comparator) {
        if (nums.length < 2) {
            return nums;
        }
        int middle = nums.length / 2;
        int[] numsL = Arrays.copyOf(nums, middle);
        int[] numsR = Arrays.copyOfRange(nums, middle, nums.length);
        return merge(mergeSort(numsL, comparator), mergeSort(numsR, comparator), comparator);
    }

    private int[] merge(int[] numL, int[] numR, Comparator<Integer> comparator) {
        int[] result = new int[numL.length + numR.length];
        int i = 0, j = 0, k = 0;
        while (i < numL.length && j < numR.length) {
            if (comparator.compare(numL[i], numR[j]) <= 0) {
                result[k++] = numL[i++];
            } else {
                result[k++] = numR[j++];
            }
        }
        while (i < numL.length) {
            result[k++] = numL[i++];
        }
        while (j < numR.length) {
            result[k++] = numR[j++];
        }
        return result;
    }
}

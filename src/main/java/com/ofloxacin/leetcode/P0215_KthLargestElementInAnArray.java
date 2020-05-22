package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-21
 */
public class P0215_KthLargestElementInAnArray {

    @Test
    public void test() {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1);
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
}

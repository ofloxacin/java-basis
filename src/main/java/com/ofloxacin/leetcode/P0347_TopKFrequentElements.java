package com.ofloxacin.leetcode;

import com.ofloxacin.util.PrintUtil;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-21
 */
public class P0347_TopKFrequentElements {

    @Test
    public void test() {
        PrintUtil.print(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        PrintUtil.print(topKFrequent(new int[]{1}, 1));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap =
                new PriorityQueue<>(k + 1, Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            heap.add(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] result = new int[k];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : heap) {
            result[i++] = entry.getKey();
        }
        return result;
    }
}

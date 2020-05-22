package com.ofloxacin.leetcode.interview.array;

import com.ofloxacin.util.PrintUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-12
 */
public class P0349_Intersect {

    @Test
    public void test() {
        PrintUtil.println(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        PrintUtil.println(intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        int[] output = new int[Math.min(set1.size(), set2.size())];
        int idx = 0;
        Set<Integer> min = set1.size() < set2.size() ? set1 : set2;
        Set<Integer> max = set1.size() < set2.size() ? set2 : set1;
        for (Integer num : min) {
            if (max.contains(num)) {
                output[idx++] = num;
            }
        }
        return Arrays.copyOf(output, idx);
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        int[] less = nums1.length < nums2.length ? nums1 : nums2;
        int[] more = nums1.length < nums2.length ? nums2 : nums1;
        Set<Integer> cache = new HashSet<>();
        for (int num : less) {
            cache.add(num);
        }
        Set<Integer> result = new HashSet<>();
        for (int value : more) {
            if (cache.contains(value)) {
                result.add(value);
                if (result.size() == cache.size()) {
                    break;
                }
            }
        }
        int[] ret = new int[result.size()];
        int index = 0;
        for (Integer num : result) {
            ret[index++] = num;
        }
        return ret;
    }
}

package com.ofloxacin.leetcode.interview.array;

import com.ofloxacin.util.PrintUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-12
 */
public class P0350_IntersectII {

    @Test
    public void test() {
        PrintUtil.print(intersection3(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        PrintUtil.print(intersection3(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersection(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] result = new int[nums1.length];
        int idx = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                result[idx++] = num;
                map.put(num, count - 1);
            }
        }
        return Arrays.copyOf(result, idx);
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums1) {
            Integer val = map1.get(num);
            map1.put(num, val == null ? 1 : val + 1);
        }
        for (int num : nums2) {
            Integer val = map2.get(num);
            map2.put(num, val == null ? 1 : val + 1);
        }
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int idx = 0;
        Map<Integer, Integer> mapMin = map1.size() < map2.size() ? map1 : map2;
        Map<Integer, Integer> mapMax = map1.size() < map2.size() ? map2 : map1;
        for (Map.Entry<Integer, Integer> entry : mapMin.entrySet()) {
            Integer count;
            if ((count = mapMax.get(entry.getKey())) != null) {
                count = Math.min(entry.getValue(), count);
                for (int i = 0; i < count; i++) {
                    result[idx++] = entry.getKey();
                }
            }
        }
        return Arrays.copyOf(result, idx);
    }

    public int[] intersection3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int i = 0, j = 0, idx = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                result[idx++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOf(result, idx);
    }
}

package com.ofloxacin.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenShuai
 * @date 2018/10/25 13:37
 */
public class P0001_TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 0};
        int[] result = twoSum(nums, 9);
        System.out.println(JSON.toJSONString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer j = cache.get(target - nums[i]);
            if (j != null) {
                return new int[]{j, i};
            }
            cache.put(nums[i], i);
        }
        throw new RuntimeException("Could not found");
    }
}

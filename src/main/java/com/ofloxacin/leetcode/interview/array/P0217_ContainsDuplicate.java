package com.ofloxacin.leetcode.interview.array;

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
public class P0217_ContainsDuplicate {

    @Test
    public void test() {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> cache = new HashSet<>();
        for (int n : nums) {
            if (cache.contains(n)) {
                return true;
            }
            cache.add(n);
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}

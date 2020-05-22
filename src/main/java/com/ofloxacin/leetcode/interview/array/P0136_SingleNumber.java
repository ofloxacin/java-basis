package com.ofloxacin.leetcode.interview.array;

import org.junit.jupiter.api.Test;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-12
 */
public class P0136_SingleNumber {

    @Test
    public void test() {
        System.out.println(singleNumber(new int[]{2, 2, 1}));
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}

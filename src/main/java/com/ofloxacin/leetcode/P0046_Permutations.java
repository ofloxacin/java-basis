package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-22
 */
public class P0046_Permutations {

    interface Solution {

        List<List<Integer>> permute(int[] nums);
    }

    @Test
    public void test() {
        Solution solution = new Solution1();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    class Solution1 implements Solution {

        @Override
        public List<List<Integer>> permute(int[] nums) {
            return null;
        }
    }
}

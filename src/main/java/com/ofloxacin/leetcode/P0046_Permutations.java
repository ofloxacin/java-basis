package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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
        Solution solution = new Solution2();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    class Solution1 implements Solution {

        @Override
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new LinkedList<>();
            List<Integer> output = new ArrayList<>(nums.length);
            for (int num : nums) {
                output.add(num);
            }
            backtrace(output, nums.length, 0, result);
            return result;
        }

        private void backtrace(List<Integer> output, int n, int pos, List<List<Integer>> result) {
            if (pos == n) {
                result.add(new ArrayList<>(output));
                return;
            }
            for (int i = pos; i < n; i++) {
                Collections.swap(output, pos, i);
                backtrace(output, n, pos + 1, result);
                Collections.swap(output, pos, i);
            }
        }
    }

    class Solution2 implements Solution {

        @Override
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new LinkedList<>();
            boolean[] used = new boolean[nums.length];
            List<Integer> path = new ArrayList<>(nums.length);
            dfs(nums, used, path, result);
            return result;
        }

        private void dfs(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> result) {
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    path.add(nums[i]);
                    used[i] = true;
                    dfs(nums, used, path, result);
                    used[i] = false;
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}

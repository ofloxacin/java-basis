package com.ofloxacin.leetcode;

import com.ofloxacin.util.PrintUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-22
 */
public class P0056_MergeIntervals {

    interface Solution {

        int[][] merge(int[][] intervals);
    }

    @Test
    public void test() {
        Solution solution = new Solution1();
        PrintUtil.println(solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
        PrintUtil.println(solution.merge(new int[][]{{1, 4}, {4, 5}}));
        PrintUtil.println(solution.merge(new int[][]{{1, 4}, {0, 5}}));
        PrintUtil.println(solution.merge(new int[][]{{1, 4}, {2, 3}}));
        PrintUtil.println(solution.merge(new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}}));
    }

    class Solution1 implements Solution {

        @Override
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            int[][] result = new int[intervals.length][2];
            int j = -1;
            for (int[] interval : intervals) {
                if (j == -1 || interval[0] > result[j][1]) {
                    result[++j] = interval;
                } else {
                    result[j][1] = Math.max(interval[1], result[j][1]);
                }
            }
            return Arrays.copyOf(result, j + 1);
        }
    }
}

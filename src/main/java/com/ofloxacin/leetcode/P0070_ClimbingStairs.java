package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-22
 */
public class P0070_ClimbingStairs {

    @Test
    public void test() {
        Solution solution = new Solution1();
        System.out.println(solution.climbStairs(1));
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(4));
        System.out.println(solution.climbStairs(5));
    }

    interface Solution {

        int climbStairs(int n);
    }

    class Solution1 implements Solution {

        @Override
        public int climbStairs(int n) {
            if (n < 3) {
                return n;
            }
            int l1 = 1, l2 = 2;
            for (int i = 2; i < n; i++) {
                int temp = l1 + l2;
                l1 = l2;
                l2 = temp;
            }
            return l2;
        }
    }

    class Solution2 implements Solution {

        @Override
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

    class Solution3 implements Solution {

        @Override
        public int climbStairs(int n) {
            double sqrt5 = Math.sqrt(5);
            double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
            return (int) (fibn / sqrt5);
        }
    }
}

package com.ofloxacin.leetcode.dp;

import java.util.Arrays;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-07-03
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(getTotalStep(4, 4));
        System.out.println(getTotalStep2(4, 4));
    }

    public static int getTotalStep(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        if (m == 1 || n == 1) return 1;
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int getTotalStep2(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        if (m == 1 || n == 1) return 1;
        int min = Math.min(m, n);
        int max = Math.max(m, n);
        int[] dp = new int[min];
        Arrays.fill(dp, 1);
        for (int i = 1; i < max; i++) {
            for (int j = 1; j < min; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[min - 1];
    }
}

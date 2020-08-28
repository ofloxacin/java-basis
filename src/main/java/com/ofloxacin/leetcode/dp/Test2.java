package com.ofloxacin.leetcode.dp;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-08-27
 */
public class Test2 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] arr2 = new int[][]{{1}};
        System.out.println(getTotalMin(arr));
        System.out.println(getTotalMin(arr2));
    }

    public static int getTotalMin(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return 0;
        }
        int m = arr[0].length;
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0][0];
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + arr[0][j];
        }
        for (int i = 1; i < m; i++) {
            dp[0] += arr[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + arr[i][j];
            }
        }
        return dp[n - 1];
    }
}

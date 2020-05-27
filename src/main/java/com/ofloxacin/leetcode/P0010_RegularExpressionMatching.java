package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-22
 */
public class P0010_RegularExpressionMatching {

    interface Solution {

        boolean isMatch(String s, String p);
    }

    @Test
    public void test() {
        Solution solution = new Solution3();
        System.out.println(solution.isMatch("aa", "a"));
        System.out.println(solution.isMatch("aa", "a*"));
        System.out.println(solution.isMatch("ab", ".*"));
        System.out.println(solution.isMatch("aab", "c*a*b"));
        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));
    }

    /**
     * 回溯
     */
    class Solution1 implements Solution {

        @Override
        public boolean isMatch(String s, String p) {
            if (p.isEmpty()) {
                return s.isEmpty();
            }
            boolean firstMatch = !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
            if (p.length() >= 2 && p.charAt(1) == '*') {
                return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
            } else {
                return firstMatch && isMatch(s.substring(1), p.substring(1));
            }
        }
    }

    /**
     * 备忘录加递归
     */
    class Solution2 implements Solution {

        Boolean[][] memo;

        @Override
        public boolean isMatch(String s, String p) {
            memo = new Boolean[s.length() + 1][p.length() + 1];
            return dp(0, 0, s, p);
        }

        private boolean dp(int i, int j, String s, String p) {
            if (memo[i][j] != null) {
                return memo[i][j];
            }
            boolean ans;
            if (j == p.length()) {
                ans = i == s.length();
            } else {
                boolean firstMatch = i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    ans = dp(i, j + 2, s, p) || (firstMatch && dp(i + 1, j, s, p));
                } else {
                    ans = firstMatch && dp(i + 1, j + 1, s, p);
                }
            }
            memo[i][j] = ans;
            return ans;
        }
    }

    /**
     * 动态规划 自底向上
     */
    class Solution3 implements Solution {

        @Override
        public boolean isMatch(String s, String p) {
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[s.length()][p.length()] = true;
            for (int i = s.length(); i >= 0; i--) {
                for (int j = p.length() - 1; j >= 0; j--) {
                    boolean firstMatch = i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');
                    if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                        dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);
                    } else {
                        dp[i][j] = firstMatch && dp[i + 1][j + 1];
                    }
                }
            }
            return dp[0][0];
        }
    }
}

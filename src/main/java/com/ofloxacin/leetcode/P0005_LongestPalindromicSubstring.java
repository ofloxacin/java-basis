package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-21
 */
public class P0005_LongestPalindromicSubstring {

    @Test
    public void test() {
        Solution solution = new Solution4();
        System.out.println(solution.longestPalindrome(""));
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("bb"));
    }

    interface Solution {

        String longestPalindrome(String s);
    }

    /**
     * 暴力破解
     */

    class Solution1 implements Solution {

        @Override
        public String longestPalindrome(String s) {
            if (s.isEmpty()) {
                return "";
            }
            char[] chars = s.toCharArray();
            int start = 0, end = 0;
            for (int i = 0; i < chars.length; i++) {
                for (int j = i + 1; j < chars.length; j++) {
                    if (isPalindrome(chars, i, j) && end - start < j - i) {
                        start = i;
                        end = j;
                    }
                }
            }
            return s.substring(start, end + 1);
        }

        private boolean isPalindrome(char[] chars, int i, int j) {
            for (; i < j; i++, j--) {
                if (chars[i] != chars[j]) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 扩展中心
     */
    class Solution2 implements Solution {

        @Override
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 2) {
                return s;
            }
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expandCenter(s, i, i);
                int len2 = expandCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        public int expandCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return right - left - 1;
        }
    }

    /**
     * 动态规划
     */
    class Solution3 implements Solution {

        @Override
        public String longestPalindrome(String s) {
            int length = s.length();
            boolean[][] dp = new boolean[length][length];
            String maxPal = "";
            //遍历所有长度
            for (int len = 1; len <= length; len++) {
                for (int i = 0; i < length; i++) {
                    int j = i + len - 1;
                    if (j >= length) {
                        break;
                    }
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                    if (dp[i][j] && len > maxPal.length()) {
                        maxPal = s.substring(i, j + 1);
                    }
                }
            }
            return maxPal;
        }
    }

    /**
     * 动态规划（优化内存占用
     */
    class Solution4 implements Solution {

        @Override
        public String longestPalindrome(String s) {
            int length = s.length();
            boolean[] dp = new boolean[length];
            String maxPal = "";
            for (int i = length - 1; i >= 0; i--) {
                for (int j = length - 1; j >= i; j--) {
                    dp[j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[j - 1]);
                    if (dp[j] && j - i + 1 > maxPal.length()) {
                        maxPal = s.substring(i, j + 1);
                    }
                }
            }
            return maxPal;
        }
    }
}

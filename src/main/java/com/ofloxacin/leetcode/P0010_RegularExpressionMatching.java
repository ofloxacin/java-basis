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
        Solution solution = new Solution1();
        System.out.println(solution.isMatch("aa", "a"));
        System.out.println(solution.isMatch("aa", "a*"));
        System.out.println(solution.isMatch("ab", ".*"));
    }

    class Solution1 implements Solution {

        @Override
        public boolean isMatch(String s, String p) {
            return false;
        }
    }
}

package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-22
 */
public class P0022_GenerateParentheses {

    interface Solution {

        List<String> generateParenthesis(int n);
    }

    @Test
    public void test() {
        Solution solution = new Solution1();
        System.out.println(solution.generateParenthesis(3));
    }

    class Solution1 implements Solution {

        @Override
        public List<String> generateParenthesis(int n) {
            return null;
        }
    }
}

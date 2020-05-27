package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
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
        Solution solution = new Solution2();
        System.out.println(solution.generateParenthesis(3));
    }

    /**
     * 暴力解法
     */
    class Solution1 implements Solution {

        @Override
        public List<String> generateParenthesis(int n) {
            List<String> result = new LinkedList<>();
            generateAll(new char[2 * n], 0, result);
            return result;
        }

        private void generateAll(char[] current, int pos, List<String> result) {
            if (pos == current.length) {
                if (valid(current)) {
                    result.add(new String(current));
                }
            } else {
                current[pos] = '(';
                generateAll(current, pos + 1, result);
                current[pos] = ')';
                generateAll(current, pos + 1, result);
            }
        }

        private boolean valid(char[] current) {
            int balance = 0;
            for (char c : current) {
                if (c == '(') {
                    balance++;
                    continue;
                }
                if (--balance < 0) {
                    return false;
                }
            }
            return balance == 0;
        }
    }

    /**
     * 回溯
     */
    class Solution2 implements Solution {

        @Override
        public List<String> generateParenthesis(int n) {
            List<String> result = new LinkedList<>();
            backtrace(new StringBuilder(), 0, 0, n, result);
            return result;
        }

        private void backtrace(StringBuilder cur, int open, int close, int max, List<String> result) {
            if (cur.length() == max * 2) {
                result.add(cur.toString());
                return;
            }
            if (open < max) {
                cur.append('(');
                backtrace(cur, open + 1, close, max, result);
                cur.deleteCharAt(cur.length() - 1);
            }
            if (close < open) {
                cur.append(')');
                backtrace(cur, open, close + 1, max, result);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
}

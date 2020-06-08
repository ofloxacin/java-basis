package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-06-02
 */
public class P0008_StringToIntegerAtoi {

    @Test
    public void test() {
        Solution solution = new Solution1();
        System.out.println(solution.myAtoi("42"));
        System.out.println(solution.myAtoi("   -42"));
    }

    interface Solution {

        int myAtoi(String str);
    }

    class Solution1 implements Solution {

        @Override
        public int myAtoi(String str) {
            int i = 0;
            if ((i = trimBlank(str)) == -1) {
                return 0;
            }
            boolean negative = isNegative(str, i);
            if (negative) i++;
            for (; i < str.length(); i++) {

            }
            return 0;
        }

        private boolean isNegative(String str, int i) {
            return str.charAt(i) == '-';
        }

        private boolean isNumber(String str, int i) {
            return str.charAt(i) >= '0' && str.charAt(i) <= '9';
        }

        private int trimBlank(String str) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' ') {
                    return i;
                }
            }
            return -1;
        }
    }
}

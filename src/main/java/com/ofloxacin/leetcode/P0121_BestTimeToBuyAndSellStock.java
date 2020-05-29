package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-29
 */
public class P0121_BestTimeToBuyAndSellStock {

    @Test
    public void test() {
        Solution solution = new Solution1();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    interface Solution {

        int maxProfit(int[] prices);
    }

    class Solution1 implements Solution {

        @Override
        public int maxProfit(int[] prices) {
            int min = Integer.MAX_VALUE;
            int result = 0;
            for (int price : prices) {
                if (price < min) {
                    min = price;
                } else if (price - min > result) {
                    result = price - min;
                }
            }
            return result;
        }
    }
}

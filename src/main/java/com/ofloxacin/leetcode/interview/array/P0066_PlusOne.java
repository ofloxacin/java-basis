package com.ofloxacin.leetcode.interview.array;

import com.ofloxacin.util.PrintUtil;
import org.junit.jupiter.api.Test;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-13
 */
public class P0066_PlusOne {

    @Test
    public void test() {
        PrintUtil.println(plusOne(new int[]{1, 2, 3}));
        PrintUtil.println(plusOne(new int[]{4, 3, 2, 1}));
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = ++digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}

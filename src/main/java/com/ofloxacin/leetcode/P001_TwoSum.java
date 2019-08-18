package com.ofloxacin.leetcode;

import com.ofloxacin.util.PrintUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenShuai
 * @date 2018/10/25 13:37
 */
public class P001_TwoSum {

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(numbers, target);
        PrintUtil.printJson(result);
    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int toFind = target - numbers[i];
            if (temp.containsKey(toFind)) {
                return new int[]{temp.get(toFind), i};
            } else {
                temp.put(numbers[i], i);
            }
        }
        throw new RuntimeException("None");
    }
}

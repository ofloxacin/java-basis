package com.ofloxacin.interview.moka;

import com.ofloxacin.util.PrintUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenshuai
 * @date 2020/09/10
 */
public class MokaTest {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 1, 5, 5, 5, 9, 5, 5, 5, 5, 3, 3, 3, 6, 7};
        test(nums);
        PrintUtil.print(nums);
    }

    public static void test(int[] nums) {
        Map<Integer, Integer> cache = new LinkedHashMap<>();
        for (int num : nums) {
            Integer count = cache.get(num);
            if (count == null) {
                count = 0;
            }
            cache.put(num, count + 1);
        }
        cache.forEach((k, v) -> {
            if (v == 1) {
                System.out.println(k);
            }
        });
        List<Map.Entry<Integer, Integer>> temp = new ArrayList(cache.entrySet());
        temp.sort(Comparator.comparingInt(Map.Entry::getValue));
        int index = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : temp) {
            for (int i = 0; i < integerIntegerEntry.getValue(); i++) {
                nums[index++] = integerIntegerEntry.getKey();
            }
        }
    }
}

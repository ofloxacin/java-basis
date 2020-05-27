package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-27
 */
public class P0974_SubarraySumsDivisibleByK {

    @Test
    public void test() {
        Solution solution = new Solution2();
        System.out.println(solution.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
        System.out.println(solution.subarraysDivByK(new int[]{5}, 9));
    }

    class Solution1 implements Solution {

        @Override
        public int subarraysDivByK(int[] A, int K) {
            int count = 0;
            for (int i = 0; i < A.length; i++) {
                int total = 0;
                for (int j = i; j < A.length; j++) {
                    total += A[j];
                    if (total % K == 0) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    class Solution2 implements Solution {

        @Override
        public int subarraysDivByK(int[] A, int K) {
            Map<Integer, Integer> record = new HashMap<>();
            record.put(0, 1);
            int sum = 0, ans = 0;
            for (int elem : A) {
                sum += elem;
                int mod = (sum % K + K) % K;
                int same = record.getOrDefault(mod, 0);
                ans += same;
                record.put(mod, same + 1);
            }
            return ans;
        }
    }

    interface Solution {

        int subarraysDivByK(int[] A, int K);
    }
}

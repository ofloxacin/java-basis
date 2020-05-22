package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-04-21
 */
public class P1248_CountNumberOfNiceSubarrays {

    @Test
    public void test() throws IOException {
        System.out.println(numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
        File file = new File(P1248_CountNumberOfNiceSubarrays.class.getClassLoader().getResource("CountNumberOfNiceSubarrays.txt").getFile());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        IntStream nums = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt);
        System.out.println(numberOfSubarrays(nums.toArray(), Integer.parseInt(bufferedReader.readLine())));
    }

    @Test
    public void test2() throws IOException {
        System.out.println(numberOfSubarrays2(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
        File file = new File(P1248_CountNumberOfNiceSubarrays.class.getClassLoader().getResource("CountNumberOfNiceSubarrays.txt").getFile());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        IntStream nums = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt);
        System.out.println(numberOfSubarrays2(nums.toArray(), Integer.parseInt(bufferedReader.readLine())));
    }

    private int numberOfSubarrays(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i, count = 0; j < nums.length; j++) {
                if (nums[j] % 2 == 0) {
                    if (count == k) {
                        result++;
                    }
                } else if (++count == k) {
                    result++;
                }
            }
        }
        return result;
    }

    private int numberOfSubarrays2(int[] nums, int k) {
        int i = 0, j = 0, temp = 0, count = 0;
        while (j < nums.length) {
            if (nums[j] % 2 != 0 && ++temp == k) {
                j++;
                int m = 0, n = 0;
                while (j < nums.length && nums[j++] % 2 == 0) {
                    m++;
                }
                while (nums[i++] % 2 == 0) {
                    n++;
                }
                count += m + n + m * n + 1;
                temp--;
            } else {
                j++;
            }
        }
        return count;
    }
}

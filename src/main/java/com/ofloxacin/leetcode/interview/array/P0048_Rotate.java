package com.ofloxacin.leetcode.interview.array;

import com.ofloxacin.util.PrintUtil;
import org.junit.Test;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-13
 */
public class P0048_Rotate {

    @Test
    public void test() {
        int[][] matrix1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(matrix1);
        rotate(matrix2);
        PrintUtil.print(matrix1);
        PrintUtil.print(matrix2);
    }

    public void rotate(int[][] matrix) {
        for (int times = 0; times <= matrix.length / 2; times++) {
            int len = matrix.length - times * 2;
            for (int i = 0; i < len - 1; i++) {
                int temp = matrix[times][times + i];
                matrix[times][times + i] = matrix[times + len - 1 - i][times];
                matrix[times + len - 1 - i][times] = matrix[times + len - 1][times + len - 1 - i];
                matrix[times + len - 1][times + len - 1 - i] = matrix[times + i][times + len - 1];
                matrix[times + i][times + len - 1] = temp;
            }
        }
    }
}

package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-06-02
 */
public class P0004_MedianOfTwoSortedArrays {

    @Test
    public void test() {
        Solution solution = new Solution1();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(solution.findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1}, new int[]{2, 3}));
    }

    interface Solution {

        double findMedianSortedArrays(int[] nums1, int[] nums2);
    }

    class Solution1 implements Solution {

        @Override
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len = nums1.length + nums2.length;
            int mid = (len - 1) / 2;
            int mid2 = len / 2;
            if (nums1.length == 0) {
                return (nums2[mid] + nums2[mid2]) / 2.0;
            } else if (nums2.length == 0) {
                return (nums1[mid] + nums1[mid2]) / 2.0;
            }
            int i = 0, j = 0, n1 = Math.min(nums1[0], nums2[0]);
            int k = 1;
            while (k <= mid) {
                if (i >= nums1.length) {
                    n1 = nums2[++j];
                } else if (j >= nums2.length) {
                    n1 = nums1[++i];
                } else if (nums1[i] <= nums2[j]) {
                    n1 = nums1[i++];
                } else {
                    n1 = nums2[j++];
                }
                k++;
            }
            if (len % 2 != 0) {
                return n1;
            } else {
                int n2;
                if (i >= nums1.length) {
                    n2 = nums2[j];
                } else if (j >= nums2.length) {
                    n2 = nums1[i];
                } else n2 = Math.min(nums1[i], nums2[j]);
                return (n1 + n2) / 2.0;
            }
        }
    }
}

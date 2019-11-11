package com.ofloxacin.leetcode;

/**
 * @author chenshuai
 * @version 0.1
 * @name P0027_RemoveElement
 * @description
 * @date 2019/11/11
 */
public class P0027_RemoveElement {

    public static void main(String[] args) {
        System.out.println(removeElement4(new int[]{3}, 3));
        System.out.println(removeElement4(new int[]{3}, 2));
        System.out.println(removeElement4(new int[]{3, 4}, 2));
        System.out.println(removeElement4(new int[]{3, 2, 2, 3}, 3));
        System.out.println(removeElement4(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int i = -1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    public static int removeElement3(int[] nums, int val) {
        int i = 0;
        int j = nums.length;
        for (; i < j; i++) {
            if (nums[i] != val) {
                continue;
            }
            while (j > i && nums[--j] == val) {
            }
            if (j > i) {
                nums[i] = nums[j];
            } else {
                return i;
            }
        }
        return i;
    }

    public static int removeElement4(int[] nums, int val) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            if (nums[i] == val) {
                nums[i] = nums[--j];
            } else {
                i++;
            }
        }
        return j;
    }
}

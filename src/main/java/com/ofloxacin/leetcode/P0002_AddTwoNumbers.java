package com.ofloxacin.leetcode;

/**
 * @author chenshuai
 * @version 0.1
 * @name P002_AddTwoNumbers
 * @description
 * @date 2019/10/31
 */
public class P0002_AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(8);
        ListNode listNode = addTwoNumbers2(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode result = root;
        ListNode p1 = l1, p2 = l2;
        int increase = 0;
        while (p1 != null || p2 != null) {
            int x = 0, y = 0;
            if (p1 != null) {
                x = p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                y = p2.val;
                p2 = p2.next;
            }
            int temp = x + y + increase;
            if (temp < 10) {
                result.next = new ListNode(temp);
                result = result.next;
                increase = 0;
            } else {
                result.next = new ListNode(temp - 10);
                result = result.next;
                increase = 1;
            }
        }
        if (increase > 0) {
            result.next = new ListNode(increase);
        }
        return root.next;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode result = root;
        ListNode p1 = l1, p2 = l2;
        int increase = 0;
        do {
            int temp = p1.val + p2.val + increase;
            if (temp < 10) {
                result.next = new ListNode(temp);
                increase = 0;
            } else {
                result.next = new ListNode(temp - 10);
                increase = 1;
            }
            result = result.next;
        } while ((p1 = p1.next) != null && (p2 = p2.next) != null);
        ListNode remain = p1 == null ? p2.next : p1;
        while (remain != null) {
            int temp = remain.val + increase;
            if (temp < 10) {
                result.next = new ListNode(temp);
                increase = 0;
            } else {
                result.next = new ListNode(temp - 10);
                increase = 1;
            }
            remain = remain.next;
            result = result.next;
        }
        if (increase > 0) {
            result.next = new ListNode(1);
        }
        return root.next;
    }

    public static class ListNode {

        int val;

        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}

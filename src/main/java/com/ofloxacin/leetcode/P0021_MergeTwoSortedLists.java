package com.ofloxacin.leetcode;

/**
 * @author chenshuai
 * @version 0.1
 * @name P0021_MergeTwoSortedLists
 * @description
 * @date 2019/11/9
 */
public class P0021_MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode node = mergeTwoLists2(l1, l2);
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
    }

    public static ListNode mergeTwoLists4(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }

    public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists3(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists3(l1, l2.next);
            return l2;
        }
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode p1 = l1.val <= l2.val ? l1 : l2;
        ListNode p2 = l1.val > l2.val ? l1 : l2;
        ListNode root = p1;
        while (p2 != null) {
            while (p1.next != null && p1.next.val <= p2.val) {
                p1 = p1.next;
            }
            if (p1.next == null) {
                p1.next = p2;
                return root;
            }
            ListNode p2s = p2;
            while (p2.next != null && p2.next.val <= p1.next.val) {
                p2 = p2.next;
            }
            ListNode temp = p1.next;
            p1.next = p2s;
            p1 = temp;
            temp = p2.next;
            p2.next = p1;
            p2 = temp;
        }
        return root;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode p = root;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                p.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            p = p.next;
        }
        while (p1 != null) {
            p.next = new ListNode(p1.val);
            p1 = p1.next;
            p = p.next;
        }
        while (p2 != null) {
            p.next = new ListNode(p2.val);
            p2 = p2.next;
            p = p.next;
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

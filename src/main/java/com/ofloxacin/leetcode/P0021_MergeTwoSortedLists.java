package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author chenshuai
 * @version 0.1
 * @date 2019/11/9
 */
public class P0021_MergeTwoSortedLists {

    interface Solution {

        ListNode mergeTwoLists(ListNode l1, ListNode l2);
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        Solution solution = new Solution3();
        ListNode node = solution.mergeTwoLists(l1, l2);
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
    }

    class Solution1 implements Solution {

        @Override
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
    }

    class Solution2 implements Solution {

        @Override
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            } else if (l2 == null) {
                return l1;
            } else if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }

    class Solution3 implements Solution {

        @Override
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            ListNode p1 = l1.val <= l2.val ? l1 : l2;
            ListNode p2 = l1.val <= l2.val ? l2 : l1;
            ListNode head = p1;
            while (true) {
                while (p1.next != null && p1.next.val <= p2.val) p1 = p1.next;
                if (p1.next == null) {
                    p1.next = p2;
                    return head;
                }
                ListNode temp = p1.next;
                p1.next = p2;
                p2 = temp;
            }
        }
    }

    public static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

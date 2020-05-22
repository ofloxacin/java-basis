package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-21
 */
public class P0142_LinkedListCycleII {

    @Test
    public void test() {

    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        ListNode p = head;
        while (p != slow) {
            p = p.next;
            slow = slow.next;
        }
        return p;
    }

    class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

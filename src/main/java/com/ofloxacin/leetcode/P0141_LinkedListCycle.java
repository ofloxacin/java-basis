package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-21
 */
public class P0141_LinkedListCycle {

    @Test
    public void test() {

    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);
        return true;
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

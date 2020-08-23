package com.ofloxacin.interview.kuaishou;

/**
 * @author chens
 **/
public class LinkListReverseK {

    public static void main(String[] args) {
        ListNode origin = gen(20);
        print(origin);
        ListNode reversed = reverseByK(origin, 3);
        print(reversed);
    }

    public static ListNode gen(int num) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        for (int i = 0; i < num; i++) {
            pre.next = new ListNode(i);
            pre = pre.next;
        }
        return dummy.next;
    }

    public static ListNode reverseByK(ListNode head, int k) {
        if (head == null || head.next == null || k == 0 || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (true) {
            ListNode rHead = reverse(head, k);
            p.next = rHead;
            p = head;
            if (rHead == null || rHead == head) {
                break;
            }
            head = head.next;
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        int count = 0;
        ListNode rHead = null;
        ListNode p = head;
        while (p != null && count < k) {
            ListNode temp = p.next;
            p.next = rHead;
            rHead = p;
            p = temp;
            count++;
        }
        if (count != k) {
            rHead = reverse(rHead, count);
        } else {
            head.next = p;
        }
        return rHead;
    }

    private static void print(ListNode node) {
        ListNode p = node;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println("null");
    }

    static class ListNode {

        int val;

        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}

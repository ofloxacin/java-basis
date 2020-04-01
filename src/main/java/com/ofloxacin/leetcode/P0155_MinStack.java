package com.ofloxacin.leetcode;

import java.util.Stack;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-01-07
 */
public class P0155_MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }

    static class MinStack {

        private Node head;

        public void push(int x) {
            int min = head == null ? x : Math.min(x, head.min);
            head = new Node(x, min, head);
        }

        public void pop() {
            ensureNotEmpty();
            head = head.next;
        }

        public int top() {
            ensureNotEmpty();
            return head.val;
        }

        public int getMin() {
            ensureNotEmpty();
            return head.min;
        }

        private void ensureNotEmpty() {
            if (head == null) {
                throw new RuntimeException("empty");
            }
        }

        class Node {

            int val;

            int min;

            Node next;

            public Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }
    }

    static class MinStack2 {

        private Stack<Integer> data = new Stack<>();

        private Stack<Integer> sort = new Stack<>();

        public void push(int x) {
            data.push(x);
            if (sort.isEmpty() || x <= sort.peek()) {
                sort.push(x);
            }
        }

        public void pop() {
            int val = data.pop();
            if (val == sort.peek()) {
                sort.pop();
            }
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return sort.peek();
        }
    }

    static class MinStack3 {

        private int min = Integer.MAX_VALUE;

        private Stack<Integer> data = new Stack<>();

        public void push(int x) {
            if (x <= min) {
                data.push(min);
                min = x;
            }
            data.push(x);
        }

        public void pop() {
            if (data.pop() == min) {
                min = data.pop();
            }
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return min;
        }
    }
}

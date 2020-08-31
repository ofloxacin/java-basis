package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-25
 */
public class P0146_LruCache {

    @Test
    public void test() {
        LRUCache2 cache = new LRUCache2(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));    // 返回  1
        cache.put(3, 3);                  // 该操作会使得密钥 2 作废
        assertEquals(-1, cache.get(2));   // 返回 -1 (未找到)
        cache.put(4, 4);                  // 该操作会使得密钥 1 作废
        assertEquals(-1, cache.get(1));   // 返回 -1 (未找到)
        assertEquals(3, cache.get(3));    // 返回  3
        assertEquals(4, cache.get(4));    // 返回  4
    }

    class LRUCache1 extends LinkedHashMap<Integer, Integer> {

        private final int capacity;

        public LRUCache1(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    class LRUCache2 {

        private final int capacity;

        private final Map<Integer, Node> cache = new HashMap<>();

        private final Node head = new Node();

        private final Node tail = new Node();

        private static final int NONE = -1;

        public LRUCache2(int capacity) {
            if (capacity <= 0) {
                throw new IllegalArgumentException();
            }
            this.capacity = capacity;
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return NONE;
            }
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node old = cache.get(key);
            if (old != null) {
                old.value = value;
                moveToHead(old);
                return;
            }
            if (cache.size() == capacity) {
                cache.remove(removeTail());
            }
            Node node = new Node(head, head.next, key, value);
            head.next.pre = node;
            head.next = node;
            cache.put(key, node);
        }

        private void moveToHead(Node node) {
            if (node == head.next) {
                return;
            }
            node.pre.next = node.next;
            node.next.pre = node.pre;

            node.next = head.next;
            head.next.pre = node;
            node.pre = head;
            head.next = node;
        }

        private int removeTail() {
            Node temp = tail.pre;
            temp.pre.next = temp.next;
            temp.next.pre = temp.pre;
            temp.pre = null;
            temp.next = null;
            return temp.key;
        }

        class Node {

            Node pre;

            Node next;

            int key;

            int value;

            Node() {

            }

            Node(Node pre, Node next, int key, int value) {
                this.pre = pre;
                this.next = next;
                this.key = key;
                this.value = value;
            }
        }
    }
}

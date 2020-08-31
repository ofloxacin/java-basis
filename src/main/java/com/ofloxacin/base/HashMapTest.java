package com.ofloxacin.base;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-04-27
 */
public class HashMapTest {

    public static void main(String[] args) {
        Map<Node, Integer> nodeIntegerMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            nodeIntegerMap.put(new Node(i), i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            nodeIntegerMap.remove(i);
        }
    }

    @AllArgsConstructor
    static class Node {

        private final int id;

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Node) {
                return ((Node) obj).id == this.id;
            }
            return false;
        }
    }
}

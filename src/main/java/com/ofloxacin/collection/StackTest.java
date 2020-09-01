package com.ofloxacin.collection;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author chens
 **/
public class StackTest {

    @Test
    public void test() {
        Stack<Integer> stack = new Stack<>();
        stack.push(null);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(null);
        queue.offer(null);
        queue.peek();
        queue.poll();
        queue.element();
        queue.remove();
    }
}

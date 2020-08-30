package com.ofloxacin.temp;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenshuai
 * @date 2020/08/30
 */
public class Test {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(2);
        queue.add(3);
        queue.add(5);
        int n = 1000;
        int result = -1;
        while (n > 0) {
            result = queue.poll();
            n--;
            queue.add(result * 10 + 2);
            queue.add(result * 10 + 3);
            queue.add(result * 10 + 5);
        }
        System.out.println(result);
    }
}

package com.ofloxacin.structures;

import com.ofloxacin.util.TimeSpanUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chens
 * @date 2019/6/27 17:56
 */
public class Fibonacci {

    public static void main(String[] args) {
        int n = 1000;
        Map<Integer, Long> cache = new HashMap<>();
        TimeSpanUtil.init();
        System.out.println(fib(n, cache));
        TimeSpanUtil.printSpan();

        TimeSpanUtil.init();
        System.out.println(fib2(n));
        TimeSpanUtil.printSpan();
    }

    private static long fib(int n, Map<Integer, Long> cache) {
        if (n <= 1) {
            return 1;
        }
        int x = n - 2;
        int y = n - 1;
        if (!cache.containsKey(x)) {
            cache.put(x, fib(x, cache));
        }
        if (!cache.containsKey(y)) {
            cache.put(y, fib(y, cache));
        }
        return cache.get(x) + cache.get(y);
    }

    private static long fib2(int n) {
        long x = 1;
        long y = 1;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = x + y;
            x = y;
            y = result;
        }
        return result;
    }
}

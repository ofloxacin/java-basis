package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-28
 */
public class P1116_PrintZeroEvenOdd {

    @Test
    public void test() throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        Thread zero = new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread even = new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread odd = new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        zero.start();
        even.start();
        odd.start();
    }

    class ZeroEvenOdd {

        private int n;

        private Semaphore sZero = new Semaphore(1);

        private Semaphore sEven = new Semaphore(0);

        private Semaphore sOdd = new Semaphore(0);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                sZero.acquire();
                printNumber.accept(0);
                if ((i & 1) == 0) {
                    sEven.release();
                } else {
                    sOdd.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                sEven.acquire();
                printNumber.accept(i);
                sZero.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                sOdd.acquire();
                printNumber.accept(i);
                sZero.release();
            }
        }
    }
}

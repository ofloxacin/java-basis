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
public class P1195_FizzBuzzMultithreaded {

    @Test
    public void test() {
        FizzBuzz foo = new FizzBuzz(20);
        Thread t1 = new Thread(() -> {
            try {
                foo.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                foo.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                foo.fizzbuzz(() -> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t4 = new Thread(() -> {
            try {
                foo.number(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    class FizzBuzz {

        private final int n;

        private final Semaphore fizz = new Semaphore(0);

        private final Semaphore buzz = new Semaphore(0);

        private final Semaphore fizzbuzz = new Semaphore(0);

        private final Semaphore number = new Semaphore(1);

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            for (int i = 3; i <= n; i += 3) {
                if (i % 15 == 0) {
                    continue;
                }
                fizz.acquire();
                printFizz.run();
                number.release();
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for (int i = 5; i <= n; i += 5) {
                if (i % 15 == 0) {
                    continue;
                }
                buzz.acquire();
                printBuzz.run();
                number.release();
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for (int i = 15; i <= n; i += 15) {
                fizzbuzz.acquire();
                printFizzBuzz.run();
                number.release();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                number.acquire();
                if (i % 15 == 0) {
                    fizzbuzz.release();
                } else if (i % 3 == 0) {
                    fizz.release();
                } else if (i % 5 == 0) {
                    buzz.release();
                } else {
                    printNumber.accept(i);
                    number.release();
                }
            }
        }
    }
}

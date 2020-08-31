package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-28
 */
public class P1117_BuildingH2o {

    @Test
    public void test() {
        Solution solution = new Solution2();
        Thread t1 = new Thread(() -> {
            try {
                solution.hydrogen(() -> System.out.println("H"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                solution.oxygen(() -> System.out.println("O"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                solution.hydrogen(() -> System.out.println("H"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }

    interface Solution {

        void hydrogen(Runnable releaseHydrogen) throws InterruptedException;

        void oxygen(Runnable releaseOxygen) throws InterruptedException;
    }

    class Solution1 implements Solution {

        private final Semaphore h = new Semaphore(2);

        private final Semaphore o = new Semaphore(1);

        private final Object lock = new Object();

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            h.acquire();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            synchronized (lock) {
                if (h.availablePermits() == 0 && o.availablePermits() == 0) {
                    lock.notifyAll();
                    h.release(2);
                    o.release(1);
                } else {
                    lock.wait();
                }
            }
            releaseHydrogen.run();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            o.acquire();
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            synchronized (lock) {
                if (h.availablePermits() == 0 && o.availablePermits() == 0) {
                    lock.notifyAll();
                    h.release(2);
                    o.release(1);
                } else {
                    lock.wait();
                }
            }
            releaseOxygen.run();
        }
    }

    class Solution2 implements Solution {

        private final Semaphore h = new Semaphore(2);

        private final Semaphore o = new Semaphore(1);

        private final Semaphore currentH = new Semaphore(0);

        private final Semaphore currentO = new Semaphore(0);

        @Override
        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            h.acquire();
            currentH.release();
            currentO.acquire();
            releaseHydrogen.run();
            h.release();
        }

        @Override
        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            o.acquire();
            currentO.release(2);
            currentH.acquire(2);
            releaseOxygen.run();
            o.release();
        }
    }
}

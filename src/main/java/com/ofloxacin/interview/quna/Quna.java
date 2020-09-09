package com.ofloxacin.interview.quna;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-09-09
 */
public class Quna {

    private static volatile boolean start = false;

    public static void main(String[] args) {
        test4();
    }

    public static void test1() {
        CountDownLatch latch = new CountDownLatch(4);
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        try {
            List<Future<Integer>> results = new ArrayList<>(4);
            for (int i = 0; i < 4; i++) {
                results.add(threadPool.submit(() -> {
                    ThreadLocalRandom random = ThreadLocalRandom.current();
                    latch.countDown();
                    System.out.println("wait begin");
                    while (!start) {
                    }
                    System.out.println("begin");
                    return random.nextInt(10);
                }));
            }
            latch.await();
            start = true;
            int sum = 0;
            for (Future<Integer> result : results) {
                System.out.println(result.get());
                sum += result.get();
            }
            System.out.println(sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        threadPool.shutdown();
    }

    public static void test2() {
        CyclicBarrier cb = new CyclicBarrier(4);
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        List<Future<Integer>> futures = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            Future<Integer> future = threadPool.submit(() -> {
                ThreadLocalRandom random = ThreadLocalRandom.current();
                try {
                    System.out.println("wait begin");
                    cb.await();
                    System.out.println("begin");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                return random.nextInt(10);
            });
            futures.add(future);
        }
        int sum = 0;
        for (Future<Integer> future : futures) {
            try {
                System.out.println(future.get());
                sum += future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sum);
        threadPool.shutdown();
    }

    public static void test3() {
        Lock lock = new ReentrantLock();
        Condition start = lock.newCondition();
        CountDownLatch latch = new CountDownLatch(4);
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        List<Future<Integer>> futures = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            futures.add(threadPool.submit(() -> {
                ThreadLocalRandom random = ThreadLocalRandom.current();
                latch.countDown();
                lock.lock();
                try {
                    System.out.println("wait begin");
                    start.await();
                    System.out.println("begin");
                } finally {
                    lock.unlock();
                }
                return random.nextInt(10);
            }));
        }
        try {
            latch.await();
        } catch (InterruptedException e) {

        }
        lock.lock();
        try {
            start.signalAll();
        } finally {
            lock.unlock();
        }
        int sum = 0;
        for (Future<Integer> future : futures) {
            try {
                System.out.println(future.get());
                sum += future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sum);
        threadPool.shutdown();
    }

    public static void test4() {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        CountDownLatch latch = new CountDownLatch(4);
        List<Future<Integer>> futures = new ArrayList<>(4);
        Object lock = new Object();
        for (int i = 0; i < 4; i++) {
            futures.add(threadPool.submit(() -> {
                ThreadLocalRandom random = ThreadLocalRandom.current();
                synchronized (lock) {
                    try {
                        System.out.println("lock wait");
                        latch.countDown();
                        lock.wait();
                        System.out.println("doing");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return random.nextInt(10);
            }));
        }
        try {
            latch.await();
        } catch (InterruptedException e) {

        }
        synchronized (lock) {
            lock.notifyAll();
        }
        int sum = 0;
        for (Future<Integer> future : futures) {
            try {
                sum += future.get();
            } catch (InterruptedException | ExecutionException e) {

            }
        }
        System.out.println(sum);
        threadPool.shutdown();
    }
}

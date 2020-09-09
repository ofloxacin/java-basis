package com.ofloxacin.interview.quna;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-09-09
 */
public class Quna {

    private static volatile boolean start = false;

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(4);
        List<Callable<Integer>> tasks = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            tasks.add(() -> {
                latch.countDown();
                while (!start) {
                }
                return ThreadLocalRandom.current().nextInt(10);
            });
        }
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        try {
            List<Future<Integer>> results = new ArrayList<>(4);
            tasks.forEach(t -> results.add(threadPool.submit(t)));
            latch.await();
            start = true;
            int sum = 0;
            for (Future<Integer> result : results) {
                System.out.println(result.get());
                sum += result.get();
            }
            System.out.println(sum);
        } catch (InterruptedException | ExecutionException e) {

        }
        threadPool.shutdown();
    }
}

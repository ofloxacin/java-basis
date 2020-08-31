package com.ofloxacin.concurrent.queue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ChenShuai
 * @date 2018/6/12 9:22
 */
public class CustomQueueTest {

    public static void main(String[] args) {
        final CustomQueue customQueue = new CustomQueue();
        final int MAX_COUNT = 100;

        BlockingQueue<Runnable> workingQueue = new ArrayBlockingQueue<Runnable>(10);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS, workingQueue);
        threadPoolExecutor.prestartAllCoreThreads();

        workingQueue.add(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                Random random = new Random();
                for (int i = 0; i < MAX_COUNT; i++) {
                    customQueue.add(i);
                    try {
                        Thread.sleep(random.nextInt(100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        workingQueue.add(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                while (true) {
                    while (customQueue.size() > 0) {
                        System.out.println(customQueue.pull());
                    }
                    Thread.yield();
                }
            }
        });
    }
}

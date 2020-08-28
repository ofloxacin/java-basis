package com.ofloxacin.guava;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-08-18
 */
public class GuavaTest {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10000, 10000, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), r -> new Thread(new ThreadGroup("my-thread"), r), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            }
        });
        threadPoolExecutor.submit(() -> {});
        System.out.println();
    }
}

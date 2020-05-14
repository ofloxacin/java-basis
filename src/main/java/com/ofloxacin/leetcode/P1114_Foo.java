package com.ofloxacin.leetcode;

import java.util.concurrent.Semaphore;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-13
 */
public class P1114_Foo {

    private Semaphore first = new Semaphore(0);

    private Semaphore second = new Semaphore(0);

    public P1114_Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        first.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        first.acquire();
        printSecond.run();
        second.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        second.acquire();
        printThird.run();
    }
}

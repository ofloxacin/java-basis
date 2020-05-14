package com.ofloxacin.leetcode;

import java.util.concurrent.Semaphore;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-13
 */
public class P1115_FooBar {

    private int n;

    private Semaphore foo = new Semaphore(1);

    private Semaphore bar = new Semaphore(0);

    public P1115_FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.acquire();
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire();
            printBar.run();
            foo.release();
        }
    }
}

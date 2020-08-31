package com.ofloxacin.concurrent.thread;

/**
 * @author ChenShuai
 * @date 2018/6/19 17:00
 */
public class DeadLockDemo {

    private static final Object o1 = new Object();

    private static final Object o2 = new Object();

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    private void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " locked o1");
                        Thread.sleep(2000);
                        synchronized (o2) {
                            System.out.println(Thread.currentThread().getName() + " locked o2");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + " locked o2");
                    synchronized (o1) {
                        System.out.println(Thread.currentThread().getName() + " locked o1");
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}

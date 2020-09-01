package com.ofloxacin.concurrent.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chens
 **/
public class MyBlockingQueue<E> {

    private final Lock lock = new ReentrantLock();

    private final Condition notFull = lock.newCondition();

    private final Condition notEmpty = lock.newCondition();

    private final List<E> container;

    private final int capacity;

    private int count;

    public MyBlockingQueue(int capacity) {
        this.container = new ArrayList<>(capacity);
        this.capacity = capacity;
        this.count = 0;
    }

    public void put(E e) throws InterruptedException {
        lock.lock();
        try {
            while (count == capacity) {
                notFull.await();
            }
            container.add(e);
            count++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public E take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            E node = container.remove(0);
            count--;
            notFull.signal();
            return node;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(5);
        Thread provider = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    queue.put(i);
                    System.out.println("provider put " + i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("producer exit");
        });
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    Integer e = queue.take();
                    System.out.println("consumer take " + e);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("consumer exit");
        });
        //provider.start();
        consumer.start();
        queue.lock.lock();
        consumer.interrupt();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("provider isInterrupted " + provider.isInterrupted());
        System.out.println("provider isAlive " + provider.isAlive());

        System.out.println("consumer isInterrupted " + consumer.isInterrupted());
        System.out.println("consumer isAlive " + consumer.isAlive());

        consumer.interrupt();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread.interrupted();

        System.out.println("consumer isInterrupted " + consumer.isInterrupted());
        System.out.println("consumer isAlive " + consumer.isAlive());
    }
}

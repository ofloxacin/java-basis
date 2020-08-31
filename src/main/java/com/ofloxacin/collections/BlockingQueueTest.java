package com.ofloxacin.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenshuai
 * @date 2020/08/27
 */
public class BlockingQueueTest {

    private static final ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        Condition notFull = lock.newCondition();
        Condition notEmpty = lock.newCondition();

        try {
            lock.lock();
            lock.tryLock();
            lock.lockInterruptibly();
            notFull.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(1);
        System.out.println(blockingQueue.size());
        System.out.println(blockingQueue.remainingCapacity());
        try {
            blockingQueue.put(20);
            System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(blockingQueue.offer(20));
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.peek());

        System.out.println(blockingQueue.add(20));
        System.out.println(blockingQueue.remove(20));
        System.out.println(blockingQueue.element());
    }
}

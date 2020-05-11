package com.ofloxacin;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-04-22
 */
public class LockTest {

    @Test
    public void testLock() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
    }

    @Test
    public void testReadLock() {
        ReentrantReadWriteLock.ReadLock readLock = new ReentrantReadWriteLock().readLock();
        readLock.lock();
        readLock.unlock();
    }

    @Test
    public void testWriteLock() {
        ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        writeLock.lock();
        writeLock.unlock();
    }
}

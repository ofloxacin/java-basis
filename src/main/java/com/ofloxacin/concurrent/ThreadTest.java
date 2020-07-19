package com.ofloxacin.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * @author chens
 **/
public class ThreadTest {

    public static void main(String[] args) {
        LockSupport.park();
    }
}

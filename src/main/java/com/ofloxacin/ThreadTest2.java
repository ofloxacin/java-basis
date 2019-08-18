package com.ofloxacin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenShuai
 * @date 2018/10/11 14:38
 */
public class ThreadTest2 {

    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(runnable);
            t.setName("t" + (char) (97 + i));
            threadList.add(t);
        }
        threadList.forEach(Thread::start);
    }
}

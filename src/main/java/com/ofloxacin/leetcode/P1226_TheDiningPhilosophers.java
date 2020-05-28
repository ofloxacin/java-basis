package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-28
 */
public class P1226_TheDiningPhilosophers {

    @Test
    public void test() {
        Solution solution = new Solution1();
        for (int i = 0; i < 5; i++) {
            int philosopher = i;
            new Thread(() -> {
                try {
                    while (true) {
                        solution.wantsToEat(philosopher,
                                () -> System.out.println(Arrays.asList(philosopher, 1, 1)),
                                () -> System.out.println(Arrays.asList(philosopher, 2, 1)),
                                () -> System.out.println(Arrays.asList(philosopher, 0, 3)),
                                () -> System.out.println(Arrays.asList(philosopher, 1, 2)),
                                () -> System.out.println(Arrays.asList(philosopher, 2, 2)));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    interface Solution {

        // call the run() method of any runnable to execute its code
        void wantsToEat(int philosopher,
                        Runnable pickLeftFork,
                        Runnable pickRightFork,
                        Runnable eat,
                        Runnable putLeftFork,
                        Runnable putRightFork) throws InterruptedException;
    }

    class Solution1 implements Solution {

        private boolean[] ates = new boolean[5];

        private Semaphore[] semaphores = new Semaphore[]{
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1)};

        @Override
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            if (ates[philosopher]) {
                return;
            }
            semaphores[philosopher].acquire();
            pickLeftFork.run();
            semaphores[(philosopher + 1) % 5].acquire();
            pickRightFork.run();
            eat.run();
            semaphores[philosopher].release();
            putLeftFork.run();
            semaphores[(philosopher + 1) % 5].release();
            putRightFork.run();
            ates[philosopher] = true;
        }
    }
}

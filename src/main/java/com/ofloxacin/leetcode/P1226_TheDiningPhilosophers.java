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
        Solution solution = new Solution2();
        for (int i = 0; i < 5; i++) {
            int philosopher = i;
            new Thread(() -> {
                try {
                    solution.wantsToEat(philosopher,
                            () -> System.out.println(Arrays.asList(philosopher, 1, 1)),
                            () -> System.out.println(Arrays.asList(philosopher, 2, 1)),
                            () -> System.out.println(Arrays.asList(philosopher, 0, 3)),
                            () -> System.out.println(Arrays.asList(philosopher, 1, 2)),
                            () -> System.out.println(Arrays.asList(philosopher, 2, 2)));
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

    /**
     * 限定就餐策略
     */
    class Solution1 implements Solution {

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
            int left = philosopher;
            int right = (philosopher + 1) % 5;
            if ((philosopher & 1) == 0) {
                semaphores[left].acquire();
                semaphores[right].acquire();
            } else {
                semaphores[right].acquire();
                semaphores[left].acquire();
            }
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            semaphores[left].release();
            semaphores[right].release();
        }
    }

    /**
     * 限定就餐数量
     */
    class Solution2 implements Solution {

        private Semaphore[] semaphores = new Semaphore[]{
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1)
        };

        private Semaphore available = new Semaphore(4);

        @Override
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            available.acquire();
            int left = philosopher;
            int right = (philosopher + 1) % 5;
            semaphores[left].acquire();
            semaphores[right].acquire();
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            semaphores[left].release();
            semaphores[right].release();
            available.release();
        }
    }

    /**
     * 同时拿起左右叉子
     */
    class Solution3 implements Solution {

        private Semaphore[] semaphores = new Semaphore[]{
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1)
        };

        private Semaphore lock = new Semaphore(1);

        @Override
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            lock.acquire();
            int left = philosopher;
            int right = (philosopher + 1) % 5;
            semaphores[left].acquire();
            semaphores[right].acquire();
            pickLeftFork.run();
            pickRightFork.run();
            lock.release();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            semaphores[left].release();
            semaphores[right].release();
        }
    }
}

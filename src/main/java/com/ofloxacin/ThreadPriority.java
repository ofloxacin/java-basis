package com.ofloxacin;

import java.util.List;

public class ThreadPriority {

    private static volatile boolean notStart;

    private static volatile boolean notEnd;

    public static void main(String[] args) {
        List<Job> jobList;

        for (int i = 0; i < 5; i++) {

        }
    }

    private class Job implements Runnable {

        private int priority;

        private long jobCount;

        public Job(int priority) {
            this.priority = priority;
        }

        @Override
        public void run() {
            while (notStart) {
                Thread.yield();
            }
            while (notEnd) {
                Thread.yield();
                jobCount++;
            }
        }
    }
}

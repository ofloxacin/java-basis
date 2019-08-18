package com.ofloxacin;

/**
 * @author ChenShuai
 * @date 2018/6/19 13:40
 */
public class ConcurrencyTest {

    private static final long COUNT = 100000001;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
        while (true) {
            Thread.sleep(200000);
        }
    }

    public static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (int i = 0; i < COUNT; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (int i = 0; i < COUNT; i++) {
            b++;
        }
        thread.join();
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (int i = 0; i < COUNT; i++) {
            a += 5;
        }
        int b = 0;
        for (int i = 0; i < COUNT; i++) {
            b++;
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}

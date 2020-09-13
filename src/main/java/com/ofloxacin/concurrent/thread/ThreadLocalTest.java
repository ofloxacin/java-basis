package com.ofloxacin.concurrent.thread;

/**
 * @author chenshuai
 * @date 2020/09/13
 */
public class ThreadLocalTest {

    private static final ThreadLocal<Integer> TL_INT = ThreadLocal.withInitial(() -> 5);

    public static void main(String[] args) {
        System.out.println(TL_INT.get());
        TL_INT.set(TL_INT.get() + 1);
        System.out.println(TL_INT.get());
        TL_INT.remove();
        System.out.println(TL_INT.get());
    }
}

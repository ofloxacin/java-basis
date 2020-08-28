package com.ofloxacin.concurrent.atomic;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-08-04
 */
public class AtomicTest {

    @Test
    public void test() {
        AtomicInteger count = new AtomicInteger();
        count.addAndGet(10);
        count.incrementAndGet();

        LongAdder longAdder = new LongAdder();
        longAdder.add(1L);
        longAdder.longValue();
    }
}

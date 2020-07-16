package com.ofloxacin;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-07-03
 */
public class Test {

    public static void main(String[] args) {
        TimeSpanUtil.init();
        int a = 0, b = 0;
        for (int i = 0; i < 100000000; i++) {
            if (i % 2 == 0) {
                a++;
            }
            if (i % 3 == 0) {
                b++;
            }
        }
        System.out.println(a + b);
        TimeSpanUtil.printSpan();
    }
}

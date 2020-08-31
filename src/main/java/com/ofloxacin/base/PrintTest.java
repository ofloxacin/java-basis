package com.ofloxacin.base;

/**
 * @author chens
 * @date 2019/4/11 20:54
 */
public class PrintTest {

    public static void main(String[] args) throws InterruptedException {
        int MAX = 1000000000;
        int i = 0;
        while (i < MAX) {
            Thread.sleep(100);
            System.out.print(++i + "\r");
        }
    }
}

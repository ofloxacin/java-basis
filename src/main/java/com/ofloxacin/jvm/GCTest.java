package com.ofloxacin.jvm;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-08-28
 */
public class GCTest {

    public static void main(String[] args) {
        while (true) {
            System.gc();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.ofloxacin.jvm;

/**
 * @author chens
 * @date 2019/9/13 13:13
 */
public class JavaVMStackOOM {

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

    private void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(() -> {
                while (true) {

                }
            });
            thread.start();
        }
    }
}

package com.ofloxacin.jvm;

/**
 * @author chens
 * @date 2019/9/13 12:17
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public static void main(String[] args) {
        JavaVMStackSOF sof = new JavaVMStackSOF();
        try {
            sof.stackLeak();
        } catch (Throwable e) {
            System.out.println(sof.stackLength);
        }
    }

    private void stackLeak() {
        stackLength++;
        stackLeak();
    }
}

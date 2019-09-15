package com.ofloxacin.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chens
 * @date 2019/9/13 13:26
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}

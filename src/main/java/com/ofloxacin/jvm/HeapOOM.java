package com.ofloxacin.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenshuai
 * @date 2019/09/11
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}

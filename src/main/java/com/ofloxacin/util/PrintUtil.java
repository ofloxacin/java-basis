package com.ofloxacin.util;

import com.alibaba.fastjson.JSON;

/**
 * @author chens
 * @date 2018/11/9 11:53
 */
public class PrintUtil {
    public static void print(String s) {
        System.out.println(s);
    }

    public static void printJson(Object o) {
        System.out.println(JSON.toJSONString(o, true));
    }
}

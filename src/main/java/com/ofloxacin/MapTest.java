package com.ofloxacin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenShuai
 * @date 2018/7/19 16:19
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<>();
        System.out.println(params.put("cs", 10));
        System.out.println(params.put("lyz", 15));
        System.out.println(params.put("cs", 20));
    }
}

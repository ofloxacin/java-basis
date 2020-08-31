package com.ofloxacin.base;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ChenShuai
 * @date 2018/7/19 16:04
 */
public class SetTest {

    public static void main(String[] args) {
        Set<Integer> integers = new HashSet<>();
        System.out.println(integers.add(1));
        System.out.println(integers.add(2));
        System.out.println(integers.add(3));
        System.out.println(integers.add(1));
    }
}

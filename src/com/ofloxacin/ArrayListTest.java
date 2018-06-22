package com.ofloxacin;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChenShuai
 * @date 2018/6/21 19:14
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");

        subListError(strings);
        subListError2();
    }

    public static void subListError(List<String> strings) {
        try {
            ArrayList<String> subList = (ArrayList<String>)strings.subList(0, 2);
            System.out.println(subList);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    public static void subListError2() {
        try {
            List<String> strings = Arrays.asList("ni", "hao", "a");
            strings.add("chen shuai");
            System.out.println(strings);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }
}
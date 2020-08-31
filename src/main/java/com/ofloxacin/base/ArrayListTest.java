package com.ofloxacin.base;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChenShuai
 * @date 2018/6/21 19:14
 */
public class ArrayListTest {

    @Test
    public void subListError() {
        List<String> strings = new ArrayList<String>() {{
            add("1");
            add("2");
            add("3");
        }};
        ArrayList<String> subList = (ArrayList<String>) strings.subList(0, 2);
        System.out.println(subList);
    }

    @Test
    public void asListError() {
        List<String> strings = Arrays.asList("ni", "hao", "a");
        strings.add("chen shuai");
        System.out.println(strings);
    }
}

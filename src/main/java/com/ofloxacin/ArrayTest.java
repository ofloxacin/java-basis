package com.ofloxacin;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChenShuai
 * @date 2018/6/21 18:52
 */
public class ArrayTest {

    @Test
    public void test() {
        List<String> stringList = Arrays.asList("1", "2");
        String[] strArray = (String[]) stringList.toArray();
        for (String s : strArray) {
            System.out.print(s);
        }
        System.out.println();
        System.out.flush();

        String[] strArray2 = new String[stringList.size()];
        strArray2 = stringList.toArray(strArray2);
        for (String s : strArray2) {
            System.out.print(s);
        }
        System.out.println();
        System.out.flush();

        List<String> stringList2 = new ArrayList<>();
        stringList2.add("3");
        stringList2.add("4");
        String[] strArray3 = (String[]) stringList2.toArray();
        for (String s : strArray3) {
            System.out.print(s);
        }
        System.out.println();
        System.out.flush();

        String[] strArray4 = new String[stringList.size()];
        strArray4 = stringList.toArray(strArray4);
        for (String s : strArray4) {
            System.out.print(s);
        }
    }
}

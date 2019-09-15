package com.ofloxacin;

/**
 * @author chens
 * @date 2019/9/13 13:31
 */
public class StringTest {

    public static void main(String[] args) {
        String str1 = new StringBuilder("你好").append("，小明").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}

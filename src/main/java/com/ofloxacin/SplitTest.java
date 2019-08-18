package com.ofloxacin;

/**
 * @author ChenShuai
 * @date 2018/6/21 18:06
 */
public class SplitTest {

    public static void main(String[] args) {
        String str = ",,,1,,2,3,,,,,,";
        String[] strings = str.split(",");
        System.out.println(strings.length);
    }
}

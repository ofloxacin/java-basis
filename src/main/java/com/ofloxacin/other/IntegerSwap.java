package com.ofloxacin.other;

import java.lang.reflect.Field;

/**
 * @author chens
 * @date 2019/4/28 13:32
 */
public class IntegerSwap {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        swap(a, b);
        System.out.println("a value is " + a);
        System.out.println("b value is " + b);
    }

    private static void swap(Integer num1, Integer num2) {
        try {
            Field field = Integer.class.getDeclaredField("value");
            int temp = num1;
            field.setAccessible(true);
            field.set(num1, num2);
            field.set(num2, new Integer(temp));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

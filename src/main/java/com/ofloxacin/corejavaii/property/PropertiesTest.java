package com.ofloxacin.corejavaii.property;

import java.util.Properties;

/**
 * @author chens
 * @date 2018/12/4 10:29
 */
public class PropertiesTest {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        properties.list(System.out);
    }
}

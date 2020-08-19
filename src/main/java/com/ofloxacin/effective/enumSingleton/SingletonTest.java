package com.ofloxacin.effective.enumSingleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chens
 **/
public class SingletonTest {

    @Test
    public void enumSingleton() {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Assertions.assertEquals(s1, s2);
    }
}

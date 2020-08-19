package com.ofloxacin.effective.dclSingleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chens
 **/
public class SingletonTest {

    @Test
    public void dclSingleton() {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Assertions.assertEquals(s1, s2);
    }
}

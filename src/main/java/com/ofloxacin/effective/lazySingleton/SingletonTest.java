package com.ofloxacin.effective.lazySingleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chens
 **/
public class SingletonTest {

    @Test
    public void lazySingleton() {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Assertions.assertEquals(s1, s2);
    }
}

package com.ofloxacin.effective.staticSingleton;

/**
 * @author chens
 **/
public class Singleton {

    private Singleton() {

    }

    public static Singleton getInstance() {
        return SingletonHolder.singleton;
    }

    private static class SingletonHolder {

        private static final Singleton singleton = new Singleton();
    }
}

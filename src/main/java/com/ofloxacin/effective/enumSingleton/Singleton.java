package com.ofloxacin.effective.enumSingleton;

/**
 * @author chens
 **/
public class Singleton {

    private Singleton() {

    }

    public static Singleton getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }

    private enum SingletonEnum {
        INSTANCE;

        private final Singleton singleton;

        SingletonEnum() {
            singleton = new Singleton();
        }

        public Singleton getInstance() {
            return singleton;
        }
    }
}

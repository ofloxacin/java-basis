package com.ofloxacin.grammar;

/**
 * @author chens
 * @date 2018/11/28 15:11
 */
public class StaticDispatch {

    public static void main(String[] args) {
        StaticDispatch dispatch = new StaticDispatch();
        Human man = new Man();
        Human women = new Women();
        dispatch.sayHello(man);
        dispatch.sayHello(women);
    }

    public void sayHello(Human human) {
        System.out.println("human");
    }

    public void sayHello(Man man) {
        System.out.println("man");
    }

    public void sayHello(Women women) {
        System.out.println("women");
    }

    static abstract class Human {

    }

    static class Man extends Human {

    }

    static class Women extends Human {

    }
}

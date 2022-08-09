package com.tanoxi.Singleton;

/**
 * @author tanoxi
 * @date 2022/8/9 18:36
 * 饿汉式单例：容易浪费空间
 */
public class Hungry {

    private Hungry() {
    }

    private final static Hungry HUNGRY = new Hungry();

    public static Hungry getInstance(){
        return HUNGRY;
    }
}

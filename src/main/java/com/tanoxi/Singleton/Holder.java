package com.tanoxi.Singleton;

/**
 * @author tanoxi
 * @date 2022/8/9 18:51
 * 静态内部类,在反射前仍然不安全
 */
public class Holder {

    public Holder() {
    }

    public static Holder getInstance(){
        return InnerClass.HOLDER;
    }

    public static class InnerClass{
        private static final Holder HOLDER = new Holder();
    }
}

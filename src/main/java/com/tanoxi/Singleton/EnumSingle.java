package com.tanoxi.Singleton;

import java.lang.reflect.Constructor;

/**
 * @author tanoxi
 * @date 2022/8/9 19:39
 * 枚举
 */
public enum  EnumSingle {
    INSTANCE;

    public static EnumSingle getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) throws Exception {
        EnumSingle instance = EnumSingle.INSTANCE;
        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class,int.class);
        declaredConstructor.setAccessible(true);
        EnumSingle instance1 = declaredConstructor.newInstance();

        System.out.println(instance);
        System.out.println(instance1);
    }

}

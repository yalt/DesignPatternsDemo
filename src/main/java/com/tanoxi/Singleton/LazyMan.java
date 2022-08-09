package com.tanoxi.Singleton;

import javax.print.attribute.standard.NumberUp;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author tanoxi
 * @date 2022/8/9 18:39
 * 懒汉式单例
 */
public class LazyMan {

    private static boolean flag = false;

    private LazyMan() {
        synchronized (LazyMan.class){
            if (flag==false){
                flag = true;
            }else{
                throw new RuntimeException("不要试图使用反射破坏结构");
        }
        }
    }

    private volatile static LazyMan LAZYMAN;

    //双重检测模式的懒汉式单例（DCL懒汉式）
    public static LazyMan getInstance(){
        if (LAZYMAN==null){
            synchronized (LazyMan.class){
                if (LAZYMAN==null){
                    //不是一个原子性操作
                    LAZYMAN = new LazyMan();
                    /**
                     * 1.分配内存空间
                     * 2.执行构造方法，初始化对象
                     * 3.把这个对象指向这个内存空间
                     *
                     * 正常情况下顺序：123
                     * 特殊情况下顺序：132  A
                     *                   B //此时还没有执行构造
                     * 此时应该加上volatile关键字，防止指令重排，安全的懒汉式单例完成
                     */
                }
            }
        }
        return LAZYMAN;
    }

    //未加锁之前，多线程并发状态下容易出问题
    public static void main(String[] args) throws Exception {
        //模拟多线程
//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
//                LazyMan.getInstance();
//            }).start();
//        }
        //反射,加锁后一定程度上可以提高防御，但是被反编译，获取字段后仍然会被反射破解
//        LazyMan instance = LazyMan.getInstance();
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        Field flag = LazyMan.class.getDeclaredField("flag");
        flag.setAccessible(true);
        LazyMan instance = declaredConstructor.newInstance();
        flag.set(instance,false);
        LazyMan instance1 = declaredConstructor.newInstance();

        System.out.println(instance);
        System.out.println(instance1);
    }
}

package com.tanoxi.Strategy;

/**
 * @author tanoxi
 * @date 2022/8/9 21:39
 */
public class Main {
    public static void main(String[] args) {
//        int arr[] = new int[]{12,48,2,748,81,116,94,34};
        Cat arr[] = new Cat[]{new Cat(12,10),new Cat(13,8),new Cat(10,5)};
        Dog dog[] = new Dog[]{new Dog(2),new Dog(24),new Dog(63),new Dog(5)};
        Sorter.sort(dog);
    }
}

package com.tanoxi.Strategy;

import java.util.Arrays;

/**
 * @author tanoxi
 * @date 2022/8/9 20:00
 * 排序
 */
public class Sorter {
    public static void sort(Comparable[] arr){
        for (int i = 0;i<arr.length - 1; i++){
            int minPos = i;
            for (int j = i+1; j < arr.length; j++) {
                minPos = arr[j].compareTo(arr[minPos])==-1?j:minPos;
            }
            System.out.println("minPos:"+minPos);
            swap(arr,i,minPos);
            System.out.println("经过第"+i+"次循环之后，数组的内容：");
            System.out.println(Arrays.toString(arr));
        }
    }

    static void swap(Comparable[] arr,int i, int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

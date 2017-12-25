package com.yixin.sort;

import java.util.Arrays;

/**
 * 选择排序 就是循环i次  每次找到一个最小的放在i的位置
 * Created by wei
 * Date 2017/12/21
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 5, 8, 9, 0, 4, 5, 1, 6, 8, 7};
        sort( array);
        System.out.println( Arrays.toString( array ) );
    }

    private static void sort(int[] array) {
        for (int i=0;i<array.length;i++){
            int k=i;
            for (int j = i+1;j<array.length;j++){
                if (array[k]>array[j])
                    k=j;
            }
            int temp = array[k];
            array[k] = array[i];
            array[i] = temp;
        }
    }
}

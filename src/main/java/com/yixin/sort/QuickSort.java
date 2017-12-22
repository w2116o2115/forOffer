package com.yixin.sort;

import java.util.Arrays;

/**
 * 理解 定位基点  大于和小于基点的分两侧  然后递归
 * Created by wei
 * Date 2017/12/20
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 5, 8, 9, 0, 4, 5, 1, 6, 8, 7};
        sort( array, 0, array.length - 1 );
        System.out.println( Arrays.toString( array ) );
    }

    static void sort(int[] array, int left, int right) {
        int i,j,temp,t;
        if (left>right){
            return;
        }
        temp = array[left];
        i = left;
        j = right;
        while (i!=j){
            while (j>i&&array[j]>=temp)
                j--;
            while (j>i&&array[i]<=temp)
                i++;
            if (j>i){
                t = array[j];
                array[j]=array[i];
                array[i]=t;
            }
        }
        array[left] = array[i];
        array[i] = temp;

        sort( array,left,i-1 );
        sort(array,i+1,right);
    }
}

package com.yixin.sort;

import java.util.Arrays;

/**
 * Created by wei
 * Date 2017/12/22
 */
public class MergeSort {
    public static void merge(int[] array, int low, int mid, int high) {
        int i = low; // i是第一段序列的下标
        int j = mid + 1; // j是第二段序列的下标
        int k = 0; // k是临时存放合并序列的下标
        int[] array2 = new int[high - low + 1]; // array2是临时合并序列

        // 扫描第一段和第二段序列，直到有一个扫描结束
        while (i <= mid && j <= high) {
            // 判断第一段和第二段取出的数哪个更小，将其存入合并序列，并继续向下扫描
            if (array[i] <= array[j]) {
                array2[k] = array[i];
                i++;
                k++;
            } else {
                array2[k] = array[j];
                j++;
                k++;
            }
        }

        // 若第一段序列还没扫描完，将其全部复制到合并序列
        while (i <= mid) {
            array2[k] = array[i];
            i++;
            k++;
        }

        // 若第二段序列还没扫描完，将其全部复制到合并序列
        while (j <= high) {
            array2[k] = array[j];
            j++;
            k++;
        }

        // 将合并序列复制到原始序列中
        for (k = 0, i = low; i <= high; i++, k++) {
            array[i] = array2[k];
        }
    }
    public static int[] sort(int[] array, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边数组
            sort(array, low, mid);
            // 右边数组
            sort(array, mid + 1, high);
            // 左右归并
            merge(array, low, mid, high);
        }
        return array;
    }


    public static void main(String[] args) {
        int[] array = {
                9, 1, 5, 3, 4, 2, 6, 8, 7
        };
        int[] sorted = sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString( sorted ));
    }
}
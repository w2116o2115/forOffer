package com.xiaobn.algorithm;

/**
 * 二分查找算法
 * <b>
 * 二分查找是一个搜索算法,也叫折半查找,就是将查找的键和子数组的中间键作比较，如果被查找的键小于中间键，
 * 就在左子数组继续查找;如果大于中间键，就在右子数组中查找，否则中间键就是要找的元素。
 * </b>
 *
 * @author xwolf
 * @date 2017-05-24 11:27
 * @since 1.8
 */
public class BinarySearch {
    /*
 * 循环实现二分查找算法arr 已排好序的数组x 需要查找的数-1 无法查到数据
 */
    private static int binarySearch(int[] arr, int x) {
        int low = 0;//指定开始查找的位置
        int high = arr.length - 1;//结束的位置
        while (low <= high) {
            int middle = (low + high) / 2;//中间位置索引
            if (x == arr[middle]) {
                return middle;
            } else if (x < arr[middle]) {//大于中间元素,从右边部分查找
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {6, 12, 33, 87, 90, 97, 108, 561};
        System.out.println("循环查找：" + (binarySearch(arr, 87) + 1));
    }
}

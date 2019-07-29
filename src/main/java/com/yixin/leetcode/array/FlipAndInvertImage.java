package com.yixin.leetcode.array;

import java.util.Arrays;

/**
 * 翻转图像
 *
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 * ^ 位运算 异或  位相同就是0  不相同就是1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flipping-an-image
 *
 * @author Carlose wei
 * @version 1.0
 * @date 2019/7/29 10:48
 */
public class FlipAndInvertImage {
    private static int[][] flipAndInvertImage(int[][] A) {
       if (A == null || A.length == 0) return new int[0][0];
       int len = A.length;
       int B[][] = new int[len][len];
       for (int i = 0;i<len;i++){
           for (int j =  0;j<len;j++){
               B[i][j] = A[i][len - j -1] ^ 1;
           }
       }
       return B;
    }

    public static void main(String[] args) {
        int[][] a = new int[3][3];
        a[0][0] = 1;
        a[0][1] = 1;
        a[0][2] = 0;
        a[1][0] = 1;
        a[1][1] = 0;
        a[1][2] = 1;
        a[2][0] = 0;
        a[2][1] = 0;
        a[2][2] = 0;
        System.out.println(Arrays.deepToString(a));
        System.out.println(Arrays.deepToString(flipAndInvertImage(a)));
    }
}

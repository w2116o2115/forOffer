package com.yixin.leetcode.dp;

/**
 * 最长公共子串问题
 * 3. 解题思路
 * 　　最长公共子序列的性质：
 * 　　设序列X={x1,x2,…,xm}和Y={y1,y2,…,yn}的最长公共子序列为Z={z1,z2,…,zk} ，则
 * 　　(1)若xm=yn，则zk=xm=yn，且{z1...zk-1}是{x1...xm-1}和{y1...yn-1 }的最长公共子序列。
 * 　　(2)若xm≠yn且zk≠xm，则{z1....zk } 是{x1...xm-1}和{y1....yn}最长公共子序
 * 　　(3)若xm≠yn且zk≠yn，则{z1...zk}是{x1...xm}和{y1...yn-1}的最长公共子序
 * 　　则可以有如下的递归关系：
 * 　　c[i][j]表示x的第i位和y的第j位之前（包括i和j）的最长公共子序列的个数
 *
 * @Author: Carlos Zhang
 * @Date: 2019/3/27 10:19
 */
public class LCS {
    public static int lcs(int[] x,int[] y){
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[x.length+1][y.length+1];
        for (int i = 0;i<x.length;i++){
            dp[i][0] = 0;
        }
        for (int j = 0;j<y.length;j++){
            dp[0][j] = 0;
        }
        for (int i=1;i<=x.length;i++){
            for (int j=1;j<=y.length;j++){
                if (x[i-1] == y[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                if (max < dp[i][j]){
                    max = dp[i][j];
                }
            }
        }
        printSublen(dp);
        return max;
    }

    /**
     * printSublen TODO :打印commonSublen矩阵
     *
     * @param commonSublen
     * @author zhiman
     * @date 2018/04/17 下午9:55:44
     */
    private static void printSublen(int[][] commonSublen) {
        for (int i = 0; i < commonSublen.length; i++) {
            for (int j = 0; j < commonSublen[0].length; j++) {
                System.out.print(commonSublen[i][j] + "\t");
            }
            System.out.println("\n\n");
        }
    }


    public static void main(String[] args) {
        System.out.println(lcs(new int[]{1,2,3,4,5,6,7},new int[]{5,6,7,8,9,10}));
    }
}

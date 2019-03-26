package com.yixin.leetcode.dp;

/**
 * 背包问题具体例子：假设现有容量10kg的背包，另外有3个物品，分别为a1，a2，a3。物品a1重量为3kg，价值为4；物品a2重量为4kg，价值为5；物品a3重量为5kg，
 * 价值为6。将哪些物品放入背包可使得背包中的总价值最大？
 * @Author: Carlos Zhang
 * @Date: 2019/3/22 9:46
 */
public class BackPack {
    public static void main(String[] args) {
        int m = 10;//背包可以容纳的最大重量
        int n = 3;//物品的数量
        int w[] = {3,4,5};//物品的重量列表
        int p[] = {4, 5, 6};//物品的价值
        int c[][] = BackPack_Solution(m, n, w, p); //前i个物体放入容量为m的背包的最大价值
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m; j++) {
                System.out.print(c[i][j]+"\t");
                if(j==m){
                    System.out.println();
                }
            }
        }
     }

    /**
     * @param m 表示背包的最大容量
     * @param n 表示商品个数
     * @param w 表示商品重量数组
     * @param p 表示商品价值数组
     *          c[i][m]=max{c[i-1][m-w[i]]+pi , c[i-1][m]}
     */
     public static int[][] BackPack_Solution(int m, int n, int[] w, int[] p){
         //c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
         int c[][] = new int[n+1][m+1];
         for (int i = 0; i < n + 1; i++)//初始化
             c[i][0] = 0;
         for (int j = 0; j < m + 1; j++)
             c[0][j] = 0;
         for (int i=1;i<n+1;i++){//弟i个物品
             for (int j=1;j<m+1;j++){//背包的最大容量
                 //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
                 if (w[i-1] <= j){//如果当前物品重量小于等于背包中的当前重量 item为1是，weight[0]是第一个物品的重量
                     c[i][j] = Math.max(c[i - 1][j - w[i - 1]] + p[i - 1],c[i - 1][j]);
                 }else {//(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
                     c[i][j] = c[i-1][j];
                 }
             }
         }
         return c;
     }
}

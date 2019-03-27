package com.yixin.leetcode.dp;

/**
 * 一堆面值分别为 1、2、5、21、25 元，需要找出总值 T 为 63 元的零钱
 * 思路：
 * 很明显的一个动态规划题目，该问题的子问题其实就是更小数额的钱需要的最少硬币数，那我们可以先从小数额开始计算，
 * 这样后面大数额就可以借助前面已经计算好的小数额的来进行计算，
 * 比如找零，21，前面已经计算了找零20需要2个硬币，这里21很明显就是2+1=3个硬币。
 * @Author: Carlos Zhang
 * @Date: 2019/3/26 9:28
 */
public class CoinsChange {
    /**
     * 硬币找零：动态规划算法
     *
     * @param values     :保存不同硬币的币值的数组
     * @param valueKinds :values数组的大小
     * @param money      :需要找零的面值
     * @param coinsUsed  :保存面值为i的纸币找零所需的最小硬币数
     */
    public static void makeChange(int[] values, int valueKinds, int money,
                                  int[] coinsUsed) {

        coinsUsed[0] = 0;
        // 对所有数额都找零(从小到大)，即保存子问题的解以备用，即填表
        for (int cents = 1; cents <= money; cents++) {

            // 当用最小币值的硬币找零时，所需硬币数量最多
            //这里最小面值为1，那n元就需要n个硬币，所以是最多
            int minCoins = cents;

            // 遍历每一种面值的硬币，看是否可作为找零的其中之一
            //[25, 21, 10, 5, 1]
            for (int kind = 0; kind < valueKinds; kind++) {
                // 若当前面值的硬币小于当前的cents则分解问题并查表
                if (values[kind] <= cents) {
                    int temp = coinsUsed[cents - values[kind]] + 1;//拿出一张纸币 减去 面值  剩下的钱再取前边的结果中查找 + 1 就是一共有多少张纸币
                    if (temp < minCoins) {//在跟最小纸币做对比  求出最小纸币
                        minCoins = temp;
                    }
                }
            }
            // 保存最小硬币数
            coinsUsed[cents] = minCoins;

            System.out.println("面值为 " + (cents) + " 的最小硬币数 : "
                    + coinsUsed[cents]);
        }
    }


    public static void main(String[] args) {

        // 硬币面值预先已经按降序排列
        int[] coinValue = new int[] { 25, 21, 10, 5, 1 };
        // 需要找零的面值
        int money = 63;
        // 保存每一个面值找零所需的最小硬币数，0号单元舍弃不用，所以要多加1
        int[] coinsUsed = new int[money + 1];

        makeChange(coinValue, coinValue.length, money, coinsUsed);
    }
}

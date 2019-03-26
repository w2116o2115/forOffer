package com.yixin.leetcode;

/**
 * [2,3,1,1,4]
 * 非常好的一道思维题： 方法一：暴力dp,设dp[i]是到i这个位置最少步数，每次访问一个num[i],更新它步数内的每个位置dp[j]，dp[j]=min(dp[j],dp[i]+1);,
 * 这种做法很无脑，我第一反应就是这个，时间是o(n*n) 方法二：考虑到暴力dp里，每次访问num[i]，实际只会更新一个界限后面的dp值。换个角度说，
 * 只有界限后面的位置才是需要增加步数的，同时，这个界限之前的值都不需要更新，这个界限一直到”当前能走到的最大位置”为止，都是可能更新的位置。
 * 所以维护3个值，step是最大步数，last是所谓的”界限”，maxpos是说所谓”当前能走到的最大位置”。 maxpos更新思路比较好想象，
 * 初始是0,每次取自己和i+num[i]最大就可以了 last和step是一起用的，last代表了该更新step的界限，若当前访问的i超出了las，说明是，
 * 走到了需要更新step的位置，若当前访问的i超出了last，就把last调到maxpos,step+1。这个思路是o(n),不过难想到，我也是网上找的。
 * 贪心算法
 * @Author: Carlos Zhang
 * @Date: 2019/3/21 11:10
 */
public class LeetCode45 {
    public static int jump(int[] nums) {
        int step = 0;//步数
        int max = 0;//已经走过的所有节点
        int canReach = 0;//当前可达的最远范围
        for (int i=0;i<nums.length;i++){
            if (canReach < i){//当前不可达到这一位置
                step ++;//需要跳一次
                canReach = max;//跳一次
            }
            max = Math.max(max,i+nums[i]);
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(jump(nums));
    }
}

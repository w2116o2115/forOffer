package com.yixin.leetcode.dp;

/**
 * 设字符串为str，长度为n，p[i][j]表示第i到第j个字符间的子序列的个数（i<=j），则：
 * 状态初始条件：dp[i][i]=1 （i=0：n-1）
 * 状态转移方程：dp[i][j]=dp[i+1][j-1] + 2  if（str[i]==str[j]）
 *               dp[i][j]=max(dp[i+1][j],dp[i][j-1])  if （str[i]!=str[j]）
 * 最长回文子串
 * @Author: Carlos Zhang
 * @Date: 2019/5/13 10:46
 */
public class LeetCode5 {

    public static void main(String[] args) {
        String text = "abcda";
        System.out.println(longestPalindrome(text));

    }

    public static String  longestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int left = 0;
        int right = 0;
        for (int i = n - 2; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) &&( j-i<3||dp[i+1][j-1]);//小于3是因为aba一定是回文
                if(dp[i][j]&&right-left<j-i){
                    left=i;
                    right=j;
                }
            }
        }
        return s.substring(left,right+1);
    }
}

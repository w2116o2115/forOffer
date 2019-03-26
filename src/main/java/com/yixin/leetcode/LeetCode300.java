package com.yixin.leetcode;

import java.util.Arrays;

/**
 * 动态规划  dp
 * @Author: Carlos Zhang
 * @Date: 2019/3/19 14:59
 */
public class LeetCode300 {
    public static int lengthOfLIS(int[] nums) {
//        if(nums==null||nums.length==0){
//            return 0;
//        }
//        int[] res = new int[nums.length];
//        int len = 0;
//        for(int num : nums){
//            if(len==0 || num>res[len-1]){
//                res[len++] = num;
//            }else{
//                int i = Arrays.binarySearch(res,0,len,num);
//                i = i<0? -(i+1):i;
//                res[i] = num;
//            }
//        }
//        return len;
        if(nums==null||nums.length==0){
            return 0;
        }
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0;i<len;i++){
            res[i] = 1;
            for (int j = 0;j<i;j++){
                if (nums[i] > nums[j])
                    res[i] = Math.max(res[i],res[j] + 1);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i=0;i<res.length;i++){
            max = Math.max(max,res[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
        int a =  lengthOfLIS(nums);
        System.out.println(lengthOfLIS(nums));
    }
}

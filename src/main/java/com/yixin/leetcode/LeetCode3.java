package com.yixin.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @Author: Carlos Zhang
 * @Date: 2019/4/24 9:46
 */
public class LeetCode3 {
    public static void main(String[] args) {
        String a = " ";
        System.out.println(lengthOfLongestSubstring(a));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int curMax = 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i=0;i<s.length();i++){
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
                curMax++;
            }else {
                if (max < curMax){
                    max = curMax;
                }
                i = map.get(s.charAt(i));
                curMax = 0;
                map.clear();
            }
        }
        if (max < curMax){
            max = curMax;
        }
        return max;
    }
}

package com.yixin.leetcode;

/**
 * 超长字符串相加
 * @Author: Carlos Zhang
 * @Date: 2019/4/23 11:14
 */
public class LongStringPlus {
    public static void main(String[] args) {
        String str1 = "1615146841218999991234";
        String str2 = "86754468412188884321";

        StringBuffer s1 = new StringBuffer(str1).reverse();
        StringBuffer s2 = new StringBuffer(str2).reverse();
        StringBuffer res = new StringBuffer();

        int len1 = s1.length();
        int len2 = s2.length();
        int len;

        if (len1 < len2){//补0
            len = len2;
            int count = len2 - len1;
            while (count-- >0){
                s2.append("0");
            }
        }else {
            len = len1;
            int count = len1 - len2;
            while (count-- > 0)
                s2.append('0');
        }

        int overflow = 0;
        int num;

        for (int i = 0; i < len; i++) {
            num = s1.charAt(i) - '0' + s2.charAt(i) - '0' + overflow;
            if (num >= 10) {
                overflow = 1;
                num -= 10;
            } else {
                overflow = 0;
            }
            res.append(String.valueOf(num));
        }

        if (overflow == 1)
            res.append(1);

        System.out.println(1);
    }
}

package com.yixin.leetcode;

/**
 * @Author: Carlos Zhang
 * @Date: 2019/3/14 11:00
 */
public class stringRev {
    public static void main(String[] args) {
        String s = "aacecaaa";
                 //aaacecaa
        System.out.println(new StringBuffer(s).reverse().toString());
        StringBuffer ss = new StringBuffer();
        String rev = new StringBuffer(s).reverse().toString();
        for (int i=1;i<rev.length();i++){
            if(rev.substring(i).equals(s.substring(0,s.length()-i))){
                ss.append(rev.substring(0,i));
                ss.append(s);
                System.out.println(ss);
                return;
            }
        }
        ss.append(rev);
        ss.append(s, 1, s.length());
        System.out.println(ss.toString());
    }
}

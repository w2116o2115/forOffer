package com.yixin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Carlos Zhang
 * @Date: 2019/4/25 11:22
 */
public class LeetCode6 {
    public static void main(String[] args) {
        String a = "LEETCODEISHIRING";
        System.out.println(convert(a,3));
    }

    private static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}

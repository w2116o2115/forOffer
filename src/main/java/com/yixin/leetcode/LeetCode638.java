package com.yixin.leetcode;

import java.util.*;

/**
 * 在LeetCode商店中， 有许多在售的物品。
 * 然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
 * 现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。
 * 每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。
 *
 * dp[cur] = min(val, dp.get(tmp, dfs(tmp)) + spec[-1])
 * tmp为cur使用了某一个礼包之后的需要数， spec[-1] 对应这当前礼包的价格。在同一层上遍历一边，获取最小的那个值。
 * 任意大礼包可无限次购买。
 * @Author: Carlos Zhang
 * @Date: 2019/3/15 14:38
 */
public class LeetCode638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < special.size(); i++) {
            boolean isValid = true;
            List<Integer> offer = special.get(i);//获取一个礼包
            for (int j = 0; j < needs.size(); j++) {//遍历需求
                int remain = needs.get(j) - offer.get(j);//用礼包里的
                if (remain < 0) {
                    isValid = false;
                }
                needs.set(j, remain);
            }
            if (isValid) {
                res = Math.min(res, shoppingOffers(price, special, needs) + offer.get(needs.size()));
            }
            for (int j = 0; j < needs.size(); j++) {
                needs.set(j, needs.get(j) + offer.get(j));
            }
        }
        int nonOffer = 0;
        for (int i = 0; i < needs.size(); i++) {
            nonOffer += needs.get(i) * price.get(i);
        }
        return Math.min(nonOffer, res);
    }
}

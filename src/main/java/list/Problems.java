package list;

import java.util.*;

public class Problems {
    /**
     * Given a list of stock prices for their respective day, find the max profit you can achieve by buying and selling a stock
     * You have to buy a stock first to be able to sell it.
     */
    public static int problem1(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int maxPrice = Integer.MIN_VALUE, maxProfit = Integer.MIN_VALUE;
        for(int i = prices.length - 1; i >= 0; i--){
            if(prices[i] > maxPrice){
                maxPrice = prices[i];
            }
            else{
                maxProfit = Math.max(maxPrice - prices[i], maxProfit);
            }
        }

        return maxProfit == Integer.MIN_VALUE? 0 : maxProfit;
    }

    /**
     * Given a list of integers, return true if all elements are distinct
     */
    public static boolean problem2(int[] nums){
        if(nums == null || nums.length == 0)
            return true;
        Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);

        return set.size() == nums.length;
    }
}

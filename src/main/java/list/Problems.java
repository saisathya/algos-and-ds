package list;

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
                maxProfit = maxPrice - prices[i];
            }
        }

        return maxProfit == Integer.MIN_VALUE? 0 : maxProfit;
    }
}

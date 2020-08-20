package dp;

public class Problems {
    /**
     * template for the most primitive version of 0/1 knapsack
     * Given a list of item's weight and their profits, find the maximum profit given that you can take
     * items with the maximum weight of c
     */
    public static int knapsack1(int[] weights, int[] profits, int capacity){
        return knapsack1_recurse(weights, profits, capacity, 0, 0);
    }

    public static int knapsack1_recurse(int[] weights, int[] profits, int capacity, int profit, int index){
        if(index == weights.length)
            return profit;

         int a = knapsack1_recurse(weights, profits, capacity, profit, index + 1);
         int b = Integer.MIN_VALUE;
         if(weights[index] <= capacity)
             b = knapsack1_recurse(weights, profits, capacity - weights[index], profit + profits[index], index + 1);
         return Math.max(a, b);
    }

    public static int memoized_knapsack(int[] weights, int[] profits, int capacity){
        Integer[][] dp = new Integer[weights.length][capacity + 1];
        return memoized_knapsack_recurse(weights, profits, capacity, dp, 0);
    }

    public static int memoized_knapsack_recurse(int[] weights, int[] profits, int capacity, Integer[][] dp, int index){
        if(capacity <= 0 || index >= weights.length)
            return 0;

        if(dp[index][capacity] != null)
            return dp[index][capacity];

        int a = memoized_knapsack_recurse(weights, profits, capacity, dp, index + 1);
        int b = Integer.MIN_VALUE;
        if(weights[index] <= capacity)
            b = profits[index] + memoized_knapsack_recurse(weights, profits, capacity - weights[index], dp, index + 1);
        dp[index][capacity] = Math.max(a, b);

        return dp[index][capacity];
    }

    public static int bottom_up_knapsack(int[] weights, int[] profits, int capacity){
        if(weights == null || profits == null || weights.length != profits.length || capacity <= 0)
            return 0;
        int[][] dp = new int[weights.length][capacity + 1];

        for(int i = 0; i < weights.length; i++)
            dp[i][0] = 0;

        for(int c = 0; c <= capacity; c++){
            if(weights[0] <= c)
                dp[0][c] = profits[0];
        }

        for(int i = 1; i < dp.length; i++){
            for(int c = 1; c <= capacity ; c++){
                int profit = 0;
                if(weights[i] <= c)
                    profit = profits[i] + dp[i - 1][c - weights[i]];
                dp[i][c] = Math.max(profit, dp[i - 1][c]);
            }
        }
        return dp[weights.length - 1][capacity];
    }

    public static int problem1(int[] weights, int[] profits, int capacity){
        if(weights == null || profits == null || weights.length != profits.length || capacity <= 0)
            return 0;

        int[] dp = new int[capacity + 1];

        for(int i = 0; i < weights.length; i++){
            for(int c = capacity; c >= 0; c--){
                if(c - weights[i] >= 0)
                    dp[c] = Math.max(dp[c], dp[c - weights[i]] + profits[i]);
            }
        }
        return dp[capacity];
    }

}

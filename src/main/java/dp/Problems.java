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

    }
}

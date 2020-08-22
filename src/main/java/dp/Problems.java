package dp;

import java.util.*;

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

    /**
     * Given a list of integers, find if it is possible to create to subsets of equal sum using all the elements
     */
    public static boolean problem2_bruteForce(int[] arr){
        if(arr == null || arr.length == 0)
            return true;
        int sum = 0;
        for(int i : arr)
            sum += i;
        if(sum % 2 == 1)
            return false;
        int mid = sum / 2;
        return problem2_bruteForce_recurse(arr, 0, mid, 0);
    }

    public static boolean problem2_bruteForce_recurse(int[] arr, int acc, int sum , int index){
        if(index >= arr.length)
            return false;
        if(acc == sum)
            return true;
        else
            return problem2_bruteForce_recurse(arr, acc + arr[index], sum, index + 1) ||
                    problem2_bruteForce_recurse(arr, acc, sum , index + 1);
    }

    public static boolean problem2_topdown(int[] arr) {
        if(arr == null || arr.length == 0)
            return false;
        int sum = 0;
        for(int i : arr)
            sum += i;
        if(sum % 2 == 1)
            return false;
        int mid = sum / 2;
        Boolean[][] dp = new Boolean[arr.length][mid + 1];

        return problem2_topdown_recurse(arr, dp, mid, 0);
    }

    public static boolean problem2_topdown_recurse(int[] arr, Boolean[][] dp, int sum , int idx){
        if(idx >= arr.length)
            return false;
        if(sum == 0)
            return true;

        if(dp[idx][sum] == null){
            if(arr[idx] <= sum){
                if(problem2_topdown_recurse(arr, dp, sum - arr[idx], idx + 1)){
                    dp[idx][sum] = true;
                    return true;
                }
            }
        }

        dp[idx][sum] = problem2_topdown_recurse(arr, dp, sum, idx + 1);
        return dp[idx][sum];
    }



    public static boolean problem2_bottom_up(int[] arr){
        if(arr == null || arr.length == 0)
            return true;
        int sum = 0;
        for(int i : arr)
            sum += i;
        if(sum % 2 == 1)
            return false;
        int mid = sum / 2;
        boolean[][] dp = new boolean[arr.length][mid + 1];
        for(int i = 0; i < dp[0].length; i++)
            dp[0][i] = arr[0] == i;
        for(int i = 0; i < dp.length; i++)
            dp[i][0] = true;

        for(int i = 1; i < arr.length; i++){
            for(int j = arr[i]; j <= mid; j++){
                if(j - arr[i] >= 0)
                    dp[i][j] = dp[i - 1][j - arr[i]] || dp[i - 1][j];
            }
        }

        return dp[arr.length - 1][mid];
    }

    public static boolean problem2_bottom_up_linear_space(int[] arr){
        if(arr == null || arr.length == 0)
            return true;

        int sum = 0;
        for(int i : arr)
            sum += i;
        if(sum % 2 == 1)
            return false;
        int mid = sum / 2;

        boolean[] dp = new boolean[mid + 1];
        dp[0] = true;

        for(int i = 0; i < arr.length; i++){
            for(int j = arr[i]; j <= mid; j++){
                if(j - arr[i] >= 0)
                    dp[j] = dp[j - arr[i]];
            }
        }

        return dp[mid];
    }

    /**
     * you are give a set of positive numbers and sum, determine if you can create a subset of
     * positive numbers whose sum is S
     */
    public static boolean problem3(List<Integer> list, int sum){
        if(list == null || list.isEmpty())
            return sum == 0;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for(int i = 0; i <= sum ; i++) {
            if(dp[i]) {
                for(int j : list){
                    if(i + j <= sum)
                        dp[i + j] = true;
                }
            }
        }
        return dp[sum];
    }
}

package xor;

public class Problems {
    /**
     * Given a list of n - 1 numbers, the value of each number is between 1 - n, find the missing number
     */
    public static int problem1(int[] arr){
        if(arr == null || arr.length == 0)
            return 1;

        int x = 0;
        for(int i  = 1; i <= arr.length + 1; i++)
            x ^= i;
        int y = 0;
        for(int i : arr)
            y ^= i;
        return x ^ y;
    }

    /**
     * You are given a list of numbers. Each number comes in a pair, except for one. Return that value
     */
    public static int problem2(int[] arr){
        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException();
        int ans = 0;
        for(int a : arr)
            ans ^= a;
        return ans;
    }
}

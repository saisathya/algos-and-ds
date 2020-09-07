package counting_arithmetic;

public class Problems {
    /**
     * You are given a list of numbers of size n.
     * Count all the different ways to obtain a subset of size 3 such that:
     * arr[i] < arr[j] < arr[k] or arr[i] > arr[j] > arr[k]
     * for 0 <= i < j < k < n
     */
    public static long problem1(int[] arr){
        if(arr == null || arr.length < 3)
            return 0;
        long ans = 0;
        for(int i = 0; i < arr.length; i++){
            int left = 0, right = 0;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i])
                    left++;
            }
            for(int k = i + 1; k < arr.length; k++){
                if(arr[i] < arr[k])
                    right++;
            }
            /*
             * The calculation is relatively simple:
             * if they are two values from the left that is lesser than the current value X, and two values greater
             * than the current value X then there are four combinations: L_1XR_1, L_1XR_2, L_2XR_1, and L_2XR_2. Thus, 2 * 2
             * Two find the converse, we just subtract the total length of the of 0 -> i with left to find the number of values greater than X.
             * Similarly, to the other side.
             */
            ans += (right * left) + (i - left)*(arr.length - i - right - 1);
        }
        return ans;
    }

    /** https://leetcode.com/problems/k-concatenation-maximum-sum/submissions/
     * Given a list and an integer k, find the max subarray sum when you have concatenated the list k times
     */
    public static int problem2(int[] arr, int k){
        if(arr == null)
            throw new IllegalArgumentException();
        long prefix = Long.MIN_VALUE, suffix = Long.MIN_VALUE, leftSum = 0, rightSum = 0;

        for(int i = 0, j = arr.length - 1; i < arr.length; j--, i++){
            leftSum = (leftSum + arr[i]) % 1_000_000_007;
            rightSum = (rightSum + arr[j]) % 1_000_000_007;
            prefix = Math.max(prefix, leftSum);
            suffix = Math.max(suffix, rightSum);
        }

        long mid = Math.max(leftSum, 0) * (k - 2) % 1_000_000_007;
        return (int) Math.max((prefix + suffix + mid) % 1_000_000_007, maxSubarray(arr));
    }

    public static int maxSubarray(int[] arr){
        int sum = 0, max = Integer.MIN_VALUE;
        for(int i : arr){
            sum = Math.max(sum, 0) + i;
            max = Math.max(sum, max);
        }
        return max;
    }
}

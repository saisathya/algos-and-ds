package sliding_window;

import java.util.*;

public class Problems {

    /**
     * Find the maximum sum of contiguous subarray of size k
     */
    public static int problem1(int[] arr, int k){
        if(arr == null || arr.length < k || k < 0)
            return 0;

        int sum = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(i >= k){
                sum -= arr[i - k];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    /**
     *  Find smallest contiguous subarray whose sum is greater than or equal to S
     */
    public static int problem2(int[] arr, int S){
        if(arr == null || arr.length == 0)
            return 0;
        int left = 0, sum = 0, min = Integer.MAX_VALUE;

        for(int right = 0; right < arr.length; right++){
            sum += arr[right];

            while(sum >= S){
                min = Math.min(min, right - left + 1);
                sum -= arr[left];
                left++;
            }
        }
        return min;
    }

    /**
     * Find the longest substring with no more than K distinct characters
     */
    public static int problem3(String s, int k){
        if(s == null || s.length() < 0)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int left = 0;

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while(map.size() > k){
                char temp = s.charAt(left);
                map.put(temp, map.get(temp) - 1);
                if(map.get(temp) == 0)
                    map.remove(temp);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    /**
     * Given an array of chars, find the longest contiguous sequence of two unique character
     */
    public static int problem4(char[] chars){
        if(chars == null || chars.length == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, max = 0;

        for(; right < chars.length; right++){
            map.put(chars[right], map.getOrDefault(chars[right], 0) + 1);

            while(map.size() > 2){
                map.put(chars[left], map.get(chars[left]) - 1);
                if(map.get(chars[left]) == 0)
                    map.remove(chars[left]);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    /**
     * Given a string, find the longest substring with unique characters
     */
    public static int problem5(String s){
        if(s == null || s.length() == 0)
            return 0;

        int left = 0, right = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(; right < s.length(); right++){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while(map.size() != (right - left + 1)){
                c = s.charAt(left);
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0)
                    map.remove(c);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    /**
     * Find the longest length of substring with the same character with no more than k changes
     */
    public static int problem6(String s, int k){
        if(s == null || s.length() == 0)
            return 0;

        int left = 0, right = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(; right < s.length(); right++){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while((right - left + 1) - map.get(s.charAt(left))   > k){
                c = s.charAt(left);
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0)
                    map.remove(c);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    /**
     * Find the longest contiguous subarray with all 1s given a binary subarray. Allowed up to k changes
     */
    public static int problem7(int[] arr, int k){
        if(arr == null || arr.length == 0)
            return 0;

        int ones = 0, left = 0, right = 0, max = 0;
        for(; right < arr.length; right++){
            if(arr[right] == 1) ones++;

            while((right - left + 1) - ones > k){
                if(arr[left] == 1) ones--;
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    /**
     * Given a string and a pattern, find if a permutation of the pattern exists in the string
     */
    public static int problem8(String s, String pat){
        return 0;
    }
}

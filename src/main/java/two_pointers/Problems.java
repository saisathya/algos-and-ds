package two_pointers;

import java.util.*;

public class Problems {

    /**
     * Given a sorted array and a target, find two values that add up to it
     */
    public static int[] problem1(int[] arr, int target){
        if(arr == null || arr.length < 2)
            return new int[]{-1, -1};
        int left = 0, right = arr.length - 1;

        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == target){
                return new int[]{left, right};
            }
            if(sum < target)
                left++;
            else
                right--;
        }

        return new int[]{-1, -1};
    }

    /**
     * Remove all duplicates in a sorted array and return new length of the array
     */
    public static int problem2(int[] array){
        if(array == null || array.length == 0)
            return 0;

        int write = 0;
        for(int i = 1; i < array.length; i++){
            if(array[i] != array[i - 1]){
                write++;
                array[write] = array[i];
            }
        }

        return write + 1;
    }

    /**
     * Given a sorted array with -inf < a[i] < inf, return the squares in sorted order
     */
    public static int[] problem3(int[] array){
        if(array == null || array.length == 0)
            return array;

        int left = 0, right = array.length - 1, write = array.length - 1;
        int[] res = new int[array.length];

        while(left < right){
            if(Math.abs(array[left]) > Math.abs(array[right])){
                res[write] = array[left] * array[left];
                left++;
            }
            else{
                res[write] = array[right] * array[right];
                right--;
            }
            write--;
        }

        return res;
    }

    /**
     * Given a list of unsorted integers, find all triplets that add up to zero
     */
    public static List<List<Integer>> problem4(int[] array){
        if(array == null || array.length < 3)
            return new ArrayList<>();
         Arrays.sort(array);
        Set<List<Integer>> output = new HashSet<>();
        for(int i = 0; i < array.length; i++){
            problem4_helper(array, i , output);
        }
        return new ArrayList<>(output);
    }

    public static void problem4_helper(int[] array, int i, Set<List<Integer>> output){
        int target = -array[i];
        int left = i + 1, right = array.length - 1;
        while(left < right){
            if(array[left] + array[right] == target){
                output.add(Arrays.asList(array[i], array[left], array[right]));
                left++;
                right--;
            }
            else if(array[left] + array[right] < target)
                left++;
            else
                right--;
        }
    }

    public static int problem5(int[] arr, int target) throws IllegalArgumentException {
        if(arr == null || arr.length < 3)
            throw new IllegalArgumentException();
        int closestVal = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            int left = i + 1, right = arr.length - 1;
            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];
                if(Math.abs(sum - target) < Math.abs(closestVal - target))
                    closestVal = sum;
                if(sum == target){
                    return target;
                }
                else if(sum < target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return closestVal;
    }

}

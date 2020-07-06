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

    /**
     * Find all contiguous subarray with product lest that target
     */
    public static List<List<Integer>> problem6(int[] arr, int target){
        if(arr == null || target < 0)
            throw new IllegalArgumentException();
        LinkedList<Integer> list = new LinkedList<>();
        HashSet<List<Integer>> result = new HashSet<>();
        int left = 0, right = 0, prod = 1;

        for( ; right < arr.length; right++){
            if(arr[right] < target)
                result.add(Arrays.asList(arr[right]));
            prod *= arr[right];
            list.add(arr[right]);
            while(prod >= target){
                prod /= arr[left];
                left++;
                list.removeFirst();
            }
            result.add(new ArrayList<>(list));
        }
        return new ArrayList<>(result);
    }

    /**
     * Given an array with 0s, 1s, 2s, sort them in place
     */
    public static void problem7(int[] arr) {
        if (arr == null)
            throw new IllegalArgumentException();
        int left = 0, right = arr.length - 1, i = 0;

        while(i <= right){
            if(arr[i] == 0){
                swap(arr, left, i);
                i++;
                left++;
            }
            else if(arr[i] == 1){
                i++;
            }
            else{
                swap(arr, right, i);
                right--;
            }
        }
    }

    public static void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Given two strings with backspace character represented with '#', check if they are the same
     */
    public static boolean problem8(String s1, String s2){
        if(s1 == null || s2 == null)
            throw new IllegalArgumentException();
        int one = s1.length() - 1, two = s2.length() - 1, skip1 = 0, skip2 = 0;

        while(one >= 0 && two >= 0){
            if(s1.charAt(one) == '#'){
                one--;
                skip1++;
            }
            else if(skip1 > 0){
                one--;
                skip1--;
            }
            if(s2.charAt(two) == '#'){
                two--;
                skip2++;
            }
            else if(skip2 > 0){
                two--;
                skip2--;
            }
            if(skip1 == 0 && skip2 == 0){
                if(s1.charAt(one) != s2.charAt(two)) return false;
                one--;
                two--;
            }
        }
        return one == -1 && two == -1;
    }

    public static int problem9(int[] arr){
        if(arr == null)
            throw new IllegalArgumentException();
        if(arr.length == 0) return 0;

        int right = arr.length - 1;
        for(; right > 0; right--){
            if(arr[right] < arr[right - 1]) break;
        }
        if(right == 0)
            return 0;
        int left = 0;
        for(; left < right; left++){
            if(arr[right] < arr[left] || arr[left] > arr[left + 1])
                break;

        }
        return right - left + 1;
    }
}

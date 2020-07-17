package cyclic_sort;

import java.util.*;

public class Problems {
    /**
     * Given an array containing objects 1...n, n being the size of the array. Sort it in place.
     */
    public static int[] problem1(int[] arr){
        if(arr == null || arr.length ==  0)
            return arr;

        int i = 0;
        while(i < arr.length){
            int temp = arr[i] - 1;
            if(arr[i] == arr[temp])
                i++;
            else{
                swap(arr, i, arr[i] - 1);
            }
        }
        return arr;
    }

    /**
     * Given an array size n, it has distinct values from 0...n. Find the missing integer
     */
    public static int problem2(int[] arr){
        if(arr == null)
            return -1;
        int idx = -1;
        int i = 0;
        while(i < arr.length){
            if(arr[i] == arr.length){
                idx = i;
                i++;
            }
            else if(arr[i] == i)
                i++;
            else
                swap(arr, i, arr[i]);
        }
        return (idx == -1)? arr.length : idx;
    }

    /**
     * Given an array containing values from 1...n, n being the size. Find the missing values if it may contain
     * duplicates
     */
    public static List<Integer> problem3(int[] arr){
        if(arr == null || arr.length == 0)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while(i < arr.length){
            if(arr[i] - 1 == i || arr[arr[i] - 1] == arr[i])
                i++;
            else
                swap(arr, i, arr[i] - 1);
        }
        for(int j = 0; j < arr.length; j++){
            if(arr[j] - 1 != j)
                result.add(j + 1);
        }
        return result;
    }

    /**
     * Given an array containing values from 1 to n, with n + 1 being the size of the array
     * Find the duplicate, only one value is duplicated
     */

    public static int problem4(int[] arr){
        if(arr == null || arr.length == 0)
            return -1;
        int i = 0;
        while(i < arr.length){
            if(arr[i] - 1 == i){
                i++;
            }
            else if(arr[arr[i] - 1] == arr[i])
                return arr[i];
            else
                swap(arr, arr[i] - 1, i);
        }

        return -1;
    }

    /**
     * You are given an array with values from 1...n with n being the size of the array
     * One value has been duplicated exactly once, while another is missing
     * Find both of these values
     */
    public static int[] problem5(int[] arr){
        if(arr == null || arr.length == 0)
            return new int[]{-1 , -1};
        int i = 0;
        int[] output = new int[]{-1, -1};
        while(i < arr.length){
            if(arr[i] - 1 == i)
                i++;
            else if(arr[arr[i] - 1] == arr[i]){
                output[0] = arr[i];
                output[1] = i + 1;
                i++;
            }
            else
                swap(arr, arr[i] - 1, i);
        }
        return output;
    }

    /**
     * Given a unsorted array of UNIQUE numbers, find the first missing smallest integer
     */
    public static int problem6(int[] arr){
        if(arr == null || arr.length == 0)
            return -1;

        int i = 0;
        while(i < arr.length){
            if(arr[i] - 1 == i || arr[i] > arr.length || arr[i] <= 0)
                i++;
            else
                swap(arr, arr[i] - 1, i);
        }
        for(int j = 0; j < arr.length; j++){
            if(arr[j] - 1 != j)
                return j + 1;
        }
        return arr.length + 1;
    }

    private static void swap(int[] a, int i , int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

package cyclic_sort;

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

    private static void swap(int[] a, int i , int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

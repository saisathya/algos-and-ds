package binary_search;

public class Problems {

    /**
     * Given an array sorted in either ascending or descending, return the index of a target value
     */
    public static int problem1(int[] arr, int k){
        if(arr == null || arr.length == 0)
            return -1;
        return problem1_helper(arr, k, 0, arr.length - 1);
    }

    public static int problem1_helper(int[] arr, int k, int start, int end){
        if(start > end)
            return -1;

        int mid = (start + end) / 2;
        if(arr[mid] == k)
            return mid;
        else if(k < arr[mid]){
            if(mid != end &&  arr[mid + 1] <= arr[mid])
                return problem1_helper(arr, k, mid + 1, end);
            else
                return problem1_helper(arr, k , start, mid - 1);
        }
        else{
            if(mid != end && arr[mid + 1] >= arr[mid])
                return problem1_helper(arr, k, mid + 1, end);
            else
                return problem1_helper(arr, k, start, mid - 1);
        }
    }

    public static int problem1_alt(int[] arr, int k){
        if(arr == null || arr.length == 0)
            return -1;

        int left = 0, right = arr.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] == k)
                return mid;
            else if(k < arr[mid]){
                if(mid != right && arr[mid] > arr[mid + 1])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            else{
                if(mid != right && arr[mid + 1] > arr[mid])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Given a sorted list of unique, get the ceiling of a target, which can be either itself or the smallest number greater than the target
     */
    public static int problem2(int[] arr, int k){
        if(arr == null || arr.length == 0)
            return -1;
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] == k)
                return k;
            if(k > arr[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        if(left < arr.length)
            return arr[left];
        return -1;
    }
}

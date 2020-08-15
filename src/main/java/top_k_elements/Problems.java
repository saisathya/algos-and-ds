package top_k_elements;

import java.util.*;

public class Problems {
    /**
     * Given an unsorted array, return the K largest elements
     */
    public static List<Integer> problem1(int[] arr, int k){
        if(arr == null || arr.length == 0 || k < 0)
            return new ArrayList<>();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++){
            if(minHeap.size() < k)
                minHeap.offer(arr[i]);
            else if(arr[i] >= minHeap.peek())
                minHeap.offer(arr[i]);

            if(minHeap.size() > k)
                minHeap.poll();
        }

        return new ArrayList<>(minHeap);
    }

    /**
     * Given a list, find the k-th smallest number
     */
    public static int problem2(int[] arr, int k){
        if(arr == null || arr.length < k)
            throw new IllegalArgumentException();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < arr.length; i++){
            if(maxHeap.size() < k || arr[i] < maxHeap.peek())
                maxHeap.offer(arr[i]);
            if(maxHeap.size() > k)
                maxHeap.poll();
        }
        return maxHeap.peek();
    }

    /**
     * You are given a list of x,y coordinates, find the k closest points to the origin
     */
    public static List<int[]> problem3(int[][] arr, int k){
        if(arr == null || arr.length == 0 || k < 0)
            return new ArrayList<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> problem3_helper(b, a));

        for(int i = 0; i < arr.length; i++){
            if(minHeap.size() < k)
                minHeap.offer(arr[i]);
            else if(problem3_helper(arr[i], minHeap.peek()) < 0){
                minHeap.offer(arr[i]);
                minHeap.poll();
            }
        }

        return new ArrayList<>(minHeap);
    }

    public static int problem3_helper(int[] a, int[] b){
        int distA = a[0] * a[0] + a[1] * a[1];
        int distB = b[0] * b[0] + b[1] * b[1];
        return Integer.compare(distA, distB);
    }
}

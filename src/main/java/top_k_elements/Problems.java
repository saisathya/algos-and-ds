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

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> problem3_helper(b, a));

        for(int i = 0; i < arr.length; i++){
            if(maxHeap.size() < k)
                maxHeap.offer(arr[i]);
            else if(problem3_helper(arr[i], maxHeap.peek()) < 0){
                maxHeap.offer(arr[i]);
                maxHeap.poll();
            }
        }

        return new ArrayList<>(maxHeap);
    }

    public static int problem3_helper(int[] a, int[] b){
        int distA = a[0] * a[0] + a[1] * a[1];
        int distB = b[0] * b[0] + b[1] * b[1];
        return Integer.compare(distA, distB);
    }

    /**
     * You are given a list that denotes the lengths of ropes. You connect the ropes to make one long string.
     * Each connection comes with a cost, which is the sum of the length of two ropes. Find the minimum cost to connect
     * all ropes.
     */
    public static int problem4(int[] arr){
        if(arr == null || arr.length == 0)
            return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i : arr) minHeap.offer(i);
        int sum = 0;
        while(minHeap.size() > 1){
            int a = minHeap.poll();
            int b = minHeap.poll();
            sum = sum + a + b;
            minHeap.offer(a + b);
        }
        return sum;
    }

    /**
     * given a list with non-unique elements, get the top k frequent elements
     */
    public static List<Integer> problem5(int[] arr, int k){
        if(arr == null || arr.length == 0 || k < 0)
            return new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Map.Entry.comparingByValue());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(minHeap.size() < k)
                minHeap.offer(entry);
            else if(minHeap.peek().getValue() < entry.getValue()){
                minHeap.offer(entry);
                minHeap.poll();
            }
        }
        List<Integer> output = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iter = minHeap.iterator();
        while(iter.hasNext())
            output.add(iter.next().getKey());

        return output;
    }

    /**
     * give a string of lower case alphabets, return the new string that sorts the alphabets in decreasing frequency
     */
    public static String problem6(String s){
        if(s == null || s.length() == 0)
            return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) +  1);
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (e1, e2) -> e1.getValue() == e2.getValue() ? Character.compare(e1.getKey(), e2.getKey()) : Integer.compare(e2.getValue(), e1.getValue()));

        maxHeap.addAll(map.entrySet());

        StringBuilder output = new StringBuilder();
        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for(int i = 0; i < entry.getValue(); i++)
                output.append(entry.getKey());
        }
        return output.toString();
    }

    /**
     * Design a class that takes in a stream of numbers and returns the K-th largest value
     */
    public static class Problem7{
        PriorityQueue<Integer> leftHalf, rightHalf;
        int k;

        public Problem7(int[] arr, int k){
            this.k = k;
            leftHalf = new PriorityQueue<>(Comparator.reverseOrder());
            rightHalf = new PriorityQueue<>();

            for(int i = 0; i < arr.length; i++)
                add(arr[i]);
        }

        public int add(int val){
            if(rightHalf.size() <= k || val > rightHalf.peek())
                rightHalf.offer(val);
            else
                leftHalf.offer(val);

            if(rightHalf.size() > k)
                leftHalf.offer(rightHalf.poll());

            return rightHalf.peek();
        }
    }
}

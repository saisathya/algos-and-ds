package k_way_merge;

import java.util.*;

public class Problems {

    /**
     * Given an array of k sorted linked list, merge them to a new linked list and return the head
     */
    public static ListNode problem1(ListNode[] lists){
        if(lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> minheap = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));

        for(int i = 0; i < lists.length; i++){
            ListNode list = lists[i];
            if(list != null)
                minheap.offer(list);
        }

        ListNode output =  new ListNode(-1);
        ListNode curr = output;
        while(!minheap.isEmpty()){
            ListNode listNode = minheap.poll();
            if(listNode.next != null)
                minheap.offer(listNode.next);
            curr.next = listNode;
            curr = curr.next;
        }

        return output.next;
    }

    /**
     * Given M sorted arrays, find the k-th smallest number
     */
    public static int problem2(ListNode[] lists, int k){
        if(lists == null || lists.length == 0 || k <= 0)
            throw new IllegalArgumentException();

        PriorityQueue<ListNode> minheap = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));

        for(ListNode list : lists){
            if(list != null)
                minheap.offer(list);
        }
        int i = 0;
        ListNode list = null;
        while(i < k && !minheap.isEmpty()){
            list = minheap.poll();
            if(list.next != null)
                minheap.offer(list.next);
            i++;
        }
        return list.value;
    }

    /**
     * You are given a N * M matrix, whereby each row is sorted in ascending order. Find the the k-th smallest number
     */
    public static int problem3(int[][] matrix, int k){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0)
            throw new IllegalArgumentException();

        int row = matrix.length, col = matrix[0].length;
        if(k >= row * col)
            return matrix[row - 1][col - 1];

        PriorityQueue<Node> minheap = new PriorityQueue<Node>((a, b) -> Integer.compare(matrix[a.row][a.col], matrix[b.row][b.col]));

        for(int i = 0; i < row; i++)
            minheap.offer(new Node(i, 0));

        int count = 0;
        Node node = null;
        while(count < k && !minheap.isEmpty()){
            node = minheap.poll();
            if(node.col + 1 < col)
                minheap.offer(new Node(node.row, node.col + 1));
            count++;
        }

        return matrix[node.row][node.col];
    }

    /**
     * You are given a List of k-sorted integer arrays. Find the smallest range such that the range encompasses values present at all three arrays
     */
    public static int[] problem4(List<int[]> lists){
        if(lists == null)
            return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] output = null;

        PriorityQueue<Node> minheap = new PriorityQueue<>((a, b) -> Integer.compare(lists.get(a.row)[a.col], lists.get(b.row)[b.col]));
        int currMax = Integer.MIN_VALUE;
        for(int i = 0; i < lists.size(); i++){
            if(lists.get(i).length > 0){
                minheap.offer(new Node(i, 0));
                currMax = Math.max(currMax, lists.get(i)[0]);
            }
        }

        while(minheap.size() >= lists.size()){
            Node min = minheap.poll();

            if(output == null || currMax - lists.get(min.row)[min.col] < output[1] - output[0])
                output = new int[]{lists.get(min.row)[min.col], currMax};

            if(min.col + 1 < lists.get(min.row).length){
                minheap.offer(new Node(min.row, min.col + 1));
                currMax = Math.max(currMax, lists.get(min.row)[min.col + 1]);
            }
        }
        return output;
    }

    /**
     * You are given to arrays sorted in descenging order, your goal is to find k-pairs that is has the largest sum
     */
    public static List<int[]> problem5(int[] arr1, int[] arr2, int k){
        if(arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0 || arr1.length * arr2.length < k || k <= 0)
            throw new IllegalArgumentException();

        int len1 = Math.min(k , arr1.length);
        int len2 = Math.min(k, arr2.length);
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> Integer.compare(a[0] + a[1], b[0] + b[1]));

        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(minheap.size() < k)
                    minheap.offer(new int[]{arr1[i], arr2[j]});
                else if(arr1[i] + arr2[j] > minheap.peek()[0] + minheap.peek()[1]){
                    minheap.offer(new int[]{arr1[i], arr2[j]});
                    minheap.poll();
                }
            }
        }
        return new ArrayList<>(minheap);
    }

    private static class Node{
        int row, col;
        Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}

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
        PriorityQueue<Integer> minHeap;
        int k;

        public Problem7(int[] arr, int k){
            this.k = k;
            minHeap = new PriorityQueue<>();

            for(int i = 0; i < arr.length; i++)
                add(arr[i]);
        }

        public int add(int val){
            if(minHeap.size() <= k || val > minHeap.peek())
                minHeap.offer(val);

            if(minHeap.size() > k)
                minHeap.poll();

            return minHeap.peek();
        }
    }

    /**
     * Given a sorted array of numbers, k-closest values to another number x, assume integers are unique
     */
    public static int[] problem8(int[] arr, int k, int x){
        if(arr == null || arr.length <= k)
            return arr;
        int left = 0, right = arr.length - 1;
        int idx = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == x){
                idx = mid;
                break;
            }
            idx = mid;
            if(x < arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(Math.abs(a - x), Math.abs(b - x)));
        int start = Math.max(0, idx - k + 1);
        int end = Math.min(arr.length - 1, idx + k - 1);
        for(int i = start; i <= end; i++)
            minHeap.offer(arr[i]);

        int[] output = new int[k];
        for(int i = 0; i < output.length; i++)
            output[i] = minHeap.poll();
        Arrays.sort(output);
        return output;
    }

    /**
     * You are given an array of integers. You have to remove a maximum of K numbers, in order to obtain
     * an array with the most unique numbers
     */
    public static int problem9(int[] arr, int k){
        if(arr == null || arr.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));
        minHeap.addAll(map.entrySet());

        int removed = 0;
        int uniqueCount = 0;
        while(!minHeap.isEmpty() && removed < k){
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            if(entry.getValue() == 1)
                uniqueCount++;
            else{
                entry.setValue(entry.getValue() - 1);
                minHeap.offer(entry);
                removed++;
            }
        }

        return uniqueCount - (k - removed);
    }

    /**
     * Given an array, find the sum of the values between the i-th (exclusive) and j-th exclusive smallest element
     */
    public static int problem10(int[] arr, int I, int J){
        if(arr == null || J < I || J - I + 1 > arr.length)
            throw new IllegalArgumentException();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i : arr){
            if(maxHeap.size() < J || i < maxHeap.peek())
                maxHeap.offer(i);
            if(maxHeap.size() >= J)
                maxHeap.poll();
        }
        int sum = 0;
        while(maxHeap.size() > I)
            sum += maxHeap.poll();
        return sum;
    }

    /**
     * You are given a String, return a string such that no two adjacent characters are the same. If such string is not possible, return an empty string
     */
    public static String problem11(String s){
        if(s == null || s.isEmpty())
            return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        maxHeap.addAll(map.entrySet());

        StringBuilder output = new StringBuilder();
        Map.Entry<Character, Integer> prev = null;
        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> curr = maxHeap.poll();
            if(prev != null && prev.getValue() > 0)
                maxHeap.offer(prev);
            output.append(curr.getKey());
            curr.setValue(curr.getValue() - 1);
            prev = curr;
        }

        return (s.length() == output.length())? output.toString() : "";
    }

    /**
     * Given a string and an integer k, find if we can rearrange the string such that all same characters are at least k positions apart
     */
    public static String problem12(String s, int k){
        if(s == null || s.length() == 0)
            return s;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        maxHeap.addAll(map.entrySet());

        LinkedList<Map.Entry<Character, Integer>> prevEntries = new LinkedList<>();
        StringBuilder output = new StringBuilder();
        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            if(prevEntries.size() == k && prevEntries.getFirst().getValue() > 0)
                maxHeap.offer(prevEntries.removeFirst());

            output.append(entry.getKey());
            entry.setValue(entry.getValue() - 1);
            prevEntries.add(entry);
        }

        return (output.length() == s.length())? output.toString() : "";
    }

    /**
     * You are given a list of tasks and an interval. Once a task is run, it has to wait for at least k intervals to run again.
     * Find the minimum number of intervals required to finish all tasks
     */
    public static int problem13(char[] tasks, int k){
        if(tasks == null || tasks.length == 0)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : tasks)
            map.put(c, map.getOrDefault(c, 0) + 1);
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        maxHeap.addAll(map.entrySet());

        LinkedList<Map.Entry<Character, Integer>> list = new LinkedList<>();
        int count = 0, tasksRemoved = 0;
        while(tasksRemoved < map.size()){
            count++;
            if(maxHeap.isEmpty())
                list.addFirst(null);
            else{
                Map.Entry<Character, Integer> entry = maxHeap.poll();
                if(entry.getValue() > 1)
                    list.addFirst(entry);
                else{
                    tasksRemoved++;
                    list.addFirst(null);
                }
            }
            if(list.size() > k){
                Map.Entry<Character, Integer> entry = list.removeLast();
                if(entry != null){
                    entry.setValue(entry.getValue() - 1);
                    maxHeap.offer(entry);
                }
            }
        }

        return count;
    }

    /**
     * Implement a stack with the two following operatons
     * pop: returns the element with the most frequency in the stack. If two items are tied, return the number  that was added the latest
     * push: push an item into the stack
     */
    public static class Problem14{
        Map<Integer, Node> map = new HashMap<>();
        PriorityQueue<Node> maxHeap = new PriorityQueue<>(
                (a, b) -> a.list.size() == b.list.size()? Integer.compare(b.list.peekLast(), a.list.peekLast()) : Integer.compare(b.list.size(), a.list.size()));
        int order = 0;
        public void push(int num){
            Node n;

            if(!map.containsKey(num)){
                n = new Node(num);
                map.put(num, n);
            }
            else{
                n = map.get(num);
                maxHeap.remove(n);
            }
            n.add(order);
            maxHeap.offer(n);
            order++;
        }

        public int pop(){
            Node n = maxHeap.poll();
            if(n.remove()){
                map.remove(n.val);
            }
            else{
                maxHeap.offer(n);
            }
            return n.val;
        }

        class Node {
            int val;
            LinkedList<Integer> list;
            Node(int val){
                this.val = val;
                this.list = new LinkedList<>();
            }

            void add(int order){
                this.list.addLast(order);
            }

            boolean remove(){
                this.list.removeLast();
                return this.list.isEmpty();
            }

            @Override
            public boolean equals(Object o){
                Node n = (Node) o;
                return val == n.val;
            }
        }
    }
}

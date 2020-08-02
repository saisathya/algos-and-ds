package two_heaps;

import java.util.*;

public class Problems {
    /**
     * Design a class that helps find the median of an input stream
     */
    public static class Problem1{
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); // max heap
        PriorityQueue<Integer> right = new PriorityQueue<>(); // min heap

        public void insert(int num){
            if(right.isEmpty() || num >= right.peek())
                right.offer(num);
            else left.offer(num);

            if(right.size() - left.size() > 1)
                left.offer(right.poll());
            else if(left.size() > right.size())
                right.offer(left.poll());
        }

        public double findMedian(){
            if(left.size() == right.size())
                return (left.peek() + right.peek()) * 1.0 / 2;
            return right.peek();
        }
    }

    /**
     * Given an unsorted array and an integer k, find the median of all sublists size k
     */
    public static class Problem2{
        PriorityQueue<Integer> leftHalf, rightHalf;

        public List<Double> problem2(int[] arr, int k){
            leftHalf = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            rightHalf = new PriorityQueue<>();
            if(arr == null || k <= 0)
                return new ArrayList<>();

            List<Double> output = new ArrayList<Double>();
            int left = 0, right = 0;
            for(; right < arr.length; right++){
                insert(arr[right]);
                if(right >= k - 1){
                    output.add(getMedian());
                    remove(arr[left]);
                    left++;
                }
            }
            return output;
        }

        private void insert(int num){
            if(rightHalf.isEmpty() || num >= rightHalf.peek())
                rightHalf.offer(num);
            else leftHalf.offer(num);

            if(rightHalf.size() - leftHalf.size() > 1)
                leftHalf.offer(rightHalf.poll());
            else if(leftHalf.size() > rightHalf.size())
                rightHalf.offer(leftHalf.poll());
        }

        private void remove(int num){
            if(leftHalf.size() == rightHalf.size()){
                if(num <= leftHalf.peek())
                    leftHalf.remove(num);
                else{
                    rightHalf.remove(num);
                    rightHalf.offer(leftHalf.poll());
                }
            }
            else{
                if(num <= leftHalf.peek()){
                    leftHalf.remove(num);
                    leftHalf.offer(rightHalf.poll());
                }
                else{
                    rightHalf.remove(num);
                }
            }
        }

        private double getMedian(){
            if(leftHalf.size() == rightHalf.size())
                return leftHalf.peek() / 2.0 + rightHalf.peek() / 2.0;
            return rightHalf.peek();
        }
    }

    public static int problem3(int[] costs, int[] profits, int amount, int projects){
        if(costs == null || profits == null || amount < 0 || projects < 0 || projects > costs.length || profits.length != costs.length){
            return 0;
        }

        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> Integer.compare(profits[b], profits[a]));
        PriorityQueue<Integer> right = new PriorityQueue<>();

        for(int i = 0; i < costs.length; i++){
            if(costs[i] > amount)
                right.offer(costs[i]);
            else
                left.offer(costs[i]);
        }

        int i = 0;
        while(i < projects && !left.isEmpty()){
            amount += profits[left.poll()];
            while(!right.isEmpty() && right.peek() <= amount){
                left.offer(right.poll());
            }
            i++;
        }

        return amount;
    }

    public static int[] problem4(Interval[] intervals){
        if(intervals == null || intervals.length == 0)
            return new int[0];
        int[] output = new int[intervals.length];

        PriorityQueue<Interval> start = new PriorityQueue<>((a, b) -> Integer.compare(b.start, a.start));
        PriorityQueue<Interval> end = new PriorityQueue<>((a, b) -> Integer.compare(b.end, a.start));


        return output;
    }
}

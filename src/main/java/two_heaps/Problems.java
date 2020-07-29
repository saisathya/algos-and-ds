package two_heaps;

import java.util.*;

public class Problems {
    /**
     * Design a class that helps find the median of an input stream
     */
    public static class Problem1{
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> right = new PriorityQueue<>();

        public void insert(int num){
            if(left.size() == right.size()){
                if(!left.isEmpty() && num <= left.peek()){
                    left.offer(num);
                    right.offer(left.poll());
                }
                else right.offer(num);
            }
            else{
                if(!left.isEmpty() && num <= left.peek())
                    left.offer(num);
                else{
                    right.offer(num);
                    left.offer(right.poll());
                }
            }
        }

        public double findMedian(){
            if(left.size() == right.size())
                return (left.peek() + right.peek()) * 1.0 / 2;
            return right.peek();
        }
    }
}

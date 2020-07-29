package two_heaps;

import java.util.*;

public class Problems {
    /**
     * Design a class that helps find the median of an input stream
     */
    public static class Problem1{
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        public void insert(int num){
            if(left.isEmpty() && right.isEmpty())
                right.offer(num);
            else if(num >= right.peek() || left.size() == right.size()){
                right.offer(num);
                left.offer(right.poll());
            }
            else
                left.offer(num);
        }

        public double findMedian(){
            if(!left.isEmpty() && left.size() == right.size())
                return (left.peek() + right.peek()) * 1.0 / 2;
            return right.peek();
        }
    }
}

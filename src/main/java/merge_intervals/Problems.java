package merge_intervals;
import java.util.*;

public class Problems {

    /**
     * Given a list of intervals, merge overlapping intervals to produce a list of mutually exclusive intervals.
     * The given intervals are not sorted
     */
    public static List<Interval> problem1(List<Interval> intervals){
        if(intervals == null || intervals.size() <= 1)
            return intervals;

        Collections.sort(intervals);
        List<Interval> out = new ArrayList<>();
        out.add(new Interval(intervals.get(0).start, intervals.get(0).end));

        for(int i = 1; i < intervals.size(); i++){
            Interval last = out.get(out.size() - 1);
            Interval curr = intervals.get(i);

            if(curr.start <= last.end){
                last.end = Math.max(last.end, curr.end);
            }
            else {
                out.add(new Interval(curr.start, curr.end));
            }
        }

        return out;
    }

    /**
     * Given a list of sorted intervals, and a new interval, insert the new interval into the list and return a list of disjoint intervals
     */
    public static List<Interval> problem2(List<Interval> intervals, Interval interval){
        if(intervals == null || interval == null)
            return intervals;
        if(intervals.isEmpty())
            return Arrays.asList(interval);
        int i = 0;
        List<Interval> output = new ArrayList<>();
        while(i < intervals.size() && interval.start > intervals.get(i).end){
            Interval last = output.isEmpty()? null : output.get(output.size() - 1);
            if(last != null && intervals.get(i).start < last.end)
                last.end = Math.max(intervals.get(i).end, last.end);
            else
                output.add(intervals.get(i));
            i++;
        }
        if(output.isEmpty() || interval.start > output.get(output.size() - 1).end)
            output.add(interval);
        else{
            output.get(output.size() - 1).end = Math.max(output.get(output.size() - 1).end, interval.end);
        }
        while(i < intervals.size()){
            Interval last = output.get(output.size() - 1);
            if(intervals.get(i).start < last.end)
                last.end = Math.max(intervals.get(i).end, last.end);
            else
                output.add(intervals.get(i));
            i++;
        }
        return output;
    }

    /**
     * Given two lists of intervals, find the intersection of these two lists. Each list of interval consists of disjoint intervals
     */
    public static List<Interval> problem3(List<Interval> a, List<Interval> b){
        if(a == null || b == null || a.isEmpty() || b.isEmpty()){
            return new ArrayList<>();
        }
        List<Interval> output = new ArrayList<>();
        int idx_a = 0, idx_b = 0;
        while(idx_a < a.size() && idx_b < b.size()){
            Interval one = a.get(idx_a), two = b.get(idx_b);
            // if they are disjoint, increment the "smaller" interval
            if(one.end < two.start){
                idx_a++;
            }
            else if(two.end < one.start){
                idx_b++;
            }
            else{
                output.add(new Interval(Math.max(one.start, two.start), Math.min(one.end, two.end)));
                if(one.end <= two.end)
                    idx_a++;
                if(two.end <= one.end)
                    idx_b++;

            }
        }
        return output;
    }

    /**
     * Given an array of time intervals, determine if an individual can attend all of them
     */
    public static boolean problem4(Interval[] intervals){
        if(intervals == null || intervals.length == 0)
            return true;
        Arrays.sort(intervals);
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < intervals[i-1].end)
                return false;
        }
        return true;
    }

    /**
     * Given a list of time intervals, determine the number of rooms required to hold all the meetings
     */
    public static int problem5(List<Interval> intervals){
        if(intervals == null || intervals.isEmpty())
            return 0;
        Collections.sort(intervals);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < intervals.size(); i++){
            if(minHeap.isEmpty())
                minHeap.add(intervals.get(i).end);
            else if(intervals.get(i).start < minHeap.peek()){

            }
        }
    }
}

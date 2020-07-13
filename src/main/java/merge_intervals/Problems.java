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

            if(curr.start < last.end){
                last.end = Math.max(last.end, curr.end);
            }
            else {
                out.add(new Interval(curr.start, curr.end));
            }
        }

        return out;
    }
}

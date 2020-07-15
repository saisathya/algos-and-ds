package merge_intervals;

public class Interval implements Comparable<Interval>{
    int start, end;

    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }

    public int compareTo(Interval other){
        if(this.start == other.start){
            return Integer.compare(this.end, other.end);
        }
        return Integer.compare(this.start, other.start);
    }

    @Override
    public boolean equals(Object o){
        Interval i = (Interval) o;
        return i.start == start && i.end == end;
    }

    @Override
    public String toString(){
        return "[" + start +", " + end + "]";
    }
}

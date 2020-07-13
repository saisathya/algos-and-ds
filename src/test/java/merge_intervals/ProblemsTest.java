package merge_intervals;

import org.junit.Test;

import java.net.PortUnreachableException;
import java.util.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ProblemsTest {

    @Test
    public void problem1(){
        assertThat(Problems.problem1(Arrays.asList(new Interval(1, 4), new Interval(2, 5), new Interval(7, 9))), contains(new Interval(1, 5), new Interval(7, 9)));
        assertThat(Problems.problem1(Arrays.asList(new Interval(6, 7), new Interval(2, 4), new Interval(5, 9))), contains(new Interval(2, 4), new Interval(5, 9)));
        assertThat(Problems.problem1(Arrays.asList(new Interval(1, 4), new Interval(2, 6), new Interval(3, 5))), contains(new Interval(1, 6)));
    }
}
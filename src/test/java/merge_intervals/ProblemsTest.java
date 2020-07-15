package merge_intervals;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ProblemsTest {

    @Test
    public void problem1(){
        assertThat(Problems.problem1(Arrays.asList(new Interval(1, 4), new Interval(2, 5), new Interval(7, 9))), hasItems(new Interval(1, 5), new Interval(7, 9)));
        assertThat(Problems.problem1(Arrays.asList(new Interval(6, 7), new Interval(2, 4), new Interval(5, 9))), hasItems(new Interval(2, 4), new Interval(5, 9)));
        assertThat(Problems.problem1(Arrays.asList(new Interval(1, 4), new Interval(2, 6), new Interval(3, 5))), hasItems(new Interval(1, 6)));
    }

    @Test
    public void problem2(){
        assertThat(Problems.problem2(Arrays.asList(new Interval(1,3), new Interval(5, 7), new Interval(8, 12)), new Interval(4, 6)), hasItems(new Interval(1, 3), new Interval(4,7), new Interval(8, 12)));
        assertThat(Problems.problem2(Arrays.asList(new Interval(1,3), new Interval(5, 7), new Interval(8, 12)), new Interval(4, 10)), hasItems(new Interval(1, 3), new Interval(4,12)));
        assertThat(Problems.problem2(Arrays.asList(new Interval(2, 3), new Interval(5, 7)), new Interval(1, 4)), hasItems(new Interval(1, 4), new Interval(5, 7)));
    }

    @Test
    public void problem3(){
        assertThat(Problems.problem3(Arrays.asList(new Interval(1,3), new Interval(5,6), new Interval(7,9)), Arrays.asList(new Interval(2, 3), new Interval(5, 7))), hasItems(new Interval(2, 3), new Interval(5,6), new Interval(7 , 7)));
        assertThat(Problems.problem3(Arrays.asList(new Interval(1,3), new Interval(5, 7), new Interval(9,12)), Arrays.asList(new Interval(5, 10))), hasItems(new Interval(5, 7), new Interval(9, 10)));
    }

    @Test
    public void problem4(){
        assertFalse(Problems.problem4(new Interval[]{new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)}));
        assertTrue(Problems.problem4(new Interval[]{new Interval(6, 7), new Interval(2, 4), new Interval(8, 12)}));
        assertFalse(Problems.problem4(new Interval[]{new Interval(4, 5), new Interval(2, 3), new Interval(3, 6)}));
    }
}
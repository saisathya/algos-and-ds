package two_heaps;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ProblemsTest {
    @Test
    public void problem1(){
        Problems.Problem1 p1 = new Problems.Problem1();
        p1.insert(3);
        assertEquals(3.0, p1.findMedian(), 0);
        p1.insert(1);
        assertEquals(2.0, p1.findMedian(), 0);
        p1.insert(5);
        assertEquals(3.0, p1.findMedian(), 0);
        p1.insert(4);
        assertEquals(3.5, p1.findMedian(), 0);
    }

    @Test
    public void problem2(){
        Problems.Problem2 p2 = new Problems.Problem2();
        assertThat(p2.problem2(new int[] { 1, 2, -1, 3, 5 }, 2), hasItems(1.5, 0.5, 1.0, 4.0));
        assertThat(p2.problem2(new int[] { 1, 2, -1, 3, 5 }, 3), hasItems(1.0, 2.0, 3.0));
    }

    @Test
    public void problem3(){
        assertEquals(6, Problems.problem3(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 1, 2));
        assertEquals(8, Problems.problem3(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 0, 3));
    }

    @Test
    public void problem4(){
        assertArrayEquals(new int[]{2, -1, -1}, Problems.problem4(new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) }));
    }
}
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
}
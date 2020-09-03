package topological_sort;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static topological_sort.Problems.*;
import java.util.*;

public class ProblemsTest {
    @Test
    public void testProblem1(){
        assertArrayEquals(array(3, 2, 0, 1), problem1(4, new int[][]{array(3, 2), array(3, 0), array(2, 0), array(2, 1)}));
        assertArrayEquals(array(4, 2, 0, 3, 1), problem1(5, new int[][]{array(4, 2), array(4, 3), array(2, 0), array(2, 1), array(3, 1)}));
        assertArrayEquals(array(5, 3, 0, 6, 2, 4, 1),
                problem1(7, new int[][]{array(6, 4), array(6, 2), array(5, 3), array(5, 4), array(3, 0), array(3, 1), array(3, 2),
                        array(4, 1)}));
    }

    @Test
    public void testProblem2(){
        assertTrue( problem2(4, new int[][]{array(3, 2), array(3, 0), array(2, 0), array(2, 1)}));
        assertTrue(problem2(5, new int[][]{array(4, 2), array(4, 3), array(2, 0), array(2, 1), array(3, 1)}));
        assertFalse(problem2(7, new int[][]{array(6, 4), array(6, 2), array(5, 3), array(5, 4), array(3, 0), array(3, 1), array(3, 2),
                        array(4, 1), array(1, 4)}));
    }
    static int[] array(int ...a){
       return a;
    }
}
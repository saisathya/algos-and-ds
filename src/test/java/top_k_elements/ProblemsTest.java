package top_k_elements;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static top_k_elements.Problems.*;
import static java.util.Arrays.*;

public class ProblemsTest {
    @Test
    public void testProblem1(){
        assertThat(problem1(new int[]{3, 1, 5, 12, 2, 11}, 3), containsInAnyOrder(5, 12, 11));
        assertThat(problem1(new int[]{5, 12, 11, -1, 12}, 3), containsInAnyOrder(12, 11, 12));
    }

    @Test
    public void testProblem2(){
        assertEquals(5, problem2(new int[]{1, 5, 12, 2, 11, 5}, 3));
        assertEquals(5, problem2(new int[]{1, 5, 2, 11, 5}, 4));
        assertEquals(11, problem2(new int[]{5, 12, 11, -1, 12}, 3));
    }

    @Test
    public void testProblem3(){
        assertThat(problem3(new int[][]{array(0, 1), array(3, 1), array(-1, -1), array(-4, 1), array(0, 0)}, 3),
                containsInAnyOrder(array(0,1), array(-1, -1), array(0, 0 )));
        assertThat(problem3(new int[][]{array(1, 2), array(1, 3)}, 1), containsInAnyOrder(array(1, 2)));
        assertThat(problem3(new int[][]{array(1, 3), array(3, 4), array(2, -1)}, 2), containsInAnyOrder(array(1, 3), array(2, -1)));
    }

    @Test
    public void testProblem4(){
        assertEquals(33, problem4(array(1, 3, 11, 5)));
        assertEquals(36, problem4(array(3, 4, 5, 6)));
        assertEquals(42, problem4(array(1, 3, 11, 5, 2)));
    }

    @Test
    public void testProblem5(){
        assertThat(problem5(array(1, 3, 5, 12, 11, 12, 11), 2), containsInAnyOrder(11, 12));
        assertThat(problem5(array(5, 12, 11, 3, 11), 2), anyOf(containsInAnyOrder(11, 12), containsInAnyOrder(11, 3), containsInAnyOrder(11, 5)));
    }


    private static int[] array(int ...nums){
        return nums;
    }

}
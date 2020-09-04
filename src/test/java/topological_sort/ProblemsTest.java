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
        assertTrue( problem2(4, array(array(3, 2), array(3, 0), array(2, 0), array(2, 1))));
        assertTrue(problem2(5, array(array(4, 2), array(4, 3), array(2, 0), array(2, 1), array(3, 1))));
        assertFalse(problem2(7, array(array(6, 4), array(6, 2), array(5, 3), array(5, 4), array(3, 0), array(3, 1), array(3, 2),
                        array(4, 1), array(1, 4))));
    }

    @Test
    public void testProblem3(){
        assertThat(problem3(3,array(array(0,1), array(1, 2))), containsInAnyOrder(Arrays.asList(0, 1, 2)));
        assertThat(
                problem3(4, array(array(3,2),array(3,0),array(2,0),array(2,1))),
                containsInAnyOrder(Arrays.asList(3,2,0,1), Arrays.asList(3,2,1,0)));
        assertThat(
                problem3(6, array(array(2, 5), array(0, 5), array(0, 4), array(1, 4), array(3, 2), array(1, 3))),
                containsInAnyOrder(
                        Arrays.asList(0, 1, 4, 3, 2, 5),
                        Arrays.asList(0, 1, 3, 4, 2, 5),
                        Arrays.asList(0, 1, 3, 2, 4, 5),
                        Arrays.asList(0, 1, 3, 2, 5, 4),
                        Arrays.asList(1, 0, 3, 4, 2, 5),
                        Arrays.asList(1, 0, 3, 2, 4, 5),
                        Arrays.asList(1, 0, 3, 2, 5, 4),
                        Arrays.asList(1, 0, 4, 3, 2, 5),
                        Arrays.asList(1, 3, 0, 2, 4, 5),
                        Arrays.asList(1, 3, 0, 2, 5, 4),
                        Arrays.asList(1, 3, 0, 4, 2, 5),
                        Arrays.asList(1, 3, 2, 0, 5, 4),
                        Arrays.asList(1, 3, 2, 0, 4, 5)));
    }

    @Test
    public void testProblem4(){
        assertEquals("bac", problem4(array("ba", "bc", "ac", "cab")));
        assertEquals("cab", problem4(array("cab", "aaa", "aab")));
        assertEquals("ywxz", problem4(array("ywx", "wz", "xww", "xz", "zyy", "zwz")));
    }

    @Test
    public void testProblem5(){
        assertTrue(problem5(array(1, 2, 3, 4), array(array(1, 2), array(2, 3), array(3, 4))));
        assertTrue(problem5(array(1, 2, 3, 4), array(array(1, 2), array(2, 3), array(2, 4))));
    }

    @Test
    public void testProblem6(){
        assertEquals(3, problem6(5, array(array(0, 1), array(1, 2), array(1, 3), array(2, 4))));

    }

    static int[] array(int ...a){
       return a;
    }

    static String[] array(String ...s){
        return s;
    }

    static int[][] array(int[] ...a){
        return a;
    }
}
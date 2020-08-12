package binary_search;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static binary_search.Problems.*;
import static java.util.Arrays.*;

public class ProblemsTest {
    @Test
    public void testProblem1(){
        assertEquals(2, problem1(new int[]{4, 6, 10}, 10));
        assertEquals(4, problem1(new int[]{1, 2, 3, 4, 5, 6, 7}, 5));
        assertEquals(0, problem1(new int[]{10, 6, 4}, 10));
        assertEquals(2, problem1( new int[]{10, 6, 4}, 4));
        assertEquals(-1, problem1(new int[]{10, 6, 4}, 3));
        assertEquals(-1, problem1(new int[]{10, 6, 4}, 5));
        assertEquals(-1, problem1(new int[]{4, 6, 10}, 3));
        assertEquals(-1, problem1(new int[]{4, 6, 10}, 5));

        assertEquals(2, problem1_alt(new int[]{4, 6, 10}, 10));
        assertEquals(4, problem1_alt(new int[]{1, 2, 3, 4, 5, 6, 7}, 5));
        assertEquals(0, problem1_alt(new int[]{10, 6, 4}, 10));
        assertEquals(2, problem1_alt( new int[]{10, 6, 4}, 4));
        assertEquals(-1, problem1_alt(new int[]{10, 6, 4}, 3));
        assertEquals(-1, problem1_alt(new int[]{10, 6, 4}, 5));
        assertEquals(-1, problem1_alt(new int[]{4, 6, 10}, 3));
        assertEquals(-1, problem1_alt(new int[]{4, 6, 10}, 5));
    }

    @Test
    public void testProblem2(){
        int[] arr = new int[]{1, 3, 5, 7, 7, 7, 7, 9};
        assertEquals(1, problem2(arr, -1));
        assertEquals(1, problem2(arr, 1));
        assertEquals(3, problem2(arr, 3));
        assertEquals(7, problem2(arr, 6));
        assertEquals(9, problem2(arr, 9));
        assertEquals(9, problem2(arr, 8));
        assertEquals(5, problem2(arr, 4));
        assertEquals(-1, problem2(arr, 10));

        assertEquals(6, problem2(new int[] { 4, 6, 10 }, 6));
        assertEquals(15, problem2(new int[] { 1, 3, 8, 10, 15 }, 12));
        assertEquals(-1, problem2(new int[] { 4, 6, 10 }, 17));
        assertEquals(4, problem2(new int[] { 4, 6, 10 }, -1));
    }
}
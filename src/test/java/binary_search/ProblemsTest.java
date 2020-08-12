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

    @Test
    public void testProblem3(){
        assertEquals('h', problem3(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
        assertEquals('c', problem3(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
        assertEquals('a', problem3(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
        assertEquals('a', problem3(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
    }

    @Test
    public void testProblem4(){
        assertArrayEquals(new int[]{1, 3}, problem4(new int[]{4, 6, 6, 6, 9}, 6));
        assertArrayEquals(new int[]{3, 3,}, problem4(new int[]{1, 3, 8, 10, 15}, 10));
        assertArrayEquals(new int[]{-1, -1}, problem4(new int[]{1, 3, 8, 10, 15}, 12));
    }

    @Test
    public void testProblem5(){
        ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
        assertEquals(6, problem5(reader, 16));
        assertEquals(-1, problem5(reader, 11));
        reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
        assertEquals(4, problem5(reader, 15));
        assertEquals(-1, problem5(reader, 200));
    }

    @Test
    public void testProblem6(){
        assertEquals(6, problem6(new int[] { 4, 6, 10 }, 6));
        assertEquals(10, problem6(new int[] { 1, 3, 8, 10, 15 }, 12));
        assertEquals(10, problem6(new int[] { 4, 6, 10 }, 17));
        assertEquals(4, problem6(new int[] { 4, 6, 10 }, -1));
    }

    @Test
    public void testProblem7(){
        assertEquals(3, problem7(new int[]{1, 3, 8, 4, 3}, 4));
        assertEquals(1, problem7(new int[]{3, 8, 3, 1}, 8));
        assertEquals(3, problem7(new int[]{1, 3, 8, 12}, 12));
        assertEquals(0, problem7(new int[]{10, 9, 8}, 10));
    }
}
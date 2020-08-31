package dp;

import org.junit.Test;

import static org.junit.Assert.*;
import static dp.Problems.*;
import java.util.*;

public class ProblemsTest {
    @Test
    public void knapsack(){
        int[] weights = new int[]{1, 2, 3, 5};
        int[] profits = new int[]{1, 6, 10, 16};
        int capacity = 7;
        assertEquals(22, knapsack1(weights, profits, capacity));
        assertEquals(22, memoized_knapsack(weights, profits, capacity));
        assertEquals(22, bottom_up_knapsack(weights, profits, capacity));
        assertEquals(22, problem1(weights, profits, capacity));
    }

    @Test
    public void testProblem2(){
        // brute force
        assertTrue(problem2_bruteForce(new int[]{1, 2, 3, 4}));
        assertTrue(problem2_bruteForce(new int[]{1, 1, 3, 4, 7}));
        assertFalse(problem2_bruteForce(new int[]{2, 3, 4, 6}));
        assertFalse(problem2_bruteForce(new int[]{1, 1, 2, 3, 6}));
        //top-down
        assertTrue(problem2_topdown(new int[]{1, 2, 3, 4}));
        assertTrue(problem2_topdown(new int[]{2, 3, 5}));
        assertTrue(problem2_topdown(new int[]{1, 1, 3, 4, 7}));
        assertFalse(problem2_topdown(new int[]{2, 3, 4, 6}));
        assertTrue(problem2_topdown(new int[]{1, 2, 3, 6}));
        //bottom-up
        assertTrue(problem2_bottom_up(new int[]{1, 2, 3, 4}));
        assertTrue(problem2_bottom_up(new int[]{2, 3, 5}));
        assertTrue(problem2_bottom_up(new int[]{1, 1, 3, 4, 7}));
        assertFalse(problem2_bottom_up(new int[]{2, 3, 4, 6}));
        assertTrue(problem2_bottom_up(new int[]{1, 2, 3, 6}));
        //bottom-up linear space
        assertTrue(problem2_bottom_up_linear_space(new int[]{1, 2, 3, 4}));
        assertTrue(problem2_bottom_up_linear_space(new int[]{2, 3, 5}));
        assertTrue(problem2_bottom_up_linear_space(new int[]{1, 1, 3, 4, 7}));
        assertTrue(problem2_bottom_up_linear_space(new int[]{1, 2, 3, 6}));
        assertFalse(problem2_bottom_up_linear_space(new int[]{2, 3, 4, 6}));

    }

    @Test
    public void testProblem3(){
        // brute force
        assertTrue(problem3(Arrays.asList(1, 2, 3, 7), 6));
        assertTrue(problem3(Arrays.asList(1, 2, 7, 1, 5), 10));
        assertFalse(problem3(Arrays.asList(1, 3, 4, 8), 6));
        // top down brute force
        assertTrue(problem3_top_down(Arrays.asList(1, 2, 3, 7), 6));
        assertTrue(problem3_top_down(Arrays.asList(1, 2, 7, 1, 5), 10));
        assertFalse(problem3_top_down(Arrays.asList(1, 3, 4, 8), 6));
        // bottom up
        assertTrue(problem3_bottom_up(Arrays.asList(1, 2, 3, 7), 6));
        assertTrue(problem3_bottom_up(Arrays.asList(1, 2, 7, 1, 5), 10));
        assertFalse(problem3_bottom_up(Arrays.asList(1, 3, 4, 8), 6));
        // bottom up linear space
        assertTrue(problem3_bottom_up_linear(Arrays.asList(1, 2, 3, 7), 6));
        assertTrue(problem3_bottom_up_linear(Arrays.asList(1, 2, 7, 1, 5), 10));
        assertFalse(problem3_bottom_up_linear(Arrays.asList(1, 3, 4, 8), 6));
    }

    @Test
    public void testProblem4(){
        //brute force
        assertEquals(3, problem4(new int[]{1, 2, 3, 9}));
        assertEquals(0, problem4(new int[]{1, 2, 7, 1, 5}));
        assertEquals(92, problem4(new int[]{1, 3, 100, 4}));
        assertEquals(0, problem4(new int[]{0, 0, 0, 0}));
        // alternate brute force
        assertEquals(3, problem4_alternate(new int[]{1, 2, 3, 9}));
        assertEquals(0, problem4_alternate(new int[]{1, 2, 7, 1, 5}));
        assertEquals(0, problem4_alternate(new int[]{0, 0, 0, 0}));
        assertEquals(92, problem4_alternate(new int[]{1, 3, 100, 4}));
        // top down dp
        assertEquals(3, problem4_top_down(new int[]{1, 2, 3, 9}));
        assertEquals(0, problem4_top_down(new int[]{1, 2, 7, 1, 5}));
        assertEquals(0, problem4_top_down(new int[]{0, 0, 0, 0}));
        assertEquals(92, problem4_top_down(new int[]{1, 3, 100, 4}));
        // bottom up
        assertEquals(3, problem4_bottom_up(new int[]{1, 2, 3, 9}));
        assertEquals(0, problem4_bottom_up(new int[]{1, 2, 7, 1, 5}));
        assertEquals(0, problem4_bottom_up(new int[]{0, 0, 0, 0}));
        assertEquals(92, problem4_bottom_up(new int[]{1, 3, 100, 4}));
        // bottom up linear space
        assertEquals(3, problem4_linear_space(new int[]{1, 2, 3, 9}));
        assertEquals(0, problem4_linear_space(new int[]{1, 2, 7, 1, 5}));
        assertEquals(0, problem4_linear_space(new int[]{0, 0, 0, 0}));
        assertEquals(92, problem4_linear_space(new int[]{1, 3, 100, 4}));
    }
}
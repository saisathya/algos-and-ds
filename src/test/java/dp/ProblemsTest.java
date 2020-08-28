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
    }
}
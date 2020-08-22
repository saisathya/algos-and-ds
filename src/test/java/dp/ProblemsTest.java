package dp;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
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
    public void problem2(){
        assertTrue(problem2_bruteForce(new int[]{1, 2, 3, 4}));
        assertTrue(problem2_bruteForce(new int[]{1, 1, 3, 4, 7}));
        assertFalse(problem2_bruteForce(new int[]{2, 3, 4, 6}));

        assertTrue(problem2_dp(new int[]{1, 2, 3, 4}));
        assertTrue(problem2_dp(new int[]{2, 3, 5}));
        assertTrue(problem2_dp(new int[]{1, 1, 3, 4, 7}));
        assertFalse(problem2_dp(new int[]{2, 3, 4, 6}));
    }

}
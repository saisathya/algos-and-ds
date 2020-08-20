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
    }
}
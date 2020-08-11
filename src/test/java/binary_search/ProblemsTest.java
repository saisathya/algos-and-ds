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
}
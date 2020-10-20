package list;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.*;
import static list.Problems.*;

public class ProblemsTest {

    @Test
    public void testProblem1(){
        assertEquals(5, problem1(new int[]{7,1,5,3,6,4}));
        assertEquals(0, problem1(new int[]{7,6,4,3,1}));
        assertEquals(3, problem1(new int[]{2, 1, 4}));
    }

    @Test
    public void testProblem2(){
        assertTrue(problem2(new int[]{1, 2, 3, 4, 5}));
        assertFalse(problem2(new int[]{1, 2, 2, 3, 4, 5}));
    }

}
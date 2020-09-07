package counting_arithmetic;

import org.junit.Test;

import static org.junit.Assert.*;
import static counting_arithmetic.Problems.*;

public class ProblemsTest {
    @Test
    public void testProblem1(){
        assertEquals(3, problem1(new int[]{2,5,3,4,1}));
        assertEquals(0, problem1(new int[]{2, 1, 3}));
        assertEquals(4, problem1(new int[]{1, 2, 3, 4}));
    }
}
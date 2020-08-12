package xor;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static xor.Problems.*;
import static java.util.Arrays.*;

public class ProblemsTest {
    @Test
    public void testProblem1(){
        assertEquals(3, problem1(new int[]{5, 4, 6, 1, 2}));
    }

    @Test
    public void testProblem2(){
        assertEquals(4 , problem2(new int[]{1, 4, 2, 1, 3, 2, 3}));
        assertEquals(9, problem2(new int[]{7, 9, 7}));
    }
}
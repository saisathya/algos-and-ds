package counting;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.*;
import static counting.Problems.*;

public class ProblemsTest {
    @Test
    public void testProblem1(){
        assertEquals(3, problem1(new int[]{2,5,3,4,1}));
        assertEquals(0, problem1(new int[]{2, 1, 3}));
        assertEquals(4, problem1(new int[]{1, 2, 3, 4}));
    }
}
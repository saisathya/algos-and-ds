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
    }

}
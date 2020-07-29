package two_heaps;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ProblemsTest {
    @Test
    public void problem1(){
        Problems.Problem1 p1 = new Problems.Problem1();
        p1.insert(1);
        assertEquals(1, p1.findMedian());

    }
}
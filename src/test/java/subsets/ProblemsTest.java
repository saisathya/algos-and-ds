package subsets;
import org.junit.Test;
import java.util.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static subsets.Problems.*;

public class ProblemsTest {
    @Test
    public void testProblem1(){
        assertThat(problem1(new int[]{1, 2, 3}), containsInAnyOrder(new ArrayList<Integer>(), Arrays.asList(1), Arrays.asList(2),
                Arrays.asList(3), Arrays.asList(1, 2), Arrays.asList(1, 3), Arrays.asList(2, 3), Arrays.asList(1, 2, 3)));
    }
}
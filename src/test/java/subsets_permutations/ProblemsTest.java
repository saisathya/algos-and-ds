package subsets_permutations;
import org.junit.Test;
import java.util.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static subsets_permutations.Problems.*;
import static java.util.Arrays.*;

public class ProblemsTest {
    @Test
    public void testProblem1() {
        assertThat(problem1(new int[]{1, 2, 3}), containsInAnyOrder(new ArrayList<Integer>(), asList(1), asList(2),
                asList(3), asList(1, 2), asList(1, 3), asList(2, 3), asList(1, 2, 3)));
    }

    @Test
    public void testProblem2() {
        assertThat(problem2(new int[]{1, 2, 3, 3}), containsInAnyOrder(new ArrayList<Integer>(), asList(1), asList(2),
                asList(3), asList(1, 2), asList(1, 3), asList(2, 3), asList(3, 3), asList(1, 2, 3), asList(1, 3, 3),
                asList(2, 3, 3), asList(1, 2, 3, 3)));
    }

    @Test
    public void testProblem3() {
        assertThat(problem3(new int[]{1, 2, 3}), containsInAnyOrder(asList(1, 2, 3), asList(1, 3, 2), asList(2, 1, 3), asList(2, 3, 1),
                asList(3, 1, 2), asList(3, 2, 1)));
        assertThat(problem3(new int[]{1}), containsInAnyOrder(asList(1)));
    }
}
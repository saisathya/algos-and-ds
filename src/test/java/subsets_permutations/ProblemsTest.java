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

    @Test
    public void testProblem4(){
        assertThat(problem4("c3po"), containsInAnyOrder("c3po", "C3po", "C3Po", "C3PO", "c3Po", "c3PO", "c3pO", "C3pO"));
        assertThat(problem4("ad52"), containsInAnyOrder("ad52", "Ad52", "aD52", "AD52" ));
        assertThat(problem4("ab7c"), containsInAnyOrder("ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C"));

        assertThat(alternate_problem4("c3po"), containsInAnyOrder("c3po", "C3po", "C3Po", "C3PO", "c3Po", "c3PO", "c3pO", "C3pO"));
        assertThat(alternate_problem4("ad52"), containsInAnyOrder("ad52", "Ad52", "aD52", "AD52" ));
        assertThat(alternate_problem4("ab7c"), containsInAnyOrder("ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C"));
    }
}
package k_way_merge;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static k_way_merge.Problems.*;
import java.util.*;

public class ProblemsTest {

    @Test
    public void testProblem1(){
        ListNode one = createNode(0, 3), two = createNode(2, 5), three = createNode(1, 7);
        ListNode res = problem1(new ListNode[]{one, two, three});
        ListNode prev = new ListNode(-1);
        int count = 0;
        while(res != null){
            assertTrue(res.value >= prev.value);
            prev = res;
            res = res.next;
            count++;
        }
        assertEquals(15, count);
    }

    @Test
    public void testProblem2(){
        ListNode one = createNode(0, 3), two = createNode(2, 5), three = createNode(1, 7);
        assertEquals(0, problem2(new ListNode[]{one, three, two}, 1));
        assertEquals(7, problem2(new ListNode[]{three, two , one}, 15));
    }

    @Test
    public void testProblem3(){
        int[][] matrix = new int[][]{new int[]{2, 6, 8}, new int[]{3, 7, 10}, new int[]{5, 8, 11}};
        assertEquals(7, problem3(matrix, 5));
    }

    @Test
    public void testProblem4(){
        assertArrayEquals(new int[]{4, 7}, problem4(Arrays.asList(new int[]{4, 12}, new int[]{1, 5, 8}, new int[]{7, 8, 10})));
        assertArrayEquals(new int[]{9, 12}, problem4(Arrays.asList(new int[]{4, 12}, new int[]{1, 9}, new int[]{7, 10, 16})));
    }

    @Test
    public void testProblem5(){
        assertThat(problem5(new int[]{9, 8, 2}, new int[]{6, 3, 1}, 3), containsInAnyOrder(new int[]{9, 6}, new int[]{9, 3}, new int[]{8, 6}));
        assertThat(problem5(new int[]{5, 2, 1}, new int[]{2, -1}, 3), containsInAnyOrder(new int[]{5, 2}, new int[]{5, -1}, new int[]{2, 2}));
    }

    private static ListNode createNode(int i, int j){
        ListNode output = new ListNode(-1), curr = output;
        for(; i <= j; i++){
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return output.next;
    }
}
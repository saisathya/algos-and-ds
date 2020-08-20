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

    private static ListNode createNode(int i, int j){
        ListNode output = new ListNode(-1), curr = output;
        for(; i <= j; i++){
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return output.next;
    }
}
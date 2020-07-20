package linked_list;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProblemsTest {
    static ListNode longList, shortList, evenList, oddList;
    static StringBuilder longListString, shortListString, evenListString, oddListString;
    public static ListNode createList(int val){
        ListNode head = new ListNode(-1);
        ListNode curr = head;

        for(int i = 1; i <= val; i++){
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return head.next;
    }

    @BeforeClass
    public static void setup(){
        shortList = createList(5);
        shortListString = new StringBuilder(shortList.toString());
        longList = createList(10);
        longListString = new StringBuilder(longList.toString());
        evenList = createList(8);
        evenListString = new StringBuilder(evenList.toString());
        oddList = createList(9);
        oddListString = new StringBuilder(oddList.toString());
    }

    @Test
    public void problem1(){
        assertEquals("5 4 3 2 1", Problems.problem1(shortList).toString());
        assertEquals("10 9 8 7 6 5 4 3 2 1", Problems.problem1(longList).toString());
        assertEquals("8 7 6 5 4 3 2 1", Problems.problem1(evenList).toString());
        assertEquals("9 8 7 6 5 4 3 2 1", Problems.problem1(oddList).toString());
    }

    @Test
    public void problem2(){
        assertEquals("1 4 3 2 5", Problems.problem2(shortList, 2, 4).toString());
        assertEquals("8 7 6 5 4 3 2 1", Problems.problem2(evenList, 1, 8).toString());
    }
}
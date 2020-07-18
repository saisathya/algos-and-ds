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

        for(int i = 0; i < val; i++){
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
        assertEquals(shortListString.reverse().toString(), Problems.problem1(shortList).toString());
        assertEquals(longListString.reverse().toString(), Problems.problem1(longList).toString());
        assertEquals(evenListString.reverse().toString(), Problems.problem1(evenList).toString());
        assertEquals(oddListString.reverse().toString(), Problems.problem1(oddList).toString());
    }
}
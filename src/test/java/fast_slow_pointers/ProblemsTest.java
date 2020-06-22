package fast_slow_pointers;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProblemsTest {
    static ListNode nullList, oneItem, twoItem, threeItem, longList, shortList, cycleOneItem, cycleShort, cycleLong;

    public static ListNode createList(int length){
        ListNode head = new ListNode(-1), curr = head;
        for(int i = 0; i < length; i++){
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return head.next;
    }

    @BeforeClass
    public static void setup(){
        nullList = createList(0);
        oneItem = createList(1);
        twoItem = createList(2);
        threeItem = createList(3);
        longList = createList(10);
        shortList = createList(6);
        cycleOneItem = createList(1);
        cycleOneItem.next = cycleOneItem;
        cycleShort = createList(6);
        ListNode node = cycleShort;
        for(int i = 0; i < 5; i++)
            node = node.next;
        node.next = cycleShort.next.next.next;
        cycleLong = createList(11);
        node = cycleLong;
        for(int i = 0; i < 9; i++)
            node = node.next;
        node.next = cycleLong.next.next.next.next;
    }

    @Test
    public void reverseListTest(){
        ListNode list = createList(6);
        list = Problems.reverseList(list);
        for(int i = 5; i >= 0; i--){
            assertEquals(i, list.value);
            list = list.next;
        }
    }

    @Test
    public void problem1(){
        assertFalse(Problems.problem1(nullList));
        assertFalse(Problems.problem1(oneItem));
        assertFalse(Problems.problem1(twoItem));
        assertFalse(Problems.problem1(threeItem));
        assertFalse(Problems.problem1(longList));
        assertFalse(Problems.problem1(shortList));
        assertTrue(Problems.problem1(cycleOneItem));
        assertTrue(Problems.problem1(cycleShort));
        assertTrue(Problems.problem1(cycleLong));
    }

    @Test
    public void problem2(){
        assertEquals(1, Problems.problem2(cycleOneItem));
        assertEquals(3, Problems.problem2(cycleShort));
        assertEquals(6, Problems.problem2(cycleLong));
    }

    @Test
    public void problem3(){
        assertTrue(Problems.problem3(cycleOneItem) == cycleOneItem);
        assertTrue(Problems.problem3(cycleShort) == cycleShort.next.next.next);
        assertTrue(Problems.problem3(cycleLong) == cycleLong.next.next.next.next);
    }

    @Test
    public void problem4(){
        assertTrue(Problems.problem4(23));
        assertFalse(Problems.problem4(12));
        assertTrue(Problems.problem4(1));
    }

    @Test
    public void problem5(){
        assertEquals(0, Problems.problem5(oneItem).value);
        assertEquals(1, Problems.problem5(twoItem).value);
        assertEquals(1, Problems.problem5(threeItem).value);
        assertEquals(5, Problems.problem5(longList).value);
        assertEquals(3, Problems.problem5(shortList).value);
    }

    @Test
    public void problem6(){
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(1);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(1);

        assertTrue(Problems.problem6(oneItem));
        assertTrue(Problems.problem6(head1));
        assertTrue(Problems.problem6(head2));
        assertFalse(Problems.problem6(longList));
    }

    @Test
    public void problem7(){
        ListNode shortOddList = createList(5);
        shortOddList = Problems.problem7(shortOddList);
        problem7Check(5, shortOddList);
        ListNode longEvenList = createList(10);
        longEvenList = Problems.problem7(longEvenList);
        problem7Check(10, longEvenList);
    }

    public static void problem7Check(int len, ListNode head){
        for(int i = 0; i < len; i++){
            if(i % 2 == 0)
                assertEquals(i / 2, head.value);
            else
                assertEquals(len - (i / 2 + 1), head.value);
            head = head.next;
        }
        assertNull(head);
    }

}
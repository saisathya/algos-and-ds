package linked_list;

public class Problems {

    /**
     * Reverse a linked list in place and return the new head
     */
    public static ListNode problem1(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode reversed = new ListNode();
        ListNode curr = head;

        while(curr != null){
            ListNode temp = reversed.next;
            reversed.next = curr;
            curr = curr.next;
            reversed.next.next = temp;
        }
        return reversed.next;
    }
}

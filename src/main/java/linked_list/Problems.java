package linked_list;

public class Problems {

    /**
     * Reverse a linked list in place and return the new head
     */
    public static ListNode problem1(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode reversed = new ListNode();
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = reversed.next;
            reversed.next = curr;
            curr = curr.next;
            reversed.next.next = temp;
        }
        return reversed.next;
    }

    /**
     * Given the head of a linked list and a start and end, reverse the list from start to end (inclusive).
     */
    public static ListNode problem2(ListNode head, int start, int end){
        if(head == null || start <= 0 || end <= 0){
            return head;
        }
        int i = 0;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode curr = newHead;

        while(curr != null && i < start - 1){
            curr = curr.next;
            i++;
        }

        curr.next = problem2_helper(curr.next, start, end);

        return newHead.next;
    }

    public static ListNode problem2_helper(ListNode head, int start, int end){
        int i = start;
        ListNode prev = new ListNode(-1);
        ListNode curr = head;
        while(i <= end){
            ListNode temp = prev.next;
            prev.next = curr;
            curr = curr.next;
            prev.next.next = temp;
            i++;
        }

        ListNode node = prev;
        while(node.next != null){
            node = node.next;
        }
        node.next = curr;

        return prev.next;
    }

    /**
     * Given the head of a linkedList and and integer k, reverse every k nodes
     */
    public static ListNode problem3(ListNode head, int k){
        // Two ways to solve this problem. First way is using problem2_helper, whereby we call it N/k times to revert
        // the intervals. Since there are N/k calls, and problem2_helper takes O(N) time. This procedure will take approx.
        // O(N^2/k) time.
        // We can solve this problem linearly by reversing k nodes incrementaly
        if(head == null || k <= 0)
            return head;

        ListNode reversed = new ListNode(-1);
        ListNode prev = reversed;
        ListNode curr = head;
        while(curr != null){
            int i = 0;
            // the last node in the previous subList was the first Node
            // Therefore, we just have to save the first node, to that we can get our new previous
            ListNode lastNode = curr;
            while(i < k && curr != null){
                ListNode temp = prev.next;
                prev.next = curr;
                curr = curr.next;
                prev.next.next = temp;
                i++;
            }

//            while(prev.next != null){
//                prev = prev.next;
//            }
            prev = lastNode;
        }

        return reversed.next;
    }
}

package fast_slow_pointers;

import java.util.List;

public class Problems {

    /**
     * Given the head of a LinkedList, check if the list has a cycle
     */
    public static boolean problem1(ListNode head){
        if(head == null)
            return false;

        ListNode fast = head, slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }

    /**
     * Find the length of a cycle in a LinkedList
     */
    public static int problem2(ListNode head){
        if(head == null){
            return 0;
        }
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        int i = 0;
        do{
            slow = slow.next;
            i++;
        }while(slow != fast);
        return i;
    }

    /**
     * Find the starting node of a cycle given the head of a linked list
     */
    public static ListNode problem3(ListNode head){
        if(head == null)
            return head;
        int cycleLength = problem2(head);
        ListNode slow = head, fast = head;
        for(int i = 0; i < cycleLength; i++){
            fast = fast.next;
        }
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * Given a number, it is happy if the repeated sum of the squares of all digits is eventually 1. Find if a number is happy
     */
    public static boolean problem4(int n){
        if(n == 1) return true;
        int slow = problem4_helper(n);
        int fast = problem4_helper(slow);
        while(slow != 1 && fast != 1){
            slow = problem4_helper(slow);
            fast = problem4_helper(problem4_helper(fast));
            if(slow == fast)
                return false;
        }
        return true;
    }

    public static int problem4_helper(int n){
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            n /= 10;
            sum += digit * digit;
        }
        return sum;
    }

    /**
     * Given a linked list, find the middle node, for even length list, return (n/2 + 1)-th node
     */
    public static ListNode problem5(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

     /**
      * Given a Linked List, reverse it in place and return the new head
      */
     public static ListNode reverseList(ListNode head){
         ListNode prev = null;
         while(head != null){
             ListNode next = head.next;
             head.next = prev;
             prev = head;
             head = next;
         }
         return prev;
     }

    /**
     * Given a singly linked list, find if it is a palindrome in constant space
     */
    public static boolean problem6(ListNode head){
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reversedHalf = reverseList(slow);
        ListNode reversedHalfCopy = reversedHalf;
        while(reversedHalf != null && head != null){
            if(reversedHalf.value != head.value)
                break;
            reversedHalf = reversedHalf.next;
            head = head.next;
        }
        reverseList(reversedHalfCopy);
        return reversedHalf == null || head == null;
    }

    /**
     * Given a list 1 -> 2 -> 3 -> 4, return 1 -> 4 -> 2 -> 3
     */
    public static ListNode problem7(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode slow = head, fast = head;
        int i = 0;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            i++;
        }

        ListNode reversedHalf = reverseList(slow);
        ListNode newHead = new ListNode(-1), node = newHead;
        for(int j = 0; j < i; j++){
            node.next = head;
            node = node.next;
            head = head.next;
            node.next = reversedHalf;
            node = node.next;
            reversedHalf = reversedHalf.next;
        }
        node.next = reversedHalf;
        return newHead.next;
    }

    /**
     * You are given an array. At each index, the value denotes how many spaces to move forward/backwards.
     * Determine if there is a uni-directional cycle in it
     * TODO: Check dp
     */
    public static boolean problem8(int[]  a){
        int len = a.length;
        return false;
    }
}

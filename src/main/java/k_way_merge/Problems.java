package k_way_merge;

import java.util.*;

public class Problems {

    /**
     * Given an array of k sorted linked list, merge them to a new linked list and return the head
     */
    public static ListNode problem1(ListNode[] lists){
        if(lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> minheap = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));

        for(int i = 0; i < lists.length; i++){
            ListNode list = lists[i];
            if(list != null)
                minheap.offer(list);
        }

        ListNode output =  new ListNode(-1);
        ListNode curr = output;
        while(!minheap.isEmpty()){
            ListNode listNode = minheap.poll();
            if(listNode.next != null)
                minheap.offer(listNode.next);
            curr.next = listNode;
            curr = curr.next;
        }

        return output.next;
    }

    /**
     * Given M sorted arrays, find the k-th smallest number
     */
    public static int problem2(ListNode[] lists, int k){
        if(lists == null || lists.length == 0 || k <= 0)
            throw new IllegalArgumentException();

        PriorityQueue<ListNode> minheap = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));

        for(ListNode list : lists){
            if(list != null)
                minheap.offer(list);
        }
        int i = 0;
        ListNode list = null;
        while(i < k && !minheap.isEmpty()){
            list = minheap.poll();
            if(list.next != null)
                minheap.offer(list.next);
            i++;
        }
        return list.value;
    }
}

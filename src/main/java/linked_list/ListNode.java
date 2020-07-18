package linked_list;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(){
        this.val = 0;
    }

    @Override
    public  String toString(){
        ListNode curr = this;
        StringBuilder s = new StringBuilder();
        while(curr != null){
            s.append(curr.val + " ");
            curr = curr.next;
        }
        return s.toString().trim();
    }
}

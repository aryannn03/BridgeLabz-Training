class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Middle {
    public ListNode middleNode(ListNode head) {
        if(head.next==null){
            return head;
        }
        ListNode s=head;
        ListNode f=head;
        while(true){
            f=f.next.next;
            s=s.next;
            if( f==null || f.next==null){
                break;
            }
        }
        return s;
    }
}
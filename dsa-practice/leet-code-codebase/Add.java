class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Add {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head= new ListNode();
        ListNode cur=head;
        int c=0;
        while(l1!=null || l2!=null){
            int sum=c;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            ListNode nn = new ListNode();
            if(sum>9){
                nn.val=sum%10;
                c=sum/10;
            }
            else{
                nn.val=sum;
                c=0;
            }
            cur.next=nn;
            cur=nn;
        }
        if(c>0){
            ListNode nn = new ListNode(c);
            cur.next=nn; 
        }
        return head.next;
    }
}
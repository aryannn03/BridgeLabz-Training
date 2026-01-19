class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class LinkedList {
    Node head;
    public void insert(int data){
        Node newNode=new Node(data);
        if(this.head==null){
            this.head=newNode;
        }
        else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }
    public void display(){
        while(this.head!=null){
            System.out.print(this.head.data+" ");
            this.head=this.head.next;
        }
    }
    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.display();    
    }
}

public class CustomHashMap{
    static class Node{
        int key;
        int value;
        Node next;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    int size=16;
    Node[] buckets=new Node[size];

    int hash(int key){
        return key%size;
    }

    public void put(int key,int value){
        int index=hash(key);
        Node head=buckets[index];
        Node curr=head;
        while(curr!=null){
            if(curr.key==key){
                curr.value=value;
                return;
            }
            curr=curr.next;
        }
        Node node=new Node(key,value);
        node.next=head;
        buckets[index]=node;
    }

    public Integer get(int key){
        int index=hash(key);
        Node curr=buckets[index];
        while(curr!=null){
            if(curr.key==key){
                return curr.value;
            }
            curr=curr.next;
        }
        return null;
    }

    public void remove(int key){
        int index=hash(key);
        Node curr=buckets[index];
        Node prev=null;
        while(curr!=null){
            if(curr.key==key){
                if(prev==null){
                    buckets[index]=curr.next;
                }else{
                    prev.next=curr.next;
                }
                return;
            }
            prev=curr;
            curr=curr.next;
        }
    }

    public static void main(String[] args){
        CustomHashMap map=new CustomHashMap();
        map.put(1,10);
        map.put(2,20);
        map.put(17,30);
        System.out.print(map.get(1));
        System.out.print(map.get(17));
        map.remove(1);
        System.out.print(map.get(1));
    }
}

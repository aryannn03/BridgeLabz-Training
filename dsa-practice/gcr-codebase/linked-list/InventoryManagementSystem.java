import java.util.Scanner;

class Item{
    int id;
    String name;
    int quantity;
    double price;
    Item next;

    Item(int id,String name,int quantity,double price){
        this.id=id;
        this.name=name;
        this.quantity=quantity;
        this.price=price;
        this.next=null;
    }
}

class InventoryList{
    private Item head;

    void addAtBeginning(int id,String name,int quantity,double price){
        Item newNode=new Item(id,name,quantity,price);
        newNode.next=head;
        head=newNode;
    }

    void addAtEnd(int id,String name,int quantity,double price){
        Item newNode=new Item(id,name,quantity,price);
        if(head==null){
            head=newNode;
            return;
        }
        Item temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }

    void addAtPosition(int pos,int id,String name,int quantity,double price){
        if(pos<=0){
            System.out.println("Invalid position");
            return;
        }
        if(pos==1){
            addAtBeginning(id,name,quantity,price);
            return;
        }
        Item temp=head;
        for(int i=1;i<pos-1&&temp!=null;i++){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Position out of range");
            return;
        }
        Item newNode=new Item(id,name,quantity,price);
        newNode.next=temp.next;
        temp.next=newNode;
    }

    void removeById(int id){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(head.id==id){
            head=head.next;
            System.out.println("Item removed");
            return;
        }
        Item temp=head;
        while(temp.next!=null&&temp.next.id!=id){
            temp=temp.next;
        }
        if(temp.next==null){
            System.out.println("Item not found");
        }else{
            temp.next=temp.next.next;
            System.out.println("Item removed");
        }
    }

    void updateQuantity(int id,int qty){
        Item temp=head;
        while(temp!=null){
            if(temp.id==id){
                temp.quantity=qty;
                System.out.println("Quantity updated");
                return;
            }
            temp=temp.next;
        }
        System.out.println("Item not found");
    }

    void searchById(int id){
        Item temp=head;
        while(temp!=null){
            if(temp.id==id){
                printItem(temp);
                return;
            }
            temp=temp.next;
        }
        System.out.println("Item not found");
    }

    void searchByName(String name){
        Item temp=head;
        boolean found=false;
        while(temp!=null){
            if(temp.name.equals(name)){
                printItem(temp);
                found=true;
            }
            temp=temp.next;
        }
        if(!found){
            System.out.println("Item not found");
        }
    }

    void totalValue(){
        double sum=0;
        Item temp=head;
        while(temp!=null){
            sum+=temp.price*temp.quantity;
            temp=temp.next;
        }
        System.out.println("TotalValue:"+sum);
    }

    void sortByName(boolean asc){
        head=mergeSort(head,true,asc);
    }

    void sortByPrice(boolean asc){
        head=mergeSort(head,false,asc);
    }

    private Item mergeSort(Item h,boolean byName,boolean asc){
        if(h==null||h.next==null){
            return h;
        }
        Item mid=getMiddle(h);
        Item nextMid=mid.next;
        mid.next=null;
        Item left=mergeSort(h,byName,asc);
        Item right=mergeSort(nextMid,byName,asc);
        return merge(left,right,byName,asc);
    }

    private Item merge(Item a,Item b,boolean byName,boolean asc){
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        boolean condition;
        if(byName){
            condition=asc?a.name.compareTo(b.name)<=0:a.name.compareTo(b.name)>0;
        }else{
            condition=asc?a.price<=b.price:a.price>b.price;
        }
        Item result;
        if(condition){
            result=a;
            result.next=merge(a.next,b,byName,asc);
        }else{
            result=b;
            result.next=merge(a,b.next,byName,asc);
        }
        return result;
    }

    private Item getMiddle(Item h){
        Item slow=h;
        Item fast=h.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    void display(){
        if(head==null){
            System.out.println("No items");
            return;
        }
        Item temp=head;
        while(temp!=null){
            printItem(temp);
            temp=temp.next;
        }
    }

    private void printItem(Item i){
        System.out.println("Id:"+i.id+",Name:"+i.name+",Qty:"+i.quantity+",Price:"+i.price);
    }
}

public class InventoryManagementSystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        InventoryList list=new InventoryList();

        while(true){
            System.out.println("1AddBegin 2AddEnd 3AddPos 4Remove 5UpdateQty 6SearchId 7SearchName 8Total 9SortNameAsc 10SortNameDesc 11SortPriceAsc 12SortPriceDesc 13Display 14Exit");
            int choice=sc.nextInt();

            switch(choice){
                case 1:
                    list.addAtBeginning(sc.nextInt(),sc.next(),sc.nextInt(),sc.nextDouble());
                    break;
                case 2:
                    list.addAtEnd(sc.nextInt(),sc.next(),sc.nextInt(),sc.nextDouble());
                    break;
                case 3:
                    list.addAtPosition(sc.nextInt(),sc.nextInt(),sc.next(),sc.nextInt(),sc.nextDouble());
                    break;
                case 4:
                    list.removeById(sc.nextInt());
                    break;
                case 5:
                    list.updateQuantity(sc.nextInt(),sc.nextInt());
                    break;
                case 6:
                    list.searchById(sc.nextInt());
                    break;
                case 7:
                    list.searchByName(sc.next());
                    break;
                case 8:
                    list.totalValue();
                    break;
                case 9:
                    list.sortByName(true);
                    break;
                case 10:
                    list.sortByName(false);
                    break;
                case 11:
                    list.sortByPrice(true);
                    break;
                case 12:
                    list.sortByPrice(false);
                    break;
                case 13:
                    list.display();
                    break;
                case 14:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

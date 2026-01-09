import java.util.Scanner;
class Task{
    int id;
    String name;
    int priority;
    String dueDate;
    Task next;
    Task(int id,String name,int priority,String dueDate){
        this.id=id;
        this.name=name;
        this.priority=priority;
        this.dueDate=dueDate;
        this.next=null;
    }
}

class CircularTaskList{
    private Task head;
    private Task current;

    void addAtBeginning(int id,String name,int priority,String dueDate){
        Task newNode=new Task(id,name,priority,dueDate);
        if(head==null){
            head=newNode;
            newNode.next=head;
            current=head;
            return;
        }
        Task temp=head;
        while(temp.next!=head){
            temp=temp.next;
        }
        newNode.next=head;
        temp.next=newNode;
        head=newNode;
    }

    void addAtEnd(int id,String name,int priority,String dueDate){
        Task newNode=new Task(id,name,priority,dueDate);
        if(head==null){
            head=newNode;
            newNode.next=head;
            current=head;
            return;
        }
        Task temp=head;
        while(temp.next!=head){
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.next=head;
    }

    void addAtPosition(int pos,int id,String name,int priority,String dueDate){
        if(pos<=0){
            System.out.println("Invalid position");
            return;
        }
        if(pos==1){
            addAtBeginning(id,name,priority,dueDate);
            return;
        }
        Task temp=head;
        for(int i=1;i<pos-1&&temp.next!=head;i++){
            temp=temp.next;
        }
        Task newNode=new Task(id,name,priority,dueDate);
        newNode.next=temp.next;
        temp.next=newNode;
    }

    void removeById(int id){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Task temp=head;
        Task prev=null;
        do{
            if(temp.id==id){
                if(prev==null){
                    Task last=head;
                    while(last.next!=head){
                        last=last.next;
                    }
                    if(head.next==head){
                        head=null;
                        current=null;
                        return;
                    }
                    head=head.next;
                    last.next=head;
                    current=head;
                }else{
                    prev.next=temp.next;
                }
                System.out.println("Task removed");
                return;
            }
            prev=temp;
            temp=temp.next;
        }while(temp!=head);
        System.out.println("Task not found");
    }

    void viewCurrentAndNext(){
        if(current==null){
            System.out.println("No tasks");
            return;
        }
        printTask(current);
        current=current.next;
    }

    void displayAll(){
        if(head==null){
            System.out.println("No tasks");
            return;
        }
        Task temp=head;
        do{
            printTask(temp);
            temp=temp.next;
        }while(temp!=head);
    }

    void searchByPriority(int priority){
        if(head==null){
            System.out.println("No tasks");
            return;
        }
        Task temp=head;
        boolean found=false;
        do{
            if(temp.priority==priority){
                printTask(temp);
                found=true;
            }
            temp=temp.next;
        }while(temp!=head);
        if(!found){
            System.out.println("Task not found");
        }
    }

    private void printTask(Task t){
        System.out.println("Id:"+t.id+",Name:"+t.name+",Priority:"+t.priority+",Due:"+t.dueDate);
    }
}

public class TaskScheduler{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        CircularTaskList list=new CircularTaskList();

        while(true){
            System.out.println("1AddBegin 2AddEnd 3AddPos 4Remove 5ViewNext 6Display 7SearchPriority 8Exit");
            int choice=sc.nextInt();

            switch(choice){
                case 1:
                    list.addAtBeginning(sc.nextInt(),sc.next(),sc.nextInt(),sc.next());
                    break;
                case 2:
                    list.addAtEnd(sc.nextInt(),sc.next(),sc.nextInt(),sc.next());
                    break;
                case 3:
                    list.addAtPosition(sc.nextInt(),sc.nextInt(),sc.next(),sc.nextInt(),sc.next());
                    break;
                case 4:
                    list.removeById(sc.nextInt());
                    break;
                case 5:
                    list.viewCurrentAndNext();
                    break;
                case 6:
                    list.displayAll();
                    break;
                case 7:
                    list.searchByPriority(sc.nextInt());
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

import java.util.Scanner;

class Process{
    int pid;
    int burst;
    int remaining;
    int priority;
    int waiting;
    int turnaround;
    Process next;

    Process(int pid,int burst,int priority){
        this.pid=pid;
        this.burst=burst;
        this.remaining=burst;
        this.priority=priority;
        this.waiting=0;
        this.turnaround=0;
        this.next=null;
    }
}

class RoundRobinList{
    private Process head;

    void addProcess(int pid,int burst,int priority){
        Process newNode=new Process(pid,burst,priority);
        if(head==null){
            head=newNode;
            newNode.next=head;
            return;
        }
        Process temp=head;
        while(temp.next!=head){
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.next=head;
    }

    void removeProcess(Process target){
        if(head==null){
            return;
        }
        if(head==target&&head.next==head){
            head=null;
            return;
        }
        Process temp=head;
        while(temp.next!=target){
            temp=temp.next;
        }
        temp.next=target.next;
        if(target==head){
            head=target.next;
        }
    }

    void simulate(int quantum){
        if(head==null){
            System.out.println("No processes");
            return;
        }
        int time=0;
        int count=countProcesses();
        Process current=head;

        while(head!=null){
            display();
            if(current.remaining>quantum){
                current.remaining-=quantum;
                time+=quantum;
            }else{
                time+=current.remaining;
                current.remaining=0;
                current.turnaround=time;
                current.waiting=current.turnaround-current.burst;
                Process finished=current;
                current=current.next;
                removeProcess(finished);
                continue;
            }
            current=current.next;
        }
        calculateAverage(count);
    }

    int countProcesses(){
        if(head==null){
            return 0;
        }
        int count=0;
        Process temp=head;
        do{
            count++;
            temp=temp.next;
        }while(temp!=head);
        return count;
    }

    void calculateAverage(int count){
        double totalWait=0;
        double totalTurn=0;
        Process temp=head;
        if(temp==null){
            System.out.println("AverageWaitingTime:"+(totalWait/count));
            System.out.println("AverageTurnaroundTime:"+(totalTurn/count));
            return;
        }
        do{
            totalWait+=temp.waiting;
            totalTurn+=temp.turnaround;
            temp=temp.next;
        }while(temp!=head);
        System.out.println("AverageWaitingTime:"+(totalWait/count));
        System.out.println("AverageTurnaroundTime:"+(totalTurn/count));
    }

    void display(){
        if(head==null){
            System.out.println("Empty");
            return;
        }
        Process temp=head;
        do{
            System.out.println("PID:"+temp.pid+",Remaining:"+temp.remaining+",Priority:"+temp.priority);
            temp=temp.next;
        }while(temp!=head);
        System.out.println("---");
    }
}

public class RoundRobinScheduler{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        RoundRobinList list=new RoundRobinList();

        System.out.println("Enter number of processes");
        int n=sc.nextInt();

        for(int i=0;i<n;i++){
            list.addProcess(sc.nextInt(),sc.nextInt(),sc.nextInt());
        }

        System.out.println("Enter time quantum");
        int quantum=sc.nextInt();

        list.simulate(quantum);
    }
}

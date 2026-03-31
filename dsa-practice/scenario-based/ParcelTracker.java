import java.util.*;
class ParcelTracker {
    static class Node {
        String stage;
        Node next;
        Node(String stage){
            this.stage=stage;
            this.next=null;
        }
    }
    Node head;
    public void addStage(String stage){
        Node newNode=new Node(stage);
        if(head==null){
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
    public void addCheckpointAfter(String targetStage,String newStage){
        Node temp=head;
        while(temp!=null && !temp.stage.equalsIgnoreCase(targetStage)){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Stage not found. Cannot add checkpoint.");
            return;
        }
        Node newNode=new Node(newStage);
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public void trackParcel(){
        if(head==null){
            System.out.println("Parcel lost. No tracking information available.");
            return;
        }
        Node temp=head;
        System.out.println("\nTracking Parcel Stages:");
        while(temp!=null){
            System.out.println("-> "+temp.stage);
            temp=temp.next;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ParcelTracker tracker=new ParcelTracker();
        System.out.print("Enter number of delivery stages: ");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.print("Enter stage "+(i+1)+": ");
            String stage=sc.nextLine();
            tracker.addStage(stage);
        }
        System.out.print("\nDo you want to add a custom checkpoint? (yes/no): ");
        String choice=sc.nextLine();
        if(choice.equalsIgnoreCase("yes")){
            System.out.print("Enter existing stage name: ");
            String target=sc.nextLine();
            System.out.print("Enter new checkpoint name: ");
            String checkpoint=sc.nextLine();
            tracker.addCheckpointAfter(target,checkpoint);
        }
        tracker.trackParcel();
    }
}

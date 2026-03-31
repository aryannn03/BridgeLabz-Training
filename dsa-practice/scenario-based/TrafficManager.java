import java.util.*;

class VehicleNode{
    String vehicleNo;
    VehicleNode next;

    VehicleNode(String vehicleNo){
        this.vehicleNo = vehicleNo;
        this.next = null;
    }
}

class Roundabout{
    private VehicleNode head = null;

    void addVehicle(String vehicleNo){
        VehicleNode newNode = new VehicleNode(vehicleNo);

        if(head == null){
            head = newNode;
            newNode.next = head;
        }else{
            VehicleNode temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
        System.out.println(vehicleNo + " entered roundabout");
    }

    void removeVehicle(){
        if(head == null){
            System.out.println("Roundabout is empty");
            return;
        }
        if(head.next == head){
            System.out.println(head.vehicleNo + " exited roundabout");
            head = null;
            return;
        }
        VehicleNode temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        System.out.println(head.vehicleNo + " exited roundabout");
        temp.next = head.next;
        head = head.next;
    }

    void display(){
        if(head == null){
            System.out.println("Roundabout Empty");
            return;
        }
        VehicleNode temp = head;
        System.out.print("Roundabout Vehicles: ");
        do{
            System.out.print(temp.vehicleNo + " -> ");
            temp = temp.next;
        }while(temp != head);
        System.out.println("(back to start)");
    }
}

class VehicleQueue{
    private String[] queue;
    private int front = -1, rear = -1, size;

    VehicleQueue(int size){
        this.size = size;
        queue = new String[size];
    }

    boolean isFull(){
        return rear == size - 1;
    }

    boolean isEmpty(){
        return front == -1;
    }

    void enqueue(String vehicle){
        if(isFull()){
            System.out.println("Queue Overflow: Vehicle cannot enter");
            return;
        }
        if(front == -1) front = 0;
        queue[++rear] = vehicle;
        System.out.println(vehicle + " added to waiting queue");
    }

    String dequeue(){
        if(isEmpty()){
            System.out.println("Queue Underflow: No vehicles waiting");
            return null;
        }
        String vehicle = queue[front++];
        if(front > rear){
            front = rear = -1;
        }
        return vehicle;
    }

    void display(){
        if(isEmpty()){
            System.out.println("Waiting Queue Empty");
            return;
        }
        System.out.print("Waiting Queue: ");
        for(int i = front; i <= rear; i++){
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

public class TrafficManager{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Roundabout roundabout = new Roundabout();
        VehicleQueue queue = new VehicleQueue(5);

        while(true){
            System.out.println("1.Add Vehicle to Queue");
            System.out.println("2.Move Vehicle to Roundabout");
            System.out.println("3.Exit Vehicle from Roundabout");
            System.out.println("4.Display State");
            System.out.println("0.Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter Vehicle Number: ");
                    queue.enqueue(sc.next());
                    break;

                case 2:
                    String vehicle = queue.dequeue();
                    if(vehicle != null){
                        roundabout.addVehicle(vehicle);
                    }
                    break;

                case 3:
                    roundabout.removeVehicle();
                    break;

                case 4:
                    queue.display();
                    roundabout.display();
                    break;

                case 0:
                    System.out.println("System Stopped");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}

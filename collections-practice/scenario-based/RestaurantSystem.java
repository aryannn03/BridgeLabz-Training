import java.util.*;
class TableAlreadyReservedException extends Exception {
    public TableAlreadyReservedException(String message) {
        super(message);
    }
}
class Table {
    int tableNumber;
    int capacity;
    public Table(int tableNumber,int capacity) {
        this.tableNumber=tableNumber;
        this.capacity=capacity;
    }
    public String toString() {
        return "Table:"+tableNumber+" Capacity:"+capacity;
    }
}

class Reservation {
    int tableNumber;
    String customerName;
    String timeSlot;
    public Reservation(int tableNumber,String customerName,String timeSlot) {
        this.tableNumber=tableNumber;
        this.customerName=customerName;
        this.timeSlot=timeSlot;
    }
}

public class RestaurantSystem {
    Map<Integer,Table> tables=new HashMap<>();
    List<Reservation> reservations=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    public RestaurantSystem() {
        tables.put(1,new Table(1,2));
        tables.put(2,new Table(2,4));
        tables.put(3,new Table(3,6));
        tables.put(4,new Table(4,8));
    }
    public void showTables() {
        System.out.println("Available Tables:");
        for(Table t:tables.values()) {
            System.out.println(t);
        }
    }
    public void reserveTable() {
        try {
            showTables();
            System.out.print("Enter table number:");
            int tableNumber=sc.nextInt();
            sc.nextLine();
            if(!tables.containsKey(tableNumber)) {
                System.out.println("Invalid table number");
                return;
            }
            System.out.print("Enter your name:");
            String name=sc.nextLine();
            System.out.print("Enter time slot:");
            String timeSlot=sc.nextLine();
            for(Reservation r:reservations) {
                if(r.tableNumber==tableNumber&&r.timeSlot.equals(timeSlot)) {
                    throw new TableAlreadyReservedException("Table already reserved for this time slot");
                }
            }
            reservations.add(new Reservation(tableNumber,name,timeSlot));
            System.out.println("Reservation successful");
        } catch(TableAlreadyReservedException e) {
            System.out.println(e.getMessage());
        }
    }
    public void cancelReservation() {
        System.out.print("Enter table number:");
        int tableNumber=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter time slot:");
        String timeSlot=sc.nextLine();
        for(int i=0;i<reservations.size();i++) {
            Reservation r=reservations.get(i);
            if(r.tableNumber==tableNumber&&r.timeSlot.equals(timeSlot)) {
                reservations.remove(i);
                System.out.println("Reservation cancelled");
                return;
            }
        }
        System.out.println("No reservation found");
    }

    public void showAvailableTables() {
        System.out.print("Enter time slot:");
        String timeSlot=sc.nextLine();
        System.out.println("Available tables for "+timeSlot+":");
        for(int tableNumber:tables.keySet()) {
            boolean booked=false;
            for(Reservation r:reservations) {
                if(r.tableNumber==tableNumber&&r.timeSlot.equals(timeSlot)) {
                    booked=true;
                    break;
                }
            }
            if(!booked) {
                System.out.println(tables.get(tableNumber));
            }
        }
    }
    public void startSystem() {
        while(true) {
            System.out.println("1.Reserve Table");
            System.out.println("2.Cancel Reservation");
            System.out.println("3.Show Available Tables");
            System.out.println("4.Exit");
            System.out.print("Enter choice:");
            int choice=sc.nextInt();
            sc.nextLine();
            if(choice==1) {
                reserveTable();
            } else if(choice==2) {
                cancelReservation();
            } else if(choice==3) {
                showAvailableTables();
            } else if(choice==4) {
                System.out.println("Thank you for using system");
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
    public static void main(String[] args) {
        RestaurantSystem system=new RestaurantSystem();
        system.startSystem();
    }
}
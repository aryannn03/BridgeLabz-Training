import java.util.Scanner;

class Ticket{
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketId,String customerName,String movieName,String seatNumber,String bookingTime){
        this.ticketId=ticketId;
        this.customerName=customerName;
        this.movieName=movieName;
        this.seatNumber=seatNumber;
        this.bookingTime=bookingTime;
        this.next=null;
    }
}

class TicketCircularList{
    private Ticket head;

    void addTicket(int ticketId,String customerName,String movieName,String seatNumber,String bookingTime){
        Ticket newNode=new Ticket(ticketId,customerName,movieName,seatNumber,bookingTime);
        if(head==null){
            head=newNode;
            newNode.next=head;
            return;
        }
        Ticket temp=head;
        while(temp.next!=head){
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.next=head;
    }

    void removeTicket(int ticketId){
        if(head==null){
            System.out.println("No tickets");
            return;
        }
        Ticket temp=head;
        Ticket prev=null;
        do{
            if(temp.ticketId==ticketId){
                if(prev==null){
                    Ticket last=head;
                    while(last.next!=head){
                        last=last.next;
                    }
                    if(head.next==head){
                        head=null;
                        System.out.println("Ticket removed");
                        return;
                    }
                    head=head.next;
                    last.next=head;
                }else{
                    prev.next=temp.next;
                }
                System.out.println("Ticket removed");
                return;
            }
            prev=temp;
            temp=temp.next;
        }while(temp!=head);
        System.out.println("Ticket not found");
    }

    void searchByCustomer(String name){
        if(head==null){
            System.out.println("No tickets");
            return;
        }
        Ticket temp=head;
        boolean found=false;
        do{
            if(temp.customerName.equals(name)){
                printTicket(temp);
                found=true;
            }
            temp=temp.next;
        }while(temp!=head);
        if(!found){
            System.out.println("Ticket not found");
        }
    }

    void searchByMovie(String movie){
        if(head==null){
            System.out.println("No tickets");
            return;
        }
        Ticket temp=head;
        boolean found=false;
        do{
            if(temp.movieName.equals(movie)){
                printTicket(temp);
                found=true;
            }
            temp=temp.next;
        }while(temp!=head);
        if(!found){
            System.out.println("Ticket not found");
        }
    }

    void displayTickets(){
        if(head==null){
            System.out.println("No tickets");
            return;
        }
        Ticket temp=head;
        do{
            printTicket(temp);
            temp=temp.next;
        }while(temp!=head);
    }

    void countTickets(){
        if(head==null){
            System.out.println("TotalTickets:0");
            return;
        }
        int count=0;
        Ticket temp=head;
        do{
            count++;
            temp=temp.next;
        }while(temp!=head);
        System.out.println("TotalTickets:"+count);
    }

    private void printTicket(Ticket t){
        System.out.println("Id:"+t.ticketId+",Customer:"+t.customerName+",Movie:"+t.movieName+",Seat:"+t.seatNumber+",Time:"+t.bookingTime);
    }
}

public class TicketReservationSystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        TicketCircularList list=new TicketCircularList();

        while(true){
            System.out.println("1AddTicket 2RemoveTicket 3Display 4SearchCustomer 5SearchMovie 6Count 7Exit");
            int choice=sc.nextInt();

            switch(choice){
                case 1:
                    list.addTicket(sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.next());
                    break;
                case 2:
                    list.removeTicket(sc.nextInt());
                    break;
                case 3:
                    list.displayTickets();
                    break;
                case 4:
                    list.searchByCustomer(sc.next());
                    break;
                case 5:
                    list.searchByMovie(sc.next());
                    break;
                case 6:
                    list.countTickets();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

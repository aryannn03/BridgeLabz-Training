import java.util.*;
class Flight{
    String flightId;
    String source;
    String destination;
    int seats;
    double price;
    Flight(String flightId,String source,String destination,int seats,double price){
        this.flightId=flightId;
        this.source=source;
        this.destination=destination;
        this.seats=seats;
        this.price=price;
    }
    void displayFlight(){
        System.out.println("Flight ID:"+flightId);
        System.out.println("From:"+source);
        System.out.println("To:"+destination);
        System.out.println("Seats:"+seats);
        System.out.println("Price:"+price);
    }
}
class Booking{
    String bookingId;
    String customerName;
    Flight flight;
    Booking(String bookingId,String customerName,Flight flight){
        this.bookingId=bookingId;
        this.customerName=customerName;
        this.flight=flight;
    }

    void displayBooking(){
        System.out.println("Booking ID:"+bookingId);
        System.out.println("Customer:"+customerName);
        flight.displayFlight();
    }
}
class FlightBookingSystem{
    Flight[] flights;
    ArrayList<Booking> bookings=new ArrayList<>();

    FlightBookingSystem(){
        flights=new Flight[]{
            new Flight("F101","Delhi","Mumbai",5,4500),
            new Flight("F102","Delhi","Bangalore",3,5500),
            new Flight("F103","Mumbai","Chennai",4,5000),
            new Flight("F104","Delhi","Kolkata",2,4800)
        };
    }
    void searchFlight(String source,String destination){
        boolean found=false;
        for(int i=0;i<flights.length;i++){
            if(flights[i].source.equalsIgnoreCase(source)
            &&flights[i].destination.equalsIgnoreCase(destination)){
                flights[i].displayFlight();
                found=true;
            }
        }
        if(!found){
            System.out.println("No flights found");
        }
    }
    void bookFlight(String flightId,String customerName){
        for(int i=0;i<flights.length;i++){
            if(flights[i].flightId.equalsIgnoreCase(flightId)){
                if(flights[i].seats>0){
                    flights[i].seats--;
                    String bookingId="B"+(bookings.size()+1);
                    bookings.add(new Booking(bookingId,customerName,flights[i]));
                    System.out.println("Booking successful. Booking ID:"+bookingId);
                    return;
                }else{
                    System.out.println("No seats available");
                    return;
                }
            }
        }
        System.out.println("Invalid flight ID");
    }
    void displayBookings(){
        if(bookings.isEmpty()){
            System.out.println("No bookings available");
            return;
        }
        for(int i=0;i<bookings.size();i++){
            bookings.get(i).displayBooking();
        }
    }
}
public class FlightBooking{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        FlightBookingSystem system=new FlightBookingSystem();
        boolean loop=true;
        while(loop){
            System.out.println("1.Search Flight\n2.Book Flight\n3.View Bookings\n0.Exit");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Enter source");
                    String src=sc.nextLine();
                    System.out.println("Enter destination");
                    String dest=sc.nextLine();
                    system.searchFlight(src,dest);
                    break;
                case 2:
                    System.out.println("Enter flight ID");
                    String fid=sc.nextLine();
                    System.out.println("Enter customer name");
                    String cname=sc.nextLine();
                    system.bookFlight(fid,cname);
                    break;
                case 3:
                    system.displayBookings();
                    break;
                case 0:
                    loop=false;
                    System.out.println("Thank you");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
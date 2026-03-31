import java.util.*;

class RoomNotAvailableException extends Exception{
    RoomNotAvailableException(String msg){
        super(msg);
    }
}

interface PricingStrategy{
    double calculatePrice(double basePrice,int days);
}

class RegularPricing implements PricingStrategy{
    public double calculatePrice(double basePrice,int days){
        return basePrice*days;
    }
}

class SeasonalPricing implements PricingStrategy{
    public double calculatePrice(double basePrice,int days){
        return basePrice*days*1.2;
    }
}

abstract class Room{
    int roomNumber;
    double basePrice;
    boolean isBooked;

    Room(int roomNumber,double basePrice){
        this.roomNumber=roomNumber;
        this.basePrice=basePrice;
        this.isBooked=false;
    }

    abstract String getType();
}

class StandardRoom extends Room{
    StandardRoom(int roomNumber){
        super(roomNumber,2000);
    }
    String getType(){
        return "Standard";
    }
}

class DeluxeRoom extends Room{
    DeluxeRoom(int roomNumber){
        super(roomNumber,3500);
    }
    String getType(){
        return "Deluxe";
    }
}

class Guest{
    int guestId;
    String name;

    Guest(int guestId,String name){
        this.guestId=guestId;
        this.name=name;
    }
}

class Reservation{
    int reservationId;
    Guest guest;
    Room room;
    int days;
    double bill;

    Reservation(int reservationId,Guest guest,Room room,int days){
        this.reservationId=reservationId;
        this.guest=guest;
        this.room=room;
        this.days=days;
    }
}

public class HotelReservationSystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        List<Room> rooms=new ArrayList<>();
        rooms.add(new StandardRoom(101));
        rooms.add(new StandardRoom(102));
        rooms.add(new DeluxeRoom(201));
        rooms.add(new DeluxeRoom(202));

        Map<Integer,Reservation> reservations=new HashMap<>();
        int resId=1;

        while(true){
            System.out.println("1.View Rooms");
            System.out.println("2.Book Room");
            System.out.println("3.Check-In");
            System.out.println("4.Check-Out");
            System.out.println("0.Exit");
            System.out.print("Choice: ");
            int ch=sc.nextInt();

            if(ch==0) break;

            switch(ch){
                case 1:
                    for(Room r:rooms){
                        System.out.println(r.roomNumber+" "+r.getType()+" Booked:"+r.isBooked);
                    }
                    break;

                case 2:
                    try{
                        System.out.print("Enter Guest ID: ");
                        int gid=sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Guest Name: ");
                        String gname=sc.nextLine();
                        Guest guest=new Guest(gid,gname);

                        System.out.print("Enter Room Number: ");
                        int rno=sc.nextInt();

                        Room selected=null;
                        for(Room r:rooms){
                            if(r.roomNumber==rno && !r.isBooked){
                                selected=r;
                                break;
                            }
                        }
                        if(selected==null){
                            throw new RoomNotAvailableException("Room Not Available");
                        }

                        System.out.print("Enter Number of Days: ");
                        int days=sc.nextInt();
                        PricingStrategy pricing=new SeasonalPricing();
                        double bill=pricing.calculatePrice(selected.basePrice,days);

                        selected.isBooked=true;
                        Reservation res=new Reservation(resId++,guest,selected,days);
                        res.bill=bill;
                        reservations.put(res.reservationId,res);

                        System.out.println("Reservation Successful. ID: "+res.reservationId);
                    }catch(RoomNotAvailableException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter Reservation ID: ");
                    int cid=sc.nextInt();
                    if(reservations.containsKey(cid)){
                        System.out.println("Check-In Successful");
                    }else{
                        System.out.println("Reservation Not Found");
                    }
                    break;

                case 4:
                    System.out.print("Enter Reservation ID: ");
                    int oid=sc.nextInt();
                    Reservation res=reservations.get(oid);
                    if(res!=null){
                        res.room.isBooked=false;
                        System.out.println("Invoice");
                        System.out.println("Guest: "+res.guest.name);
                        System.out.println("Room: "+res.room.roomNumber+" "+res.room.getType());
                        System.out.println("Days: "+res.days);
                        System.out.println("Total Bill: "+res.bill);
                        reservations.remove(oid);
                    }else{
                        System.out.println("Reservation Not Found");
                    }
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}

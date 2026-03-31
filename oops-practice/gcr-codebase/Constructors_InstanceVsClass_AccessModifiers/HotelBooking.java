public class HotelBooking{
    String guestName;
    String roomType;
    int nights;

    public HotelBooking(){
        guestName="Guest";
        roomType="Standard";
        nights=1;
    }

    public HotelBooking(String guestName,String roomType,int nights){
        this.guestName=guestName;
        this.roomType=roomType;
        this.nights=nights;
    }

    public HotelBooking(HotelBooking h){
        guestName=h.guestName;
        roomType=h.roomType;
        nights=h.nights;
    }

    void display(){
        System.out.println(guestName+" "+roomType+" "+nights);
    }

    public static void main(String[]args){
        HotelBooking h1=new HotelBooking();
        HotelBooking h2=new HotelBooking("Aman","Deluxe",3);
        HotelBooking h3=new HotelBooking(h2);
        h3.display();
    }
}

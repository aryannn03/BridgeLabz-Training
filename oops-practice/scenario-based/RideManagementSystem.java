import java.time.LocalTime;
import java.util.*;
class Driver{
    int id;
    String name;
    boolean isavailable;
    public Driver(int id,String name,boolean isavailable){
        this.id=id;
        this.name=name;
        this.isavailable=isavailable;
    } 
} 
class User{
    int id;
    String name;
    public User(int id,String name){
        this.id=id;
        this.name=name;
    }
}
class Ride{
    Driver driver;
    User user;
    String source;
    String destination;
    double distance;
    double fare;
    String car;
    public Ride(Driver driver,User user, double distance, String source,String destination,double fare,String car){
        this.driver=driver;
        this.user=user;
        this.source=source;
        this.destination=destination;
        this.distance=distance;
        this.fare=fare;
        this.car=car;
    }
}
interface FareCalculator{
    double fareCalculation(String carType,double distance);
}
class PeakPrice implements FareCalculator{
    double fare;
    public double fareCalculation(String carType,double distance){
        if(carType.equals("SUV")){
            fare=30;
        }
        else if(carType.equals("Sedan")){
            fare=25;
        }
        else{
            fare=20;
        }
        return fare*distance;
    }
}
class NormalPrice implements FareCalculator{
    double fare;
    public double fareCalculation(String carType,double distance){
        if(carType.equals("SUV")){
            fare=20;
        }
        else if(carType.equals("Sedan")){
            fare=15;
        }
        else if(carType.equals("HatchBack")){
            fare=10;
        }
        return fare*distance;
    }
}
class NoDriverAvailableException extends Exception {
    NoDriverAvailableException(String message) {
        super(message);
    }
}
public class RideManagementSystem {
    static boolean isPeakTime(){
        LocalTime now=LocalTime.now();

        LocalTime mStart=LocalTime.of(7,0);
        LocalTime mEnd=LocalTime.of(9,0);

        LocalTime eStart=LocalTime.of(17,0);
        LocalTime eEnd=LocalTime.of(20,0);

        return (now.isAfter(mStart)&&now.isBefore(mEnd)) ||
               (now.isAfter(eStart)&&now.isBefore(eEnd));
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        Driver d1=new Driver(1, "ABC", true);
        Driver d2=new Driver(2, "PQR", true);
        Driver d3=new Driver(3, "XYZ", true);
        Queue<Driver> queue= new LinkedList<>();
        HashMap<Integer,Ride> map= new HashMap<>();
        queue.add(d1);
        queue.add(d2);
        queue.add(d3);
        int id=1;
        while(true){
            System.out.println("Press 1 to book the ride");
            System.out.println("Press 2 to see ride history");
            System.out.println("Press 0 to Exit");
            int input=sc.nextInt();
            sc.nextLine();
            if(input==1){
                try{
                    if(queue.isEmpty()){
                        throw new NoDriverAvailableException("No Driver Available");
                    }
                    Driver driver=queue.remove();
                    System.out.print("Enter your name: ");
                    String name=sc.nextLine();
                    User user = new User(id,name);
                    System.out.print("Enter type of car to book (Sedan/SUV/HatchBack): ");
                    String car=sc.nextLine();
                    System.out.print("Enter the source: ");
                    String source=sc.nextLine();
                    System.out.print("Enter the destination: ");
                    String destination=sc.nextLine();
                    System.out.print("Enter the distance: ");
                    double distance=sc.nextDouble();
                    double fare;
                    if(isPeakTime()){
                        FareCalculator fareCalculator=new PeakPrice();
                        fare=fareCalculator.fareCalculation(car, distance);
                    }           
                    else{
                        FareCalculator fareCalculator=new NormalPrice();
                        fare=fareCalculator.fareCalculation(car, distance);
                    }   
                    System.out.println("Your id is: "+id);
                    System.out.println("Your Fare is ₹"+fare);
                    id++;
                    Ride ride=new Ride(driver,user,distance,source,destination,fare,car);      
                    map.put(ride.user.id, ride);
                }
                catch(NoDriverAvailableException e){
                    System.out.println(e.getMessage());
                }
            }
            else if(input==2){
                System.out.print("Enter your id to see history: ");
                int user_id=sc.nextInt();
                if(map.containsKey(user_id)){
                    Ride ride = map.get(user_id);
                    System.out.println("User name: "+ride.user.name);
                    System.out.println("User Id: "+ride.user.id);
                    System.out.println("Driver name: "+ride.driver.name);
                    System.out.println("Driver Id: "+ride.driver.id);
                    System.out.println("Source: "+ride.source);
                    System.out.println("Destination: "+ride.destination);
                    System.out.println("Distance: "+ride.distance);
                    System.out.println("Fare: "+ride.fare);
                    System.out.println("Car: "+ride.car);
                }
                else{
                    System.out.println("User does not exists!!!");
                }
            }
            else{
                System.out.println("Thank you for choosing our services!!!");
                return;
            }
        }
    }
}

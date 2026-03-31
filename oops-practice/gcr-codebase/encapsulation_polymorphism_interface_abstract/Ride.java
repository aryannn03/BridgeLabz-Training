interface GPS{
    String getCurrentLocation();
    void updateLocation(String loc);
}
abstract class Vehicle{
    protected String vehicleId;
    protected String driverName;
    protected double ratePerKm;
    Vehicle(String v,String d,double r){
        vehicleId=v;
        driverName=d;
        ratePerKm=r;
    }
    abstract double calculateFare(double distance);
    void getVehicleDetails(){
        System.out.println(vehicleId+" "+driverName+" "+ratePerKm);
    }
}
class Car extends Vehicle{
    Car(String v,String d,double r){
        super(v,d,r);
    }
    double calculateFare(double dist){
        return dist*ratePerKm;
    }
}
class Bike extends Vehicle{
    Bike(String v,String d,double r){
        super(v,d,r);
    }
    double calculateFare(double dist){
        return(dist*ratePerKm)-10;
    }
}
class Auto extends Vehicle{
    Auto(String v,String d,double r){
        super(v,d,r);
    }
    double calculateFare(double dist){
        return(dist*ratePerKm)+20;
    }
}
public class Ride{
    public static void main(String[] args){
        Vehicle v1=new Car("V1","Ramesh",15);
        Vehicle v2=new Bike("V2","Suresh",10);
        Vehicle v3=new Auto("V3","Mahesh",12);
        System.out.println("Car Fare:"+v1.calculateFare(10));
        System.out.println("Bike Fare:"+v2.calculateFare(10));
        System.out.println("Auto Fare:"+v3.calculateFare(10));
    }
}

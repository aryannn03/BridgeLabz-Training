interface Insurable{
    double calculateInsurance();
}
abstract class Vehicle{
    protected double rate;
    Vehicle(double rate){
        this.rate=rate;
    }
    abstract double calculateRentalCost(int days);
}
class Car extends Vehicle implements Insurable{
    Car(double rate){
        super(rate);
    }
    double calculateRentalCost(int days){
        return rate*days;
    }
    public double calculateInsurance(){
        return 500;
    }
}
public class VehicleRental{
    public static void main(String[] args){
        Vehicle v=new Car(1000);
        System.out.println("Rental:"+v.calculateRentalCost(3));
    }
}

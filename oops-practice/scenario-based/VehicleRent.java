import java.util.*;
interface IRentable{
    double calculateRent(int days);
}
abstract class Vehicle implements IRentable{
    protected int vehicleId;
    protected String brand;
    protected double rentPerDay;
    Vehicle(int vehicleId,String brand,double rentPerDay){
        this.vehicleId=vehicleId;
        this.brand=brand;
        this.rentPerDay=rentPerDay;
    }
    int getVehicleId(){
        return vehicleId;
    }
    abstract void displayInfo();
}
class Bike extends Vehicle{
    Bike(int vehicleId,String brand,double rentPerDay){
        super(vehicleId,brand,rentPerDay);
    }
    public double calculateRent(int days){
        return days*rentPerDay;
    }
    void displayInfo(){
        System.out.println("Vehicle Type:Bike");
        System.out.println("ID:"+vehicleId);
        System.out.println("Brand:"+brand);
        System.out.println("Rent/Day:"+rentPerDay);
        System.out.println("-------------------");
    }
}
class Car extends Vehicle{
    Car(int vehicleId,String brand,double rentPerDay){
        super(vehicleId,brand,rentPerDay);
    }
    public double calculateRent(int days){
        return days*rentPerDay+500;
    }
    void displayInfo(){
        System.out.println("Vehicle Type:Car");
        System.out.println("ID:"+vehicleId);
        System.out.println("Brand:"+brand);
        System.out.println("Rent/Day:"+rentPerDay);
    }
}
class Truck extends Vehicle{
    Truck(int vehicleId,String brand,double rentPerDay){
        super(vehicleId,brand,rentPerDay);
    }
    public double calculateRent(int days){
        return days*rentPerDay+1000;
    }
    void displayInfo(){
        System.out.println("Vehicle Type:Truck");
        System.out.println("ID:"+vehicleId);
        System.out.println("Brand:"+brand);
        System.out.println("Rent/Day:"+rentPerDay);
    }
}
class Customer{
    int customerId;
    String name;
    Customer(int customerId,String name){
        this.customerId=customerId;
        this.name=name;
    }
    void displayCustomer(){
        System.out.println("Customer ID:"+customerId);
        System.out.println("Name:"+name);
    }
}
class VehicleRentalSystem{
    ArrayList<Vehicle> vehicles=new ArrayList<>();
    void addVehicle(Vehicle v){
        vehicles.add(v);
        System.out.println("Vehicle added");
    }
    void displayVehicles(){
        if(vehicles.isEmpty()){
            System.out.println("No vehicles available");
            return;
        }
        for(int i=0;i<vehicles.size();i++){
            vehicles.get(i).displayInfo();
        }
    }
    void removeVehicle(int id){
        for(int i=0;i<vehicles.size();i++){
            if(vehicles.get(i).getVehicleId()==id){
                vehicles.remove(i);
                System.out.println("Vehicle removed");
                return;
            }
        }
        System.out.println("Vehicle not found");
    }
    void rentVehicle(int id,int days){
        for(int i=0;i<vehicles.size();i++){
            Vehicle v=vehicles.get(i);
            if(v.getVehicleId()==id){
                System.out.println("Total Rent:"+v.calculateRent(days));
                return;
            }
        }
        System.out.println("Vehicle not found");
    }
}
public class VehicleRent{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        VehicleRentalSystem system=new VehicleRentalSystem();
        boolean loop=true;
        while(loop){
            System.out.println("1.Add Bike\n2.Add Car\n3.Add Truck\n4.Display Vehicles\n5.Remove Vehicle\n6.Calculate Rent\n0.Exit");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    system.addVehicle(new Bike(1,"Honda",300));
                    break;
                case 2:
                    system.addVehicle(new Car(2,"Hyundai",800));
                    break;
                case 3:
                    system.addVehicle(new Truck(3,"Tata",1500));
                    break;
                case 4:
                    system.displayVehicles();
                    break;
                case 5:
                    System.out.println("Enter vehicle ID");
                    system.removeVehicle(sc.nextInt());
                    break;
                case 6:
                    System.out.println("Enter vehicle ID");
                    int id=sc.nextInt();
                    System.out.println("Enter days");
                    int days=sc.nextInt();
                    system.rentVehicle(id,days);
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
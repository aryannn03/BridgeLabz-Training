interface Vehicle{
    void rent();
    void returnVehicle();
}
class Car implements Vehicle{
    public void rent(){
        System.out.println("Car rented");
    }
    public void returnVehicle(){
        System.out.println("Car returned");
    }
}
class Bike implements Vehicle{
    public void rent(){
        System.out.println("Bike rented");
    }
    public void returnVehicle(){
        System.out.println("Bike returned");
    }
}
class Bus implements Vehicle{
    public void rent(){
        System.out.println("Bus rented");
    }
    public void returnVehicle(){
        System.out.println("Bus returned");
    }
}
public class RentalSystem{
    public static void main(String[] args){
        Vehicle v1=new Car();
        Vehicle v2=new Bike();
        Vehicle v3=new Bus();
        v1.rent();
        v2.rent();
        v3.rent();
        v1.returnVehicle();
        v2.returnVehicle();
        v3.returnVehicle();
    }
}

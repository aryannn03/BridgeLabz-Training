interface VehicleDashboard{
    void displaySpeed();
    default void displayBattery(){
        System.out.println("Battery feature not available");
    }
}

class ElectricCar implements VehicleDashboard{
    public void displaySpeed(){
        System.out.println("Speed:80km/h");
    }
    public void displayBattery(){
        System.out.println("Battery:85%");
    }
}

public class DashboardApp{
    public static void main(String[] args){
        VehicleDashboard v=new ElectricCar();
        v.displaySpeed();
        v.displayBattery();
    }
}

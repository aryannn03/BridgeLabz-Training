interface Refuelable {
    void refuel();
}

class Vehicle {
    int maxSpeed;
    String model;

    Vehicle(int s,String m){
        maxSpeed=s;
        model=m;
    }
}

class ElectricVehicle extends Vehicle {
    ElectricVehicle(int s,String m){
        super(s,m);
    }

    void charge(){
        System.out.println("Charging vehicle");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    PetrolVehicle(int s,String m){
        super(s,m);
    }

    public void refuel(){
        System.out.println("Refueling petrol");
    }
}

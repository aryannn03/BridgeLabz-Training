class Vehicle {
    int maxSpeed;
    String fuel;

    Vehicle(int s,String f){
        maxSpeed=s;
        fuel=f;
    }

    void displayInfo(){
        System.out.println("Speed: "+maxSpeed);
        System.out.println("Fuel: "+fuel);
    }
}

class Car extends Vehicle {
    int seat;

    Car(int s,String f,int se){
        super(s,f);
        seat=se;
    }

    void displayInfo(){
        super.displayInfo();
        System.out.println("Seats: "+seat);
    }
}

class Truck extends Vehicle {
    int load;

    Truck(int s,String f,int l){
        super(s,f);
        load=l;
    }

    void displayInfo(){
        super.displayInfo();
        System.out.println("Load: "+load+" tons");
    }
}

class Motorcycle extends Vehicle {
    boolean helmet;

    Motorcycle(int s,String f,boolean h){
        super(s,f);
        helmet=h;
    }

    void displayInfo(){
        super.displayInfo();
        System.out.println("Helmet Required: "+helmet);
    }
}

public class Main {
    public static void main(String[] args){

        Vehicle[] v={
            new Car(180,"Petrol",5),
            new Truck(120,"Diesel",10),
            new Motorcycle(150,"Petrol",true)
        };

        for(Vehicle x:v){
            x.displayInfo();   // dynamic binding
            System.out.println();
        }
    }
}

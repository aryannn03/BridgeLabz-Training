public class Vehicle{
    String ownerName;
    String vehicleType;
    static int registrationFee=500;

    public Vehicle(String ownerName,String vehicleType){
        this.ownerName=ownerName;
        this.vehicleType=vehicleType;
    }

    void displayVehicleDetails(){
        System.out.println(ownerName+" "+vehicleType+" "+registrationFee);
    }

    static void updateRegistrationFee(int fee){
        registrationFee=fee;
    }

    public static void main(String[]args){
        Vehicle v=new Vehicle("Aryan","Bike");
        updateRegistrationFee(700);
        v.displayVehicleDetails();
    }
}

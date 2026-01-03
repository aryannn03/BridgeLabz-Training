class Device {
    String id;
    boolean status;

    Device(String i,boolean s){
        id=i;
        status=s;
    }
}

class Thermostat extends Device {
    int temp;

    Thermostat(String i,boolean s,int t){
        super(i,s);
        temp=t;
    }

    void displayStatus(){
        System.out.println("Device ID: "+id);
        System.out.println("Status: "+(status?"ON":"OFF"));
        System.out.println("Temp: "+temp+"°C");
    }
}

public class Main {
    public static void main(String[] args){
        Thermostat t=new Thermostat("TH101",true,24);
        t.displayStatus();
    }
}

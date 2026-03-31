import java.util.*;

class InvalidVehicleException extends Exception{
    public InvalidVehicleException(String msg){
        super(msg);
    }
}

abstract class Violation{
    private String type;
    public Violation(String type){
        this.type=type;
    }
    public String getType(){
        return type;
    }
    public abstract double calculateFine(int previousCount);
}

class SpeedViolation extends Violation{
    public SpeedViolation(){
        super("Speed");
    }
    public double calculateFine(int previousCount){
        double fine=1000;
        if(previousCount>1){
            fine=fine+500;
        }
        return fine;
    }
}

class SignalViolation extends Violation{
    public SignalViolation(){
        super("Signal");
    }
    public double calculateFine(int previousCount){
        double fine=500;
        if(previousCount>1){
            fine=fine+300;
        }
        return fine;
    }
}

class TrafficFineManager{
    private Map<String,List<Violation>> records=new HashMap<>();
    public void addViolation(String vehicleNumber,Violation violation)throws InvalidVehicleException{
        if(vehicleNumber==null||vehicleNumber.isEmpty()){
            throw new InvalidVehicleException("InvalidVehicle");
        }
        records.putIfAbsent(vehicleNumber,new ArrayList<>());
        records.get(vehicleNumber).add(violation);
    }
    public double calculateTotalFine(String vehicleNumber)throws InvalidVehicleException{
        if(!records.containsKey(vehicleNumber)){
            throw new InvalidVehicleException("VehicleNotFound");
        }
        List<Violation> list=records.get(vehicleNumber);
        double total=0;
        int count=0;
        for(Violation v:list){
            count++;
            total=total+v.calculateFine(count);
        }
        return total;
    }
    public void generateMonthlyReport(){
        System.out.println("MonthlyReport");
        for(Map.Entry<String,List<Violation>> entry:records.entrySet()){
            try{
                double total=calculateTotalFine(entry.getKey());
                System.out.println(entry.getKey()+"="+total);
            }catch(InvalidVehicleException e){}
        }
    }
}

public class SmartTrafficFineCollectionSystem{
    public static void main(String[] args){
        TrafficFineManager manager=new TrafficFineManager();
        try{
            manager.addViolation("HR01AB1234",new SpeedViolation());
            manager.addViolation("HR01AB1234",new SignalViolation());
            manager.addViolation("HR02CD5678",new SignalViolation());
        }catch(InvalidVehicleException e){}
        manager.generateMonthlyReport();
    }
}
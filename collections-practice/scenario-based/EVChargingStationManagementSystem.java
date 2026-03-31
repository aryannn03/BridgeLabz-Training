import java.util.*;

class NoChargingSlotAvailableException extends Exception{
    public NoChargingSlotAvailableException(String msg){
        super(msg);
    }
}

class Vehicle{
    private String number;
    private double unitsConsumed;
    public Vehicle(String number,double unitsConsumed){
        this.number=number;
        this.unitsConsumed=unitsConsumed;
    }
    public String getNumber(){
        return number;
    }
    public double getUnitsConsumed(){
        return unitsConsumed;
    }
}

interface PricingStrategy{
    double calculateBill(double units);
}

class NormalPricing implements PricingStrategy{
    public double calculateBill(double units){
        return units*10;
    }
}

class PeakHourPricing implements PricingStrategy{
    public double calculateBill(double units){
        return units*15;
    }
}

class ChargingSlot{
    private int slotId;
    private boolean occupied;
    private Vehicle vehicle;
    public ChargingSlot(int slotId){
        this.slotId=slotId;
        this.occupied=false;
    }
    public boolean isOccupied(){
        return occupied;
    }
    public void assignVehicle(Vehicle vehicle){
        this.vehicle=vehicle;
        this.occupied=true;
    }
    public void removeVehicle(){
        this.vehicle=null;
        this.occupied=false;
    }
    public Vehicle getVehicle(){
        return vehicle;
    }
}

class ChargingManager{
    private Map<Integer,ChargingSlot> slots=new TreeMap<>();
    private Queue<Vehicle> waitingQueue=new LinkedList<>();
    private PricingStrategy strategy;
    public ChargingManager(int totalSlots,PricingStrategy strategy){
        this.strategy=strategy;
        for(int i=1;i<=totalSlots;i++){
            slots.put(i,new ChargingSlot(i));
        }
    }
    public void addVehicle(Vehicle vehicle){
        try{
            allocate(vehicle);
        }catch(NoChargingSlotAvailableException e){
            waitingQueue.offer(vehicle);
        }
    }
    private void allocate(Vehicle vehicle)throws NoChargingSlotAvailableException{
        for(ChargingSlot slot:slots.values()){
            if(!slot.isOccupied()){
                slot.assignVehicle(vehicle);
                return;
            }
        }
        throw new NoChargingSlotAvailableException("NoSlot");
    }
    public void freeSlot(int slotId){
        ChargingSlot slot=slots.get(slotId);
        if(slot!=null&&slot.isOccupied()){
            double bill=strategy.calculateBill(slot.getVehicle().getUnitsConsumed());
            System.out.println("Bill="+bill);
            slot.removeVehicle();
            if(!waitingQueue.isEmpty()){
                Vehicle v=waitingQueue.poll();
                try{
                    allocate(v);
                }catch(NoChargingSlotAvailableException e){}
            }
        }
    }
}

public class EVChargingStationManagementSystem{
    public static void main(String[] args){
        PricingStrategy strategy=new PeakHourPricing();
        ChargingManager manager=new ChargingManager(2,strategy);
        manager.addVehicle(new Vehicle("EV1",20));
        manager.addVehicle(new Vehicle("EV2",15));
        manager.addVehicle(new Vehicle("EV3",10));
        manager.freeSlot(1);
        manager.freeSlot(2);
    }
}

import java.util.*;

class NoParkingSlotAvailableException extends Exception{
    public NoParkingSlotAvailableException(String msg){
        super(msg);
    }
}

abstract class Vehicle{
    private String number;
    public Vehicle(String number){
        this.number=number;
    }
    public String getNumber(){
        return number;
    }
}

class Car extends Vehicle{
    public Car(String number){
        super(number);
    }
}

class Bike extends Vehicle{
    public Bike(String number){
        super(number);
    }
}

class ParkingSlot{
    private int slotId;
    private boolean occupied;
    private Vehicle vehicle;
    public ParkingSlot(int slotId){
        this.slotId=slotId;
        this.occupied=false;
    }
    public boolean isOccupied(){
        return occupied;
    }
    public void park(Vehicle vehicle){
        this.vehicle=vehicle;
        this.occupied=true;
    }
    public void remove(){
        this.vehicle=null;
        this.occupied=false;
    }
    public int getSlotId(){
        return slotId;
    }
}

class ParkingManager{
    private Map<Integer,ParkingSlot> slots=new TreeMap<>();
    private Queue<Vehicle> waitingQueue=new LinkedList<>();
    public ParkingManager(int totalSlots){
        for(int i=1;i<=totalSlots;i++){
            slots.put(i,new ParkingSlot(i));
        }
    }
    public void addVehicle(Vehicle vehicle){
        try{
            allocateSlot(vehicle);
        }catch(NoParkingSlotAvailableException e){
            waitingQueue.offer(vehicle);
        }
    }
    private void allocateSlot(Vehicle vehicle)throws NoParkingSlotAvailableException{
        for(ParkingSlot slot:slots.values()){
            if(!slot.isOccupied()){
                slot.park(vehicle);
                return;
            }
        }
        throw new NoParkingSlotAvailableException("NoSlot");
    }
    public void freeSlot(int slotId){
        ParkingSlot slot=slots.get(slotId);
        if(slot!=null&&slot.isOccupied()){
            slot.remove();
            if(!waitingQueue.isEmpty()){
                Vehicle v=waitingQueue.poll();
                try{
                    allocateSlot(v);
                }catch(NoParkingSlotAvailableException e){}
            }
        }
    }
}

public class SmartParkingSlotAllocationSystem{
    public static void main(String[] args){
        ParkingManager manager=new ParkingManager(2);
        manager.addVehicle(new Car("C1"));
        manager.addVehicle(new Bike("B1"));
        manager.addVehicle(new Car("C2"));
        manager.freeSlot(1);
    }
}

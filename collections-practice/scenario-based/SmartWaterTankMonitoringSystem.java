import java.util.*;

class InvalidWaterLevelException extends Exception{
    public InvalidWaterLevelException(String msg){
        super(msg);
    }
}

class WaterTank{
    private int tankId;
    private double capacity;
    private double currentLevel;
    public WaterTank(int tankId,double capacity,double currentLevel)throws InvalidWaterLevelException{
        if(currentLevel>capacity){
            throw new InvalidWaterLevelException("InvalidLevel");
        }
        this.tankId=tankId;
        this.capacity=capacity;
        this.currentLevel=currentLevel;
    }
    public int getTankId(){
        return tankId;
    }
    public double getCapacity(){
        return capacity;
    }
    public double getCurrentLevel(){
        return currentLevel;
    }
    public double getUsagePercentage(){
        return(currentLevel/capacity)*100;
    }
    public void checkAlert(){
        if(getUsagePercentage()<20){
            System.out.println("AlertTank"+tankId);
        }
    }
}

public class SmartWaterTankMonitoringSystem{
    public static void main(String[] args){
        List<WaterTank> tanks=new ArrayList<>();
        try{
            tanks.add(new WaterTank(1,1000,150));
            tanks.add(new WaterTank(2,800,100));
            tanks.add(new WaterTank(3,1200,900));
        }catch(InvalidWaterLevelException e){}
        for(WaterTank t:tanks){
            t.checkAlert();
        }
        tanks.sort(new Comparator<WaterTank>(){
            public int compare(WaterTank a,WaterTank b){
                return Double.compare(a.getCurrentLevel(),b.getCurrentLevel());
            }
        });
        for(WaterTank t:tanks){
            System.out.println(t.getTankId()+"="+t.getCurrentLevel());
        }
    }
}

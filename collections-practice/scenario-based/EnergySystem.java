import java.util.*;
import java.text.*;

class InvalidEnergyReadingException extends Exception{
    public InvalidEnergyReadingException(String msg){
        super(msg);
    }
}

class EnergyMonitor{
    private Map<Date,List<Double>> usageMap=new HashMap<>();

    public void addReading(Date date,double value)throws InvalidEnergyReadingException{
        if(value<0){
            throw new InvalidEnergyReadingException("Invalid Energy Reading");
        }

        usageMap.putIfAbsent(date,new ArrayList<>());
        usageMap.get(date).add(value);
    }

    public double getDailyAverage(Date date){
        List<Double> list=usageMap.get(date);
        if(list==null||list.isEmpty())return 0;

        double sum=0;
        for(double v:list){
            sum+=v;
        }
        return sum/list.size();
    }

    public double getMonthlyAverage(){
        double sum=0;
        int count=0;

        for(List<Double> list:usageMap.values()){
            for(double v:list){
                sum+=v;
                count++;
            }
        }
        if(count==0)return 0;
        return sum/count;
    }
}

public class EnergySystem{
    public static void main(String[] args){
        try{
            EnergyMonitor monitor=new EnergyMonitor();
            Date today=new Date();

            monitor.addReading(today,5.5);
            monitor.addReading(today,6.0);
            monitor.addReading(today,4.5);

            System.out.println("Daily Average: "+monitor.getDailyAverage(today));
            System.out.println("Monthly Average: "+monitor.getMonthlyAverage());

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
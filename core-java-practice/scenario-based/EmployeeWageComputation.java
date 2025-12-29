import java.util.*;
public class EmployeeWageComputation {
    static final int wage_per_hour=20;
    static final int full_day_hour=8;
    static final int part_time_hour=8;
    public static void main(String args[]){
        displayWelcome();  
        attendance();  
        dailyWage(); 
        partTimeWage();  
        usingSwitch();  
        wageMonth(); 
        wageTillWorkingHour(); 
    }
    
    public static void displayWelcome(){
        System.out.println("Welcome to Employee Wage Computation");
    }
    
    public static void attendance(){
        int attend=(int)(Math.random()*2);
        if(attend==1)
            System.out.println("The Employee is present");
        else
            System.out.println("The Employee is not present");
    }
    
    public static void dailyWage(){
        int wage=wage_per_hour*full_day_hour;
        System.out.println("Daily Employee Wage: "+wage);
    }
    
    public static void partTimeWage(){
        int wage=part_time_hour*wage_per_hour;
        System.out.println("Part time wage of the Employee: "+wage);
    }
    
    public static void usingSwitch(){
        int attend=(int)(Math.random()*3);
        int hours=0;
        switch(attend){
            case 1:System.out.println("Employee is Fully Present");
            hours = full_day_hour;
            break;
            case 2:System.out.println("Employee is Partial Present");
            hours = part_time_hour;
            break;
            default:System.out.println("Employee is Absent");
            hours = 0;
        }
        int wage=hours*wage_per_hour;
        System.out.println("Wage: "+wage);
    }
    
    public static void wageMonth(){
        int totalHours = 0;
        int days = 0;
        while(days < 20){
            int attend = (int)(Math.random() * 3);
            switch(attend){
                case 1:totalHours += full_day_hour;
                break;
                case 2:totalHours += part_time_hour;
                break;
                default:totalHours += 0;
            }
            days++;
        }
        int wage = totalHours * wage_per_hour;
        System.out.println("Monthly Wage: " + wage);
    }
    
    public static void wageTillWorkingHour(){
        int hours=0;
        int working_day=0;
        while(working_day<=20 && hours<=100){
            working_day++;
            int attend=(int)(Math.random()*3);
            switch(attend){
            case 1:System.out.println("Employee is Fully Present");
            hours+=full_day_hour;
            break;
            case 2:System.out.println("Employee is Partial Present");
            hours+=part_time_hour;
            break;
            case 3:System.out.println("Employee is Absent");
            hours+=0;
            break;
            default:System.out.println("Wrong Choice");
            }
        }
        int wage=hours*wage_per_hour;
        System.out.println("Total working days:"+working_day);
        System.out.println("Total working hours: "+hours);
        System.out.println("Wage: "+wage);
    }
}
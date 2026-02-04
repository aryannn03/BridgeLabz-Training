import java.util.*;
import java.util.function.Predicate;

class Alert{
    String message;
    String type;
    Alert(String message,String type){
        this.message=message;
        this.type=type;
    }
    public String toString(){
        return "["+type+"] "+message;
    }
}

public class HospitalAlerts{
    public static void main(String[] args){
        List<Alert> alerts=List.of(
            new Alert("Doctor appointment","INFO"),
            new Alert("Emergency in ward 3","CRITICAL"),
            new Alert("Medicine reminder","INFO"),
            new Alert("Heart rate abnormal","CRITICAL")
        );
        Scanner ob=new Scanner(System.in);
        System.out.print("Enter alert type to filter(INFO/CRITICAL): ");
        String input=ob.nextLine();
        Predicate<Alert> criticalOnly=a->a.type.equalsIgnoreCase(input);
        alerts.stream().filter(criticalOnly).forEach(a->System.out.println(a));
    }
}

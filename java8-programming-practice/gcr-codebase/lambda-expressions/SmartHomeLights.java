import java.util.*;
interface LightTrigger{
    void activate();
}
public class SmartHomeLights{
    public static void main(String[] args){
        Map<String,LightTrigger> triggers=new HashMap<>();
        triggers.put("motion",()->System.out.println("Lights turned ON due to motion detected"));
        triggers.put("night",()->System.out.println("Dim lights activated for night mode"));
        triggers.put("voice",()->System.out.println("Lights controlled by voice command"));
        Scanner ob=new Scanner(System.in);
        System.out.print("Enter trigger(motion/night/voice): ");
        String input=ob.nextLine();
        LightTrigger action=triggers.get(input);
        if(action!=null){
            action.activate();
        }else{
            System.out.println("No trigger found");
        }
    }
}

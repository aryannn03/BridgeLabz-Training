import java.util.function.Predicate;

public class TemperatureAlert{
    public static void main(String[] args){
        Predicate<Double> isHigh=temp->temp>40;
        double temperature=45;
        if(isHigh.test(temperature)){
            System.out.println("High Temperature Alert!");
        }else{
            System.out.println("Temperature Normal");
        }
    }
}

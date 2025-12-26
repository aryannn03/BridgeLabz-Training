import java.util.Scanner;

public class SimpleInterestMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double principal=sc.nextDouble();
        double rate=sc.nextDouble();
        double time=sc.nextDouble();
        double si = calculateSimpleInterest(principal, rate, time);
        System.out.printf("The Simple Interest is %.2f for Principal %.2f, Rate of Interest %.2f and Time %.2f",si, principal, rate, time);    
    }
    public static double calculateSimpleInterest(double principle, double rate, double time){
        double si=(principle*rate*time)/100;
        return si;
    } 
}

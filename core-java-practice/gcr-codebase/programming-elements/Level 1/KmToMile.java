import java.util.Scanner;

public class KmToMile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double km=sc.nextDouble();
        System.out.println("The total miles is "+ (1.6*km)+" mile for the given "+km+" km");
    }
}

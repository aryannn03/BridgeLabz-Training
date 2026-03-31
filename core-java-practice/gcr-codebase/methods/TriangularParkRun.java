import java.util.Scanner;

public class TriangularParkRun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double side1=sc.nextDouble();
        double side2=sc.nextDouble();
        double side3=sc.nextDouble();
        double rounds=calculateRounds(side1, side2, side3);
        System.out.printf("The athlete needs to complete %.2f rounds to finish a 5 km run", rounds);
    }

    public static double calculateRounds(double a, double b, double c) {
        double perimeter=a + b + c;
        double totalDistance=5000; 
        return totalDistance/perimeter;
    }
}

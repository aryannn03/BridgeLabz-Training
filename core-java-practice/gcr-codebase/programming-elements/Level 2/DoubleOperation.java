import java.util.*;

public class DoubleOperation {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double op1 = a + b *c;
        double op2 =  a * b + c;
        double op3 = c + a / b;
        double op4 =  a % b + c;
        System.out.println("The results of Double Operations are "+op1+", "+op2+", "+op3+" and "+op4);
    }        
}
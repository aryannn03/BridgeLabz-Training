import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        double n1=sc.nextDouble();
        double n2=sc.nextDouble();
        double add=n1+n2;
        double sub=n1-n2;
        double mul=n1*n2;
        double div=n1/n2;
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers "+n1+" and "+n2+" is "+add+", "+sub+", "+mul+", and "+div);
    }
}

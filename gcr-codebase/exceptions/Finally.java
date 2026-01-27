import java.util.*;
public class Finally {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try {
            System.out.print("Enter first number:");
            int a=sc.nextInt();
            System.out.print("Enter second number:");
            int b=sc.nextInt();
            System.out.println("Result:"+(a/b));
        } catch(ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        } finally {
            System.out.println("Operation completed");
        }
    }
}
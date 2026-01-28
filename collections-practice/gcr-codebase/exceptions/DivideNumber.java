import java.util.*;
public class DivideNumber {
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        try {
            System.out.print("Enter first number:");
            int a=ob.nextInt();
            System.out.print("Enter second number:");
            int b=ob.nextInt();
            int result=a/b;
            System.out.println("Result:"+result);
        } catch(ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        } catch(InputMismatchException e) {
            System.out.println("Please enter numeric values only");
        } finally {
            System.out.println("Execution completed.");
        }
    }
}
import java.util.Scanner;

public class FactorialRecursive{
    static int factorial(int n){
        if(n==0||n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        System.out.println("Factorial="+factorial(number));
    }
}

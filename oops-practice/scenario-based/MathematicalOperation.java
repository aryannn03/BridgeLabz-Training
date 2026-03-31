import java.util.*;
class MathUtility{
    static long factorial(int n){
        if(n<0)
            return-1;
        long fact=1;
        for(int i=1;i<=n;i++){
            fact*=i;
        }
        return fact;
    }
    static boolean isPrime(int n){
        if(n<=1)
            return false;
        for(int i=2;i<=n/2;i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
    static int gcd(int a,int b){
        if(a<0||b<0)
            return-1;
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    static int fibonacci(int n){
        if(n<0)
            return-1;
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        int a=0,b=1,c=0;
        for(int i=2;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
public class MathematicalOperation{
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        System.out.print("Enter number for factorial:");
        int n=ob.nextInt();
        System.out.println("Factorial:"+MathUtility.factorial(n));
        System.out.print("Enter number to check prime:");
        int p=ob.nextInt();
        System.out.println("Is Prime:"+MathUtility.isPrime(p));
        System.out.print("Enter two numbers for GCD:");
        int a=ob.nextInt();
        int b=ob.nextInt();
        System.out.println("GCD:"+MathUtility.gcd(a,b));
        System.out.print("Enter n for Fibonacci:");
        int f=ob.nextInt();
        System.out.println("Fibonacci:"+MathUtility.fibonacci(f));
    }
}
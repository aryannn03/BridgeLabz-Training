import java.util.Scanner;

public class NumberChecker5{
    public static int sumOfProperDivisors(int number){
        int sum=0;
        for(int i=1;i<=number/2;i++)
            if(number%i==0)
                sum+=i;
        return sum;
    }
    public static boolean isPerfect(int number){
        return number>0&&sumOfProperDivisors(number)==number;
    }
    public static boolean isAbundant(int number){
        return number>0&&sumOfProperDivisors(number)>number;
    }
    public static boolean isDeficient(int number){
        return number>0&&sumOfProperDivisors(number)<number;
    }
    public static int factorial(int n){
        int fact=1;
        for(int i=1;i<=n;i++)
            fact*=i;
        return fact;
    }
    public static boolean isStrong(int number){
        int temp=number;
        int sum=0;
        while(temp!=0){
            int digit=temp%10;
            sum+=factorial(digit);
            temp/=10;
        }
        return sum==number;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();

        System.out.println(isPerfect(number));
        System.out.println(isAbundant(number));
        System.out.println(isDeficient(number));
        System.out.println(isStrong(number));
    }
}

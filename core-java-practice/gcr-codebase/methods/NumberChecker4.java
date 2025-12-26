import java.util.Scanner;

public class NumberChecker4{
    public static boolean isPrime(int number){
        if(number<=1)
            return false;
        for(int i=2;i<=number/2;i++)
            if(number%i==0)
                return false;
        return true;
    }
    public static boolean isNeon(int number){
        int square=number*number;
        int sum=0;
        while(square!=0){
            sum+=square%10;
            square/=10;
        }
        return sum==number;
    }
    public static boolean isSpy(int number){
        int sum=0;
        int product=1;
        while(number!=0){
            int digit=number%10;
            sum+=digit;
            product*=digit;
            number/=10;
        }
        return sum==product;
    }
    public static boolean isAutomorphic(int number){
        int square=number*number;
        int temp=number;
        while(temp!=0){
            if(temp%10!=square%10)
                return false;
            temp/=10;
            square/=10;
        }
        return true;
    }
    public static boolean isBuzz(int number){
        return number%7==0||number%10==7;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();

        System.out.println(isPrime(number));
        System.out.println(isNeon(number));
        System.out.println(isSpy(number));
        System.out.println(isAutomorphic(number));
        System.out.println(isBuzz(number));
    }
}

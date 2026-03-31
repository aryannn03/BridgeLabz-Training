import java.util.Scanner;

public class GcdLcmCalculator {
    static int findGcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    static int findLcm(int a,int b){
        return(a*b)/findGcd(a,b);
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println("GCD="+findGcd(a,b));
        System.out.println("LCM="+findLcm(a,b));
    }
}

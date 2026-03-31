import java.util.Scanner;

public class NaturalNumberSum{
    public static int recursiveSum(int n){
        if(n==0)return 0;
        return n+recursiveSum(n-1);
    }

    public static int formulaSum(int n){
        return n*(n+1)/2;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n<=0)return;
        int r1=recursiveSum(n);
        int r2=formulaSum(n);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r1==r2);
    }
}

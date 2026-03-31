import java.util.Scanner;

public class NumberFactors{
    public static int[] findFactors(int number){
        int count=0;
        for(int i=1;i<=number;i++){
            if(number%i==0)
                count++;
        }

        int[] factors=new int[count];
        int idx=0;

        for(int i=1;i<=number;i++){
            if(number%i==0)
                factors[idx++]=i;
        }
        return factors;
    }
    public static int greatestFactor(int[] factors){
        return factors[factors.length-2];
    }
    public static int sumOfFactors(int[] factors){
        int sum=0;
        for(int i:factors)
            sum+=i;
        return sum;
    }
    public static int productOfFactors(int[] factors){
        int product=1;
        for(int i:factors)
            product*=i;
        return product;
    }
    public static double productOfCubeOfFactors(int[] factors){
        double product=1;
        for(int i:factors)
            product*=Math.pow(i,3);
        return product;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();

        int[] factors=findFactors(number);

        System.out.println(greatestFactor(factors));
        System.out.println(sumOfFactors(factors));
        System.out.println(productOfFactors(factors));
        System.out.println(productOfCubeOfFactors(factors));
    }
}

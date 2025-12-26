import java.util.Scanner;

public class ChocolatesDistribution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chocolates=sc.nextInt();
        int children=sc.nextInt();
        int arr[]=findRemainderAndQuotient(chocolates, children);
        System.out.println("The number of chocolates each child gets is "+arr[0]);
        System.out.println("The number of remaining chocolates is "+arr[0]);
    }    
    public static int [] findRemainderAndQuotient(int number, int divisor){
        return new int[]{number/divisor,number%divisor};
    }
}

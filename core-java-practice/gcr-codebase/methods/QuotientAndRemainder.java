import java.util.Arrays;

public class QuotientAndRemainder{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number=sc.nextInt();
        int divisor=sc.nextInt();
        int arr[]=findRemainderAndQuotient(chocolates, children);
        System.out.println("Quotient is "+arr[0]);
        System.out.println("Remainder is "+arr[0]);
    }    
    public static int [] findRemainderAndQuotient(int number, int divisor){
        return new int[]{number/divisor,number%divisor};
    }
}
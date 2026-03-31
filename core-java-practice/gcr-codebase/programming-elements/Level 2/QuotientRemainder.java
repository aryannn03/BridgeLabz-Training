import java.util.*;

public class QuotientRemainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int div = n/m;
        int mod = n%m;
        System.out.println("the Quotient is" + div + "and Remainder is" + mod + "of two number is " + n + " and "  + m );
        
    }
    
}
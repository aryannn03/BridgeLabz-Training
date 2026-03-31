import java.util.Scanner;

public class MaximumNumberOfHandshakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("The maximum number of possible handshakes is "+maximum(n));    
    }
    public static int maximum(int n){
        return (n*(n-1))/2;
    }
}

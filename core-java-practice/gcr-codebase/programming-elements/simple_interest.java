import java.util.Scanner;

public class simple_interest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int principle=sc.nextInt();
        int rate=sc.nextInt();
        int time=sc.nextInt();
        System.out.print((principle*rate*time)/100);
    }    
}

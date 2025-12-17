import java.util.Scanner;

public class power {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int base=sc.nextInt();
        int exp=sc.nextInt();
        System.out.print(Math.pow(base,exp));
    }    
}

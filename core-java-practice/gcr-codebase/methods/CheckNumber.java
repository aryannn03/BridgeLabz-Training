import java.util.Scanner;

public class CheckNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(checkNumber(n));
    }
    public static int checkNumber(int n){
        if(n==0){
            return 0;
        }
        if(n>0){
            return 1;
        }
        return -1;
    }
}

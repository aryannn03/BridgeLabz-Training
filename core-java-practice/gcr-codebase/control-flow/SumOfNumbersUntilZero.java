import java.util.Scanner;

public class SumOfNumbersUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total=0.0d;
        double user;
        while(true){
            user=sc.nextDouble();
            if(user==0){
                break;
            }
            else{
                total+=user;
            }
        }
        System.out.println(total);
    }
}
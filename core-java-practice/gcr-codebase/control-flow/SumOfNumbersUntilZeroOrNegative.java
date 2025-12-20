import java.util.Scanner;

public class SumOfNumbersUntilZeroOrNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        double num;
        double total=0;
        while(true){
            num=sc.nextDouble();
            if(num>0){
                total+=num;
            }
            else{
                break;
            }
        }
        System.out.println(total);
    }
}

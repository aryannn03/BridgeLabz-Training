import java.util.*;
public class LargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1=sc.nextInt();
        int num2=sc.nextInt();
        int num3=sc.nextInt();
        if(num1>num2 && num1>num3){
            System.out.println("Is the first number the largest? Yes");
        }
        else{
            System.out.println("Is the first number the largest? Yes");
        }
        if(num2>num1 && num2>num3){
            System.out.println("Is the second number the largest? Yes");
        }
        else{
            System.out.println("Is the second number the largest? Yes");
        }
        if(num3>num2 && num3>num1){
            System.out.println("Is the third number the largest? Yes");
        }
        else{
            System.out.println("Is the third number the largest? Yes");
        }
        
    }
}

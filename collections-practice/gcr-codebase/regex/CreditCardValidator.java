import java.util.*;
public class CreditCardValidator{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        if(s.matches("4\\d{15}")||s.matches("5\\d{15}")){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }
    }
}

import java.util.*;
public class ValidUsername{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        if(s.matches("[A-Za-z][A-Za-z0-9_]{4,14}")){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }
    }
}

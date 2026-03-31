import java.util.*;
public class LicensePlateValidator{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        if(s.matches("[A-Z]{2}[0-9]{4}")){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }
    }
}

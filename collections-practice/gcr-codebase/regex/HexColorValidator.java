import java.util.*;
public class HexColorValidator{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        if(s.matches("#[A-Fa-f0-9]{6}")){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }
    }
}

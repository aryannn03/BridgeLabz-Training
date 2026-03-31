import java.util.*;
public class IPv4Validator{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String p="^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$";
        if(s.matches(p)){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }
    }
}

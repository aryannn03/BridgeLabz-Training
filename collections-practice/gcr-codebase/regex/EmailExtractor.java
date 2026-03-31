import java.util.*;
import java.util.regex.*;
public class EmailExtractor{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Pattern p=Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");
        Matcher m=p.matcher(s);
        while(m.find()){
            System.out.println(m.group());
        }
    }
}

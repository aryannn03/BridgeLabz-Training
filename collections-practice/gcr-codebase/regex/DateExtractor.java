import java.util.*;
import java.util.regex.*;
public class DateExtractor{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Pattern p=Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b");
        Matcher m=p.matcher(s);
        boolean first=true;
        while(m.find()){
            if(!first){
                System.out.print(", ");
            }
            System.out.print(m.group());
            first=false;
        }
    }
}

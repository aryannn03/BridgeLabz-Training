import java.util.*;
import java.util.regex.*;
public class CapitalizedWordExtractor{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Pattern p=Pattern.compile("\\b[A-Z][a-z]*\\b");
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

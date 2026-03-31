import java.util.*;
import java.util.regex.*;
public class RepeatingWordFinder{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Pattern p=Pattern.compile("\\b(\\w+)\\b(?:\\s+\\1\\b)+",Pattern.CASE_INSENSITIVE);
        Matcher m=p.matcher(s);
        boolean first=true;
        while(m.find()){
            if(!first){
                System.out.print(", ");
            }
            System.out.print(m.group(1));
            first=false;
        }
    }
}

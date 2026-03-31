import java.util.*;
import java.util.regex.*;
public class ProgrammingLanguageExtractor{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Pattern p=Pattern.compile("\\b(Java|Python|JavaScript|Go|C\\+\\+|C#|Ruby|Kotlin|Swift)\\b");
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

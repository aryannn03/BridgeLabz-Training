import java.util.*;
public class BadWordCensor{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[]bad=sc.nextLine().split(" ");
        for(String w:bad){
            s=s.replaceAll("\\b"+w+"\\b","****");
        }
        System.out.println(s);
    }
}

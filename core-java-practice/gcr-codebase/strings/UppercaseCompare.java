import java.util.Scanner;
public class UppercaseCompare{
    public static String toUpper(String text){
        String result="";
        for(int i=0;i<text.length();i++){
            char value=text.charAt(i);
            if(value>='a'&&value<='z'){
                value=(char)(value-32);
            }
            result+=value;
        }
        return result;
    }
    public static boolean compareStrings(String first,String second){
        if(first.length()!=second.length()){
            return false;
        }
        for(int i=0;i<first.length();i++){
            if(first.charAt(i)!=second.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine();
        String customUpper=toUpper(text);
        String builtInUpper=text.toUpperCase();
        System.out.println(compareStrings(customUpper,builtInUpper));
    }
}

import java.util.Scanner;
public class LowercaseCompare{
    public static String toLower(String text){
        String result="";
        for(int i=0;i<text.length();i++){
            char value=text.charAt(i);
            if(value>='A'&&value<='Z'){
                value=(char)(value+32);
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
        String customLower=toLower(text);
        String builtInLower=text.toLowerCase();
        System.out.println(compareStrings(customLower,builtInLower));
    }
}

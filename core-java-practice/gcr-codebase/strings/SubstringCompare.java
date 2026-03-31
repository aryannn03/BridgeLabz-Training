import java.util.Scanner;
public class SubstringCompare{
    public static String createSubstring(String text,int start,int end){
        String result="";
        for(int i=start;i<end;i++){
            result+=text.charAt(i);
        }
        return result;
    }
    public static boolean compareUsingCharAt(String first,String second){
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
        String text=sc.next();
        int start=sc.nextInt();
        int end=sc.nextInt();
        String customSub=createSubstring(text,start,end);
        String builtInSub=text.substring(start,end);
        System.out.println(compareUsingCharAt(customSub,builtInSub));
    }
}

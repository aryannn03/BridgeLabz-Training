import java.util.Scanner;
public class TrimCompare{
    public static int[]findBounds(String text){
        int start=0;
        int end=text.length()-1;
        while(text.charAt(start)==' '){
            start++;
        }
        while(text.charAt(end)==' '){
            end--;
        }
        return new int[]{start,end+1};
    }
    public static String createSubstring(String text,int start,int end){
        String result="";
        for(int i=start;i<end;i++){
            result+=text.charAt(i);
        }
        return result;
    }
    public static boolean compare(String first,String second){
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
        int[]bounds=findBounds(text);
        String custom=createSubstring(text,bounds[0],bounds[1]);
        String builtIn=text.trim();
        System.out.println(compare(custom,builtIn));
    }
}

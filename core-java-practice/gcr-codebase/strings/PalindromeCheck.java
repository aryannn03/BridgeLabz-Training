import java.util.Scanner;
public class PalindromeCheck{
    public static boolean logicOne(String text){
        int start=0,end=text.length()-1;
        while(start<end){
            if(text.charAt(start)!=text.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static boolean logicTwo(String text,int start,int end){
        if(start>=end){
            return true;
        }
        if(text.charAt(start)!=text.charAt(end)){
            return false;
        }
        return logicTwo(text,start+1,end-1);
    }
    public static boolean logicThree(String text){
        char[]original=text.toCharArray();
        char[]reverse=new char[original.length];
        for(int i=0;i<original.length;i++){
            reverse[i]=text.charAt(original.length-1-i);
        }
        for(int i=0;i<original.length;i++){
            if(original[i]!=reverse[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine();
        System.out.println(logicOne(text));
        System.out.println(logicTwo(text,0,text.length()-1));
        System.out.println(logicThree(text));
    }
}

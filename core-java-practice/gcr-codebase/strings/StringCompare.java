import java.util.Scanner;
public class StringCompare{
    public static boolean compareUsingCharAt(String first,String second){
        if(first.length()!=second.length()){
            return false;
        }
        for(int index=0;index<first.length();index++){
            if(first.charAt(index)!=second.charAt(index)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String first=sc.next();
        String second=sc.next();
        boolean charResult=compareUsingCharAt(first,second);
        boolean builtInResult=first.equals(second);
        System.out.println(charResult==builtInResult);
    }
}

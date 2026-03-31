import java.util.Scanner;
public class LexicographicalCompare{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String first=sc.next();
        String second=sc.next();
        int min=first.length()<second.length()?first.length():second.length();
        for(int i=0;i<min;i++){
            if(first.charAt(i)<second.charAt(i)){
                System.out.println(first+" comes before "+second);
                return;
            }else if(first.charAt(i)>second.charAt(i)){
                System.out.println(second+" comes before "+first);
                return;
            }
        }
        if(first.length()<second.length()){
            System.out.println(first+" comes before "+second);
        }else if(first.length()>second.length()){
            System.out.println(second+" comes before "+first);
        }else{
            System.out.println("Both strings are equal");
        }
    }
}

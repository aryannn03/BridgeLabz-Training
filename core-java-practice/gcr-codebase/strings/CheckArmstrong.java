import java.util.Scanner;
public class CheckArmstrong{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String first=sc.next();
        String second=sc.next();
        if(first.length()!=second.length()){
            System.out.println("Not Anagrams");
            return;
        }
        int[]freq=new int[256];
        for(int i=0;i<first.length();i++){
            freq[first.charAt(i)]++;
            freq[second.charAt(i)]--;
        }
        for(int i=0;i<256;i++){
            if(freq[i]!=0){
                System.out.println("Not Anagrams");
                return;
            }
        }
        System.out.println("Anagrams");
    }
}

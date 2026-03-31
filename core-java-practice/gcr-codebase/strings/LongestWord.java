import java.util.Scanner;

public class LongestWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(longestWord(s));
    }   
    public static String longestWord(String s){
        String ans="";
        int l=0;
        String arr[]=s.split(" ");
        for(int i=0;i<arr.length;i++){
            if(arr[i].length()>l){
                l=arr[i].length();
                ans=arr[i];
            }
        }
        return ans;
    } 
}

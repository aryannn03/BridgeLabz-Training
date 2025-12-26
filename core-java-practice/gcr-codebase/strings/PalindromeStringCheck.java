import java.util.Scanner;

public class PalindromeStringCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        int l=0;
        int r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                System.out.print("String is not palindrome");
                return ;
            }
            l++;
            r--;
        }
        System.out.print("String is palindrome");
    }    
}

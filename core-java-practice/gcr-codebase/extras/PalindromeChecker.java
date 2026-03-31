import java.util.Scanner;

public class PalindromeChecker{
    static String takeInput(Scanner sc){
        return sc.nextLine();
    }
    static boolean isPalindrome(String text){
        int left=0,right=text.length()-1;
        while(left<right){
            if(text.charAt(left)!=text.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    static void displayResult(boolean result){
        if(result){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String text=takeInput(sc);
        displayResult(isPalindrome(text));
    }
}

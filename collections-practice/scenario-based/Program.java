import java.util.*;
public class Program {
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the word");
        String word=ob.nextLine();
        String result=CleanseAndInvert(word);
        if(result.equals("")) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("The generated key is - "+result);
        }
    }
    public static String CleanseAndInvert(String input) {
        if(input==null||input.length()<6) {
            return "";
        }
        for(int i=0;i<input.length();i++) {
            char ch=input.charAt(i);
            if(!Character.isLetter(ch)) {
                return "";
            }
        }
        String lower=input.toLowerCase();
        StringBuilder filtered=new StringBuilder();
        for(int i=0;i<lower.length();i++) {
            int ascii=(int)lower.charAt(i);
            if(ascii%2!=0) {
                filtered.append(lower.charAt(i));
            }
        }
        filtered.reverse();
        StringBuilder answer=new StringBuilder();
        for(int i=0;i<filtered.length();i++) {
            char ch=filtered.charAt(i);
            if(i%2==0) {
                answer.append(Character.toUpperCase(ch));
            } else {
                answer.append(ch);
            }
        }
        return answer.toString();
    }
}
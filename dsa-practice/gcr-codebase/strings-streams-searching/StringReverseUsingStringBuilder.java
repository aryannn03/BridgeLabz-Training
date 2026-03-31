import java.util.Scanner;

public class StringReverseUsingStringBuilder {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String input= sc.nextLine();
        String reversed= reverseString(input);
        System.out.println(reversed);
        sc.close();
    }    
    public static String reverseString(String s) {
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
}

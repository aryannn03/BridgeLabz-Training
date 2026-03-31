import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String input= sc.nextLine();    
        String st = removeDuplicates(input);
        System.out.println(st);
        sc.close();
    }
    public static String removeDuplicates(String s) {
        HashSet<Character> seen = new HashSet<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!seen.contains(ch)){
                sb.append(ch);
                seen.add(ch);
            }
        }
        return sb.toString();
    }   
}

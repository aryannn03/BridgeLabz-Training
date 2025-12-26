import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        System.out.println(removeDuplicates(s));
    }   
    public static String removeDuplicates(String s){
        StringBuilder sb=new StringBuilder();
        boolean chk[]= new boolean[123];
        for(int i=0;i<s.length();i++){
            if(!chk[s.charAt(i)]){
                sb.append(s.charAt(i));
            }
            chk[s.charAt(i)]=true;
        }
        return sb.toString();
    } 
}

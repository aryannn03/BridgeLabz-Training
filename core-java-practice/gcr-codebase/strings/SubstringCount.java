import java.util.Scanner;
public class SubstringCount{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine();
        String sub=sc.nextLine();
        int count=0;
        for(int i=0;i<=text.length()-sub.length();i++){
            int j=0;
            while(j<sub.length()&&text.charAt(i+j)==sub.charAt(j)){
                j++;
            }
            if(j==sub.length()){
                count++;
            }
        }
        System.out.println("Occurrences : "+count);
    }
}

import java.util.Scanner;
public class RemoveCharacter{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine();
        char remove=sc.next().charAt(0);
        String result="";
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)!=remove){
                result+=text.charAt(i);
            }
        }
        System.out.println("Modified String: "+result);
    }
}

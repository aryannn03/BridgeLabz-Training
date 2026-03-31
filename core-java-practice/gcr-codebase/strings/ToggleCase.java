import java.util.Scanner;
public class ToggleCase{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine();
        String result="";
        for(int i=0;i<text.length();i++){
            char ch=text.charAt(i);
            if(ch>='A'&&ch<='Z'){
                result+=(char)(ch+32);
            }else if(ch>='a'&&ch<='z'){
                result+=(char)(ch-32);
            }else{
                result+=ch;
            }
        }
        System.out.println(result);
    }
}

import java.util.*;

public class StringFormatting{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the paragraph");
        String para=sc.nextLine();
        para=extraSpace(para);
        para=punctuationSpace(para);
        para=capital(para);
        System.out.println("New String after formatting is:");
        System.out.println(para);
    }
    public static String extraSpace(String para){
        para=para.trim();
        StringBuilder sb=new StringBuilder();
        boolean space=false;
        for(int i=0;i<para.length();i++){
            char ch=para.charAt(i);
            if(ch==' '){
                if(!space){
                    sb.append(ch);
                    space=true;
                }
            }else{
                sb.append(ch);
                space=false;
            }
        }
        return sb.toString();
    }
    public static String punctuationSpace(String para){
        StringBuilder newPara=new StringBuilder();
        for(int i=0;i<para.length();i++){
            char ch=para.charAt(i);
            newPara.append(ch);
            if(ch=='.'||ch=='?'||ch=='!'){
                if(i+1<para.length()&&para.charAt(i+1)!=' '){
                    newPara.append(' ');
                }
            }
        }
        return newPara.toString();
    }
    public static String capital(String para){
        StringBuilder newPara=new StringBuilder();
        boolean cap=true;
        for(int i=0;i<para.length();i++){
            char ch=para.charAt(i);
            if(cap&&ch>='a'&&ch<='z'){
                newPara.append(Character.toUpperCase(ch));
                cap=false;
            }else{
                newPara.append(ch);
            }
            if(ch=='.'||ch=='?'||ch=='!'){
                cap=true;
            }
        }
        return newPara.toString();
    }
}
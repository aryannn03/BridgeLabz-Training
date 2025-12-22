import java.util.Scanner;
public class StringIndexOutOfBoundsException{
    public static void generateException(String text){
        text.charAt(text.length()+1);
    }
    public static void handleException(String text){
        try{
            text.charAt(text.length()+1);
        }catch(StringIndexOutOfBoundsException exception){
            System.out.println("StringIndexOutOfBoundsException handled");
        }
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String text=sc.next();
        try{
            generateException(text);
        }catch(Exception e){
        }
        handleException(text);
    }
}

import java.util.Scanner;
public class IllegalArgumentException{
    public static void generateException(String text){
        text.substring(5,2);
    }
    public static void handleException(String text){
        try{
            text.substring(5,2);
        }catch(IllegalArgumentException exception){
            System.out.println("IllegalArgumentException handled");
        }catch(RuntimeException exception){
            System.out.println("RuntimeException handled");
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

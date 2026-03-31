import java.util.Scanner;
public class ArrayIndexOutOfBoundsException{
    public static void generateException(String[]names){
        System.out.println(names[names.length+1]);
    }
    public static void handleException(String[]names){
        try{
            System.out.println(names[names.length+1]);
        }catch(ArrayIndexOutOfBoundsException exception){
            System.out.println("ArrayIndexOutOfBoundsException handled");
        }catch(RuntimeException exception){
            System.out.println("RuntimeException handled");
        }
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        String[]names=new String[size];
        for(int i=0;i<size;i++){
            names[i]=sc.next();
        }
        try{
            generateException(names);
        }catch(Exception e){
        }
        handleException(names);
    }
}

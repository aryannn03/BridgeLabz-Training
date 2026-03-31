import java.util.Scanner;

public class BasicCalculator{
    static int add(int a,int b){return a+b;}
    static int subtract(int a,int b){return a-b;}
    static int multiply(int a,int b){return a*b;}
    static double divide(int a,int b){return(double)a/b;}
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int choice=sc.nextInt();
        if(choice==1){
            System.out.println(add(a,b));
        }
        else if(choice==2){
            System.out.println(subtract(a,b));
        }
        else if(choice==3){
            System.out.println(multiply(a,b));
        }
        else if(choice==4){
            System.out.println(divide(a,b));
        }
    }
}

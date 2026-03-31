import java.util.Scanner;

public class Distance {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int dist=sc.nextInt();
        System.out.println("The distance in yards is "+(dist/3)+" while distance in miles is "+((dist/3)/1760));    
    }    
}

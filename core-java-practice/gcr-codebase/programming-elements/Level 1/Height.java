import java.util.Scanner;

public class Height {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double height=sc.nextDouble();
        double feet=height/2.54/12;
        System.out.print("Your Height in cm is "+height+" while in feet is "+(feet)+" and inches is "+(height/2.54));
    }
}

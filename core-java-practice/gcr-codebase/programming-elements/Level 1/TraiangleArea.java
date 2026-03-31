import java.util.Scanner;

public class TraiangleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base=sc.nextInt();
        int height=sc.nextInt();
        System.out.println("The Area of Traingle is "+(0.5*base*height)+" whose base is "+base+" and height is "+height);
    }
}

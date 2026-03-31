import java.util.Scanner;

public class PerimeterOfRectangle {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int length=sc.nextInt();
        int breadth=sc.nextInt();
        System.out.print(2*(length+breadth));
    }    
}

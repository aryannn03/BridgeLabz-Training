import java.util.Scanner;

public class SquareLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int perimeter=sc.nextInt();
        System.out.println("The length of the side is "+(perimeter/4)+" whose perimeter is "+perimeter);
    }    
}
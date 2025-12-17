import java.util.Scanner;

public class volume_of_cylinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int radius=sc.nextInt();
        int height=sc.nextInt();
        System.out.print(3.14*radius*radius*height);
    }    
}

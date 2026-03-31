import java.util.Scanner;

public class VolumeOfCylinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int radius=sc.nextInt();
        int height=sc.nextInt();
        System.out.print(3.14*radius*radius*height);
    }    
}

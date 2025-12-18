import java.util.Scanner;

public class HandShakes {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int numberOfStudents=sc.nextInt();
        System.out.println("The maximum number of possible handshakes is "+(numberOfStudents * (numberOfStudents - 1)) / 2);
    }    
}

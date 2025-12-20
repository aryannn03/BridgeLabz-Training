import java.util.Scanner;

public class MutiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number=sc.nextInt();
        for(int i=6;i<=9;i++){
            System.out.printf("%d * %d = %d\n",number,i,(number*i));
        }
    }    
}

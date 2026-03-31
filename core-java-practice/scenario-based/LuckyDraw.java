import java.util.Scanner;

public class LuckyDraw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         while(true){
            int number=sc.nextInt();
            if(number==-1){
                break;
            }
            if(number<=0){
                System.out.println("Invalid Number");
                continue;
            }
            if(number%3==0&&number%5==0){
                System.out.println("You Win a Gift");
            }
            else{
                System.out.println("Better Luck Next Time");
            }
        }
    } 
}

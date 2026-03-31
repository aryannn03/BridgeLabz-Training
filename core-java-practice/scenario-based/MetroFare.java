import java.util.Scanner;

public class MetroFare{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        double balance=sc.nextDouble();

        while(balance>0){
            int distance=sc.nextInt();
            if(distance==-1)
                break;

            double fare=distance<=5?10:distance<=10?20:30;
            balance=balance-fare;

            if(balance<0)
                System.out.println("Insufficient Balance");
            else
                System.out.println(balance);
        }
    }
}

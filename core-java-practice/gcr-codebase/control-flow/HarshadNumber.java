import java.util.Scanner;

public class HarshadNumber{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();

        int sum=0;
        int temp=number;

        while(temp!=0){
            sum+=temp%10;
            temp=temp/10;
        }

        if(number%sum==0)
            System.out.println("Harshad Number");
        else
            System.out.println("Not a Harshad Number");
    }
}

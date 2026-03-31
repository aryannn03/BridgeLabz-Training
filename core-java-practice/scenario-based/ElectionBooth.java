import java.util.Scanner;

public class ElectionBooth{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        while(true){
            int age=sc.nextInt();
            if(age==-1)
                break;

            if(age>=18){
                int vote=sc.nextInt();
                if(vote==1||vote==2||vote==3)
                    System.out.println("Vote Recorded");
                else
                    System.out.println("Invalid Vote");
            }
            else{
                System.out.println("Not Eligible");
            }
        }
    }
}

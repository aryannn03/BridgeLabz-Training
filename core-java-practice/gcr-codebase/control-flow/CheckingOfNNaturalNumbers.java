import java.util.Scanner;

public class CheckingOfNNaturalNumbers {
    public static void main(String[] args) {   
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int sum=n*(n+1)/2;
        int total=0;
        if(n>0){
            while(n>0){
                total+=n;
                n--;
            }
            if(total==sum){
                System.out.println(total);
            }
        }
    }

}

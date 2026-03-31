import java.util.Scanner;

public class CheckingOfNNaturalNumbersUsingFor {
    public static void main(String[] args) {   
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int sum=n*(n+1)/2;
        int total=0;
        if(n>0){
            for(int i=1;i<=n;i++){
                total+=i;
            }
            if(total==sum){
                System.out.println(total);
            }
        }
    }    
}

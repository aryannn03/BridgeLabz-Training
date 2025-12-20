import java.util.Scanner;
public class FactorFinder{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        int maxSize=10;
        int[]factors=new int[maxSize];
        int index=0;
        for(int i=1;i<=number;i++){
            if(number%i==0){
                if(index==maxSize){
                    maxSize*=2;
                    int[]temp=new int[maxSize];
                    for(int j=0;j<index;j++){
                        temp[j]=factors[j];
                    }
                    factors=temp;
                }
                factors[index]=i;
                index++;
            }
        }
        for(int i=0;i<index;i++){
            System.out.print(factors[i]+" ");
        }
    }
}

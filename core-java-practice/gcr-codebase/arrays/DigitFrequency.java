import java.util.Scanner;
public class DigitFrequency{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        int tempNumber=number;
        int digitCount=0;
        while(tempNumber!=0){
            digitCount++;
            tempNumber/=10;
        }
        int[]digits=new int[digitCount];
        int index=0;
        while(number!=0){
            digits[index]=number%10;
            number/=10;
            index++;
        }
        int[]frequency=new int[10];
        for(int count=0;count<digitCount;count++){
            frequency[digits[count]]++;
        }
        for(int i=0;i<10;i++){
            if(frequency[i]>0){
                System.out.println("Digit "+i+" occurs "+frequency[i]+" times");
            }
        }
    }
}

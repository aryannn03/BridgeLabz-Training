import java.util.Scanner;
public class ReverseNumberArray{
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
        int[]reversedDigits=new int[digitCount];
        for(int count=0;count<digitCount;count++){
            reversedDigits[count]=digits[digitCount-1-count];
        }
        for(int count=0;count<digitCount;count++){
            System.out.print(reversedDigits[count]);
        }
    }
}

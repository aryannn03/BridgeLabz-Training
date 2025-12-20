import java.util.Scanner;
public class DynamicDigitAnalysis{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        int maxDigit=10;
        int[]digits=new int[maxDigit];
        int index=0;
        while(number!=0){
            if(index==maxDigit){
                maxDigit+=10;
                int[]temp=new int[maxDigit];
                for(int copy=0;copy<digits.length;copy++){
                    temp[copy]=digits[copy];
                }
                digits=temp;
            }
            digits[index]=number%10;
            number/=10;
            index++;
        }
        int largest=0;
        int secondLargest=0;
        for(int count=0;count<index;count++){
            if(digits[count]>largest){
                secondLargest=largest;
                largest=digits[count];
            }else if(digits[count]>secondLargest&&digits[count]!=largest){
                secondLargest=digits[count];
            }
        }
        System.out.println("Largest="+largest);
        System.out.println("Second Largest="+secondLargest);
    }
}

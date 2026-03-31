import java.util.Scanner;

public class NumberChecker2{
    public static int countDigits(int number){
        int count=0;
        while(number!=0){
            count++;
            number/=10;
        }
        return count;
    }
    public static int[] storeDigits(int number){
        int count=countDigits(number);
        int[] digits=new int[count];
        for(int i=count-1;i>=0;i--){
            digits[i]=number%10;
            number/=10;
        }
        return digits;
    }
    public static int sumOfDigits(int[] digits){
        int sum=0;
        for(int i:digits)
            sum+=i;
        return sum;
    }
    public static int sumOfSquareOfDigits(int[] digits){
        int sum=0;
        for(int i:digits)
            sum+=Math.pow(i,2);
        return sum;
    }
    public static boolean isHarshad(int number,int[] digits){
        return number%sumOfDigits(digits)==0;
    }
    public static int[][] digitFrequency(int[] digits){
        int[][] freq=new int[10][2];
        for(int i=0;i<10;i++)
            freq[i][0]=i;

        for(int i:digits)
            freq[i][1]++;

        return freq;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();

        int[] digits=storeDigits(number);

        System.out.println(countDigits(number));
        System.out.println(sumOfDigits(digits));
        System.out.println(sumOfSquareOfDigits(digits));
        System.out.println(isHarshad(number,digits));

        int[][] freq=digitFrequency(digits);
        for(int i=0;i<10;i++){
            if(freq[i][1]>0){
                System.out.println(freq[i][0]+" "+freq[i][1]);
            }
        }
    }
}

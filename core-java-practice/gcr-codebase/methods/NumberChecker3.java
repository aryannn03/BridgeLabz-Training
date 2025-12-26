import java.util.Scanner;

public class NumberChecker3{
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
    public static int[] reverseDigits(int[] digits){
        int[] rev=new int[digits.length];
        for(int i=0;i<digits.length;i++)
            rev[i]=digits[digits.length-1-i];
        return rev;
    }
    public static boolean compareArrays(int[] a,int[] b){
        if(a.length!=b.length)
            return false;
        for(int i=0;i<a.length;i++)
            if(a[i]!=b[i])
                return false;
        return true;
    }
    public static boolean isPalindrome(int[] digits){
        return compareArrays(digits,reverseDigits(digits));
    }
    public static boolean isDuckNumber(int[] digits){
        for(int i:digits)
            if(i!=0)
                return true;
        return false;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();

        int[] digits=storeDigits(number);
        int[] reversed=reverseDigits(digits);

        System.out.println(countDigits(number));
        System.out.println(isPalindrome(digits));
        System.out.println(isDuckNumber(digits));

        for(int i:reversed)
            System.out.print(i);
    }
}

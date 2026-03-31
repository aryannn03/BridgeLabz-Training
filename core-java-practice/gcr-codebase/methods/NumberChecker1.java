import java.util.Scanner;

public class NumberChecker1{
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

    public static boolean isDuckNumber(int[] digits){
        for(int i:digits){
            if(i!=0)
                return true;
        }
        return false;
    }

    public static boolean isArmstrong(int number,int[] digits){
        int sum=0;
        int power=digits.length;
        for(int i:digits)
            sum+=Math.pow(i,power);
        return sum==number;
    }

    public static int[] largestSecondLargest(int[] digits){
        int largest=Integer.MIN_VALUE;
        int secondLargest=Integer.MIN_VALUE;
        for(int i:digits){
            if(i>largest){
                secondLargest=largest;
                largest=i;
            }else if(i>secondLargest&&i!=largest){
                secondLargest=i;
            }
        }
        return new int[]{largest,secondLargest};
    }

    public static int[] smallestSecondSmallest(int[] digits){
        int smallest=Integer.MAX_VALUE;
        int secondSmallest=Integer.MAX_VALUE;
        for(int i:digits){
            if(i<smallest){
                secondSmallest=smallest;
                smallest=i;
            }else if(i<secondSmallest&&i!=smallest){
                secondSmallest=i;
            }
        }
        return new int[]{smallest,secondSmallest};
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();

        int[] digits=storeDigits(number);

        System.out.println(countDigits(number));
        System.out.println(isDuckNumber(digits));
        System.out.println(isArmstrong(number,digits));

        int[] max=largestSecondLargest(digits);
        System.out.println(max[0]);
        System.out.println(max[1]);

        int[] min=smallestSecondSmallest(digits);
        System.out.println(min[0]);
        System.out.println(min[1]);
    }
}

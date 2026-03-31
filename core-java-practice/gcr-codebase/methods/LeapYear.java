import java.util.Scanner;

public class LeapYear{
    public static boolean isLeapYear(int year){
        return year>=1582&&(year%400==0||(year%4==0&&year%100!=0));
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int year=sc.nextInt();
        System.out.println(isLeapYear(year)?"Leap Year":"Not a Leap Year");
    }
}

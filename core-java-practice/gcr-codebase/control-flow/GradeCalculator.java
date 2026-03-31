import java.util.Scanner;

public class GradeCalculator{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int physics=sc.nextInt();
        int chemistry=sc.nextInt();
        int maths=sc.nextInt();

        int total=physics+chemistry+maths;
        int percentage=total/3;

        System.out.println("Average:"+percentage);

        if(percentage>=80){
            System.out.println("Grade:A");
            System.out.println("Remarks:Level4");
        }
        else if(percentage>=70){
            System.out.println("Grade:B");
            System.out.println("Remarks:Level3");
        }
        else if(percentage>=60){
            System.out.println("Grade:C");
            System.out.println("Remarks:Level2");
        }
        else if(percentage>=50){
            System.out.println("Grade:D");
            System.out.println("Remarks:Level1");
        }
        else if(percentage>=40){
            System.out.println("Grade:E");
            System.out.println("Remarks:TooBelowStandard");
        }
        else{
            System.out.println("Grade:R");
            System.out.println("Remarks:Remedial");
        }
    }
}

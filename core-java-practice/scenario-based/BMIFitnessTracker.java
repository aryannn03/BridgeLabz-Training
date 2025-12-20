import java.util.Scanner;

public class BMIFitnessTracker{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        double weight=sc.nextDouble();   
        double height=sc.nextDouble();   

        double bmi=weight/(height*height);

        System.out.println(bmi);

        if(bmi<=18.4)
            System.out.println("Underweight");
        else if(bmi<=24.9)
            System.out.println("Normal");
        else
            System.out.println("Overweight");
    }
}

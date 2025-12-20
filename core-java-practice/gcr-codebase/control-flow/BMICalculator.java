import java.util.Scanner;

public class BMICalculator{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        double weight=sc.nextDouble();
        double heightCm=sc.nextDouble();

        double height=heightCm/100;
        double bmi=weight/(height*height);

        System.out.println(bmi);

        if(bmi<=18.4)
            System.out.println("Underweight");
        else if(bmi<=24.9)
            System.out.println("Normal");
        else if(bmi<=39.9)
            System.out.println("Overweight");
        else
            System.out.println("Obese");
    }
}

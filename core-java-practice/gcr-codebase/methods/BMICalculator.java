import java.util.Scanner;

public class BMICalculator{
    public static double bmi(double w,double h){
        h=h/100;
        return w/(h*h);
    }
    public static String status(double b){
        if(b<=18.4){
            return "Underweight";
        }
        if(b<=24.9){
            return "Normal";
        }
        return "Overweight";
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double[][] data=new double[10][3];
        for(int i=0;i<10;i++){
            data[i][0]=sc.nextDouble();
            data[i][1]=sc.nextDouble();
            data[i][2]=bmi(data[i][0],data[i][1]);
            System.out.println(data[i][2]+" "+status(data[i][2]));
        }
    }
}

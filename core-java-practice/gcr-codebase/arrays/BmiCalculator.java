import java.util.Scanner;
public class BmiCalculator{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int personCount=sc.nextInt();
        double[]heights=new double[personCount];
        double[]weights=new double[personCount];
        double[]bmiValues=new double[personCount];
        String[]weightStatus=new String[personCount];
        for(int i=0;i<personCount;i++){
            weights[i]=sc.nextDouble();
            heights[i]=sc.nextDouble();
        }
        for(int i=0;i<personCount;i++){
            bmiValues[i]=weights[i]/(heights[i]*heights[i]);
            if(bmiValues[i]<=18.4){
                weightStatus[i]="Underweight";
            }else if(bmiValues[i]<=24.9){
                weightStatus[i]="Normal";
            }else if(bmiValues[i]<=39.9){
                weightStatus[i]="Overweight";
            }else{
                weightStatus[i]="Obese";
            }
        }
        for(int i=0;i<personCount;i++){
            System.out.println("Height="+heights[i]+" Weight="+weights[i]+" BMI="+bmiValues[i]+" Status="+weightStatus[i]);
        }
    }
}

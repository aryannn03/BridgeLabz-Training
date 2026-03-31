import java.util.Scanner;
public class BmiUsing2DArray{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int personCount=sc.nextInt();
        double[][]personData=new double[personCount][3];
        String[]weightStatus=new String[personCount];
        for(int i=0;i<personCount;i++){
            double enteredWeight=sc.nextDouble();
            double enteredHeight=sc.nextDouble();
            if(enteredWeight<=0||enteredHeight<=0){
                i--;
                continue;
            }
            personData[i][0]=enteredWeight;
            personData[i][1]=enteredHeight;
        }
        for(int i=0;i<personCount;i++){
            personData[i][2]=personData[i][0]/(personData[i][1]*personData[i][1]);
            if(personData[i][2]<=18.4){
                weightStatus[i]="Underweight";
            }else if(personData[i][2]<=24.9){
                weightStatus[i]="Normal";
            }else if(personData[i][2]<=39.9){
                weightStatus[i]="Overweight";
            }else{
                weightStatus[i]="Obese";
            }
        }
        for(int i=0;i<personCount;i++){
            System.out.println("Height="+personData[i][1]+" Weight="+personData[i][0]+" BMI="+personData[i][2]+" Status="+weightStatus[i]);
        }
    }
}

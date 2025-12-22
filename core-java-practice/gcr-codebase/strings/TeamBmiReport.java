import java.util.Scanner;
public class TeamBmiReport{
    public static String[][]findBmiAndStatus(double weight,double heightCm){
        double heightMeter=heightCm/100;
        double bmi=weight/(heightMeter*heightMeter);
        String status;
        if(bmi<=18.4){
            status="Underweight";
        }else if(bmi<=24.9){
            status="Normal";
        }else if(bmi<=39.9){
            status="Overweight";
        }else{
            status="Obese";
        }
        String[][]result=new String[1][4];
        result[0][0]=String.valueOf(heightCm);
        result[0][1]=String.valueOf(weight);
        result[0][2]=String.valueOf(bmi);
        result[0][3]=status;
        return result;
    }
    public static String[][]processTeam(double[][]personData){
        String[][]report=new String[personData.length][4];
        for(int i=0;i<personData.length;i++){
            String[][]single=findBmiAndStatus(personData[i][0],personData[i][1]);
            report[i][0]=single[0][0];
            report[i][1]=single[0][1];
            report[i][2]=single[0][2];
            report[i][3]=single[0][3];
        }
        return report;
    }
    public static void displayReport(String[][]report){
        System.out.println("Height(cm) Weight(kg) BMI Status");
        for(int i=0;i<report.length;i++){
            System.out.println(
                report[i][0]+" "+
                report[i][1]+" "+
                report[i][2]+" "+
                report[i][3]
            );
        }
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        double[][]personData=new double[10][2];
        for(int i=0;i<10;i++){
            double weight=sc.nextDouble();
            double height=sc.nextDouble();
            if(weight<=0||height<=0){
                i--;
                continue;
            }
            personData[i][0]=weight;
            personData[i][1]=height;
        }
        String[][]finalReport=processTeam(personData);
        displayReport(finalReport);
    }
}

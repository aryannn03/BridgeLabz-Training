import java.util.Scanner;
public class StudentGradeCalculator{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int studentCount=sc.nextInt();
        double[][]marks=new double[studentCount][3];
        double[]percentages=new double[studentCount];
        char[]grades=new char[studentCount];
        for(int i=0;i<studentCount;i++){
            double physics=sc.nextDouble();
            double chemistry=sc.nextDouble();
            double maths=sc.nextDouble();
            if(physics<0||chemistry<0||maths<0){
                i--;
                continue;
            }
            marks[i][0]=physics;
            marks[i][1]=chemistry;
            marks[i][2]=maths;
        }
        for(int i=0;i<studentCount;i++){
            double total=marks[i][0]+marks[i][1]+marks[i][2];
            percentages[i]=(total/300)*100;
            if(percentages[i]>=80){
                grades[i]='A';
            }else if(percentages[i]>=70){
                grades[i]='B';
            }else if(percentages[i]>=60){
                grades[i]='C';
            }else if(percentages[i]>=50){
                grades[i]='D';
            }else if(percentages[i]>=40){
                grades[i]='E';
            }else{
                grades[i]='R';
            }
        }
        for(int i=0;i<studentCount;i++){
            System.out.println("Physics="+marks[i][0]+" Chemistry="+marks[i][1]+" Maths="+marks[i][2]+" Percentage="+percentages[i]+" Grade="+grades[i]);
        }
    }
}

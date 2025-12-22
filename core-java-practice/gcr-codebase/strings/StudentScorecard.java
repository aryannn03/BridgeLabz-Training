import java.util.Scanner;
public class StudentScorecard{
    public static double[][]generateScores(int studentCount){
        double[][]scores=new double[studentCount][3];
        for(int i=0;i<studentCount;i++){
            scores[i][0]=10+(int)(Math.random()*90);
            scores[i][1]=10+(int)(Math.random()*90);
            scores[i][2]=10+(int)(Math.random()*90);
        }
        return scores;
    }
    public static double[][]calculateResults(double[][]scores){
        int count=scores.length;
        double[][]results=new double[count][4];
        for(int i=0;i<count;i++){
            double total=scores[i][0]+scores[i][1]+scores[i][2];
            double average=total/3;
            double percentage=(total/300)*100;
            results[i][0]=Math.round(total*100.0)/100.0;
            results[i][1]=Math.round(average*100.0)/100.0;
            results[i][2]=Math.round(percentage*100.0)/100.0;
        }
        return results;
    }
    public static char[][]calculateGrades(double[][]results){
        int count=results.length;
        char[][]grades=new char[count][1];
        for(int i=0;i<count;i++){
            double percentage=results[i][2];
            if(percentage>=80){
                grades[i][0]='A';
            }
            else if(percentage>=70){
                grades[i][0]='B';
            }
            else if(percentage>=60){
                grades[i][0]='C';
            }
            else if(percentage>=50){
                grades[i][0]='D';
            }
            else if(percentage>=40){
                grades[i][0]='E';
            }
            else{
                grades[i][0]='R';
            }
        }
        return grades;
    }
    public static void displayScorecard(double[][]scores,double[][]results,char[][]grades){
        System.out.println("Phy Chem Math Total Avg Percent Grade");
        for(int i=0;i<scores.length;i++){
            System.out.println(
                scores[i][0]+" "+
                scores[i][1]+" "+
                scores[i][2]+" "+
                results[i][0]+" "+
                results[i][1]+" "+
                results[i][2]+" "+
                grades[i][0]
            );
        }
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int studentCount=sc.nextInt();
        double[][]scores=generateScores(studentCount);
        double[][]results=calculateResults(scores);
        char[][]grades=calculateGrades(results);
        displayScorecard(scores,results,grades);
    }
}

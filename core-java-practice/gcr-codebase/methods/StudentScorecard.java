import java.util.Scanner;

public class StudentScorecard{

    public static int[][] generateScores(int n){
        int[][] scores=new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                scores[i][j]=10+(int)(Math.random()*90);
            }
        }
        return scores;
    }
    public static double[][] calculateResult(int[][] scores){
        int n=scores.length;
        double[][] result=new double[n][3];

        for(int i=0;i<n;i++){
            int total=scores[i][0]+scores[i][1]+scores[i][2];
            double average=total/3.0;
            double percentage=(total/300.0)*100;

            result[i][0]=total;
            result[i][1]=Math.round(average);
            result[i][2]=Math.round(percentage);
        }
        return result;
    }
    public static String grade(double percentage){
        if(percentage>=80){
            return "A";
        }
        if(percentage>=70){
            return "B";
        }
        if(percentage>=60){
            return "C";
        }
        if(percentage>=50){
            return "D";
        }
        if(percentage>=40){
            return "E";
        } 
        return "R";
    }
    public static void display(int[][] scores,double[][] result){
        System.out.println("Phy\tChem\tMath\tTotal\tAvg\t%\tGrade");
        for(int i=0;i<scores.length;i++){
            System.out.println(scores[i][0]+"\t"+scores[i][1]+"\t"+scores[i][2]+"\t"+(int)result[i][0]+"\t"+(int)result[i][1]+"\t"+(int)result[i][2]+"\t"+grade(result[i][2]));
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int[][] scores=generateScores(n);
        double[][] result=calculateResult(scores);
        display(scores,result);
    }
}

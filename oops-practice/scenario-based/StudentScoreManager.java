import java.util.*;

public class StudentScoreManager {

    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter number of students:");
        int n=sc.nextInt();

        double[]score=new double[n];
        double sum=0;

        for(int i=0;i<n;i++){
            while(true){
                try{
                    System.out.print("Enter score for student "+(i+1)+":");
                    double s=sc.nextDouble();
                    if(s<0){
                        System.out.println("Score cannot be negative.Try again.");
                        continue;
                    }
                    score[i]=s;
                    sum+=s;
                    break;
                }catch(Exception e){
                    System.out.println("Invalid input.Enter numeric value.");
                    sc.next();
                }
            }
        }

        double avg=sum/n;
        double max=score[0],min=score[0];

        for(int i=1;i<n;i++){
            if(score[i]>max)max=score[i];
            if(score[i]<min)min=score[i];
        }

        System.out.println("Average Score:"+avg);
        System.out.println("Highest Score:"+max);
        System.out.println("Lowest Score:"+min);

        System.out.println("Scores above average:");
        for(int i=0;i<n;i++){
            if(score[i]>avg){
                System.out.println(score[i]);
            }
        }
    }
}
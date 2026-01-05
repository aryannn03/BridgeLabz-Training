import java.util.*;
class InvalidScoreException extends Exception{
    InvalidScoreException(String message){
        super(message);
    }
}
public class ScoreAnalyzer{
    static double calculateAverage(int[] scores){
        int sum=0;
        for(int score:scores){
            sum+=score;
        }
        return(double)sum/scores.length;
    }
    static int findMax(int[] scores){
        int max=scores[0];
        for(int score:scores){
            if(score>max)
                max=score;
        }
        return max;
    }
    static int findMin(int[] scores){
        int min=scores[0];
        for(int score:scores){
            if(score<min)
                min=score;
        }
        return min;
    }
    static void validateScores(int[] scores)throws InvalidScoreException{
        for(int score:scores){
            if(score<0||score>100){
                throw new InvalidScoreException("Invalid score found:"+score);
            }
        }
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        try{
            System.out.print("Enter number of students:");
            int n=scanner.nextInt();
            int[] scores=new int[n];
            for(int i=0;i<n;i++){
                System.out.print("Enter score for student "+(i+1)+":");
                scores[i]=scanner.nextInt();
            }
            validateScores(scores);
            System.out.println("Average Score:"+calculateAverage(scores));
            System.out.println("Highest Score:"+findMax(scores));
            System.out.println("Lowest Score:"+findMin(scores));
        }catch(InvalidScoreException e){
            System.out.println("Error:"+e.getMessage());
        }
    }
}

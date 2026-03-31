import java.util.*;

class InvalidQuizSubmissionException extends Exception{
    InvalidQuizSubmissionException(String msg){
        super(msg);
    }
}
public class QuizResultProcessor{
    static int calculateScore(String[]correct,String[]user)throws InvalidQuizSubmissionException{
        if(correct.length!=user.length){
            throw new InvalidQuizSubmissionException("Length Mismatch");
        }
        int score=0;
        for(int i=0;i<correct.length;i++){
            if(correct[i].equals(user[i]))score++;
        }
        return score;
    }
    static String grade(int score){
        if(score>=4){
            return "A";
        }
        if(score>=2){
            return "B";
        }
        return "C";
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String[]correct={"A","B","C","D","A"};
        List<Integer>scores=new ArrayList<>();
        while(true){
            System.out.println("Enter answers or X to exit:");
            String[]user=new String[5];
            for(int i=0;i<5;i++){
                user[i]=sc.next();
                if(user[i].equals("X"))return;
            }
            try{
                int score=calculateScore(correct,user);
                scores.add(score);
                System.out.println("Score:"+score+" Grade:"+grade(score));
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

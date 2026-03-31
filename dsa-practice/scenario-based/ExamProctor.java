import java.util.*;
class ExamProctor {
    Stack<Integer> navigationStack;
    HashMap<Integer,String> answerMap;
    HashMap<Integer,String> correctAnswers;
    ExamProctor(){
        navigationStack=new Stack<>();
        answerMap=new HashMap<>();
        correctAnswers=new HashMap<>();
    }
    public void visitQuestion(int questionID){
        navigationStack.push(questionID);
        System.out.println("Visited Question: "+questionID);
    }
    public void submitAnswer(int questionID,String answer){
        answerMap.put(questionID,answer);
        System.out.println("Answer saved for Question "+questionID);
    }
    public void setCorrectAnswer(int questionID,String answer){
        correctAnswers.put(questionID,answer);
    }
    public int calculateScore(){
        int score=0;
        for(int key:correctAnswers.keySet()){
            if(answerMap.containsKey(key)){
                if(answerMap.get(key).equalsIgnoreCase(correctAnswers.get(key))){
                    score++;
                }
            }
        }
        return score;
    }
    public void showNavigationHistory(){
        System.out.println("Navigation History:");
        Stack<Integer> tempStack=(Stack<Integer>)navigationStack.clone();
        while(!tempStack.isEmpty()){
            System.out.println("-> Question "+tempStack.pop());
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ExamProctor exam=new ExamProctor();
        System.out.print("Enter number of questions: ");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.print("Enter Question ID: ");
            int qid=sc.nextInt();
            sc.nextLine();
            System.out.print("Enter correct answer for Question "+qid+": ");
            String correct=sc.nextLine();
            exam.setCorrectAnswer(qid,correct);
        }
        System.out.println("-- Start Exam --");
        for(int i=0;i<n;i++){
            System.out.print("Visit Question ID: ");
            int qid=sc.nextInt();
            sc.nextLine();
            exam.visitQuestion(qid);
            System.out.print("Enter your answer: ");
            String ans=sc.nextLine();
            exam.submitAnswer(qid,ans);
        }
        exam.showNavigationHistory();
        int result=exam.calculateScore();
        System.out.println("Final Score: "+result+"/"+n);
    }
}

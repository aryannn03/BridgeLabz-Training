import java.util.*;

class ExamTimeExpiredException extends Exception{
    ExamTimeExpiredException(String msg){
        super(msg);
    }
}

interface EvaluationStrategy{
    int evaluate(String correctAnswer,String studentAnswer);
}

class ObjectiveEvaluation implements EvaluationStrategy{
    public int evaluate(String correctAnswer,String studentAnswer){
        return correctAnswer.equalsIgnoreCase(studentAnswer)?1:0;
    }
}

class DescriptiveEvaluation implements EvaluationStrategy{
    public int evaluate(String correctAnswer,String studentAnswer){
        return studentAnswer.length()>=correctAnswer.length()/2?1:0;
    }
}

class Question{
    int qid;
    String question;
    String correctAnswer;
    EvaluationStrategy strategy;

    Question(int qid,String question,String correctAnswer,EvaluationStrategy strategy){
        this.qid=qid;
        this.question=question;
        this.correctAnswer=correctAnswer;
        this.strategy=strategy;
    }
}

class Exam{
    int examId;
    String subject;
    int duration;
    List<Question> questions;

    Exam(int examId,String subject,int duration){
        this.examId=examId;
        this.subject=subject;
        this.duration=duration;
        this.questions=new ArrayList<>();
    }

    void addQuestion(Question q){
        questions.add(q);
    }
}

class Student{
    int studentId;
    String name;
    Map<Integer,String> answers;

    Student(int studentId,String name){
        this.studentId=studentId;
        this.name=name;
        this.answers=new HashMap<>();
    }

    void submitAnswer(int qid,String ans){
        answers.put(qid,ans);
    }
}

public class OnlineExaminationSystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        Exam exam=new Exam(101,"Java",30);

        exam.addQuestion(new Question(1,"What is JVM?","Java Virtual Machine",new DescriptiveEvaluation()));
        exam.addQuestion(new Question(2,"Keyword for inheritance?","extends",new ObjectiveEvaluation()));

        System.out.print("Enter Student ID: ");
        int sid=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Student Name: ");
        String sname=sc.nextLine();

        Student student=new Student(sid,sname);

        long start=System.currentTimeMillis();

        try{
            for(Question q:exam.questions){
                if((System.currentTimeMillis()-start)/1000>exam.duration){
                    throw new ExamTimeExpiredException("Exam Time Expired");
                }
                System.out.println(q.question);
                String ans=sc.nextLine();
                student.submitAnswer(q.qid,ans);
            }

            int score=0;
            for(Question q:exam.questions){
                String studentAns=student.answers.get(q.qid);
                score+=q.strategy.evaluate(q.correctAnswer,studentAns);
            }

            System.out.println("Result");
            System.out.println("Student: "+student.name);
            System.out.println("Score: "+score+"/"+exam.questions.size());

        }catch(ExamTimeExpiredException e){
            System.out.println(e.getMessage());
        }
    }
}

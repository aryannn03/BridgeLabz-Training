import java.util.*;

class Student {

    String name;
    String dept;
    int q1,q2,q3;
    int total;

    Student(String name,String dept,int q1,int q2,int q3){
        this.name=name;
        this.dept=dept;
        this.q1=q1;
        this.q2=q2;
        this.q3=q3;
        this.total=q1+q2+q3;
    }
}

public class QuizPerformanceRankingSystem {

    static List<Student> list = new ArrayList<>();

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        while(n-- > 0){

            String line = sc.nextLine();
            String[] arr = line.split(" ");

            if(arr[0].equals("Record")){

                String name = arr[1];
                String dept = arr[2];
                int q1 = Integer.parseInt(arr[3]);
                int q2 = Integer.parseInt(arr[4]);
                int q3 = Integer.parseInt(arr[5]);

                list.add(new Student(name,dept,q1,q2,q3));

                System.out.println("Record Added: " + name);
            }

            else if(arr[0].equals("Top")){

                if(list.isEmpty()){
                    System.out.println("No Records Available");
                    continue;
                }

                String key = arr[1];

                if(key.equals("Q1") || key.equals("Q2") || key.equals("Q3")){
                    topQuiz(key);
                }
                else{
                    topDepartment(key);
                }
            }
        }
    }

    static void topDepartment(String dept){

        int max = -1;
        boolean found = false;

        for(Student s : list){
            if(s.dept.equals(dept)){
                found = true;
                max = Math.max(max, s.total);
            }
        }

        if(!found){
            System.out.println("Department Not Found");
            return;
        }

        for(Student s : list){
            if(s.dept.equals(dept) && s.total == max){
                System.out.println(s.name + " " + s.total);
            }
        }
    }

    static void topQuiz(String quiz){

        int max = -1;

        for(Student s : list){

            if(quiz.equals("Q1"))
                max = Math.max(max,s.q1);

            else if(quiz.equals("Q2"))
                max = Math.max(max,s.q2);

            else
                max = Math.max(max,s.q3);
        }

        for(Student s : list){

            if(quiz.equals("Q1") && s.q1 == max)
                System.out.println(s.name + " " + s.q1);

            else if(quiz.equals("Q2") && s.q2 == max)
                System.out.println(s.name + " " + s.q2);

            else if(quiz.equals("Q3") && s.q3 == max)
                System.out.println(s.name + " " + s.q3);
        }
    }
}
import java.util.*;

class InvalidMarkException extends Exception{
    InvalidMarkException(String msg){
        super(msg);
    }
}

class Student{
    String name;
    int[]marks;
    Student(String name,int[]marks){
        this.name=name;
        this.marks=marks;
    }
}

public class StudentReportGenerator{
    static double average(int[]marks)throws InvalidMarkException{
        int sum=0;
        for(int m:marks){
            if(m<0||m>100){
                throw new InvalidMarkException("Invalid Marks");
            }
            sum+=m;
        }
        return sum/(double)marks.length;
    }

    static String grade(double avg){
        if(avg>=80){
            return "A";
        }
        if(avg>=60){
            return "B";
        }
        return "C";
    }

    static void display(Student s)throws Exception{
        double avg=average(s.marks);
        System.out.println("Name:"+s.name);
        System.out.println("Average:"+avg);
        System.out.println("Grade:"+grade(avg));
    }

    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        List<Student>list=new ArrayList<>();
        while(true){
            System.out.println("Enter name or X to exit:");
            String name=sc.next();
            if(name.equals("X")){
                break;
            }
            int[]marks=new int[3];
            for(int i=0;i<3;i++)marks[i]=sc.nextInt();
            try{
                Student s=new Student(name,marks);
                list.add(s);
                display(s);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

class Student{
    private String name;
    private String roll;
    private double m1,m2,m3;

    Student(String name,String roll,double m1,double m2,double m3){
        this.name=name;
        this.roll=roll;
        this.m1=m1;
        this.m2=m2;
        this.m3=m3;
    }

    char calculateGrade(){
        double avg=(m1+m2+m3)/3;
        if(avg>=75)return'B';
        else return'C';
    }

    void display(){
        System.out.println("Student Name: "+name);
        System.out.println("Student RollNumber: "+roll);
        System.out.println("Student Marks:");
        System.out.println("Mark1: "+m1);
        System.out.println("Mark2: "+m2);
        System.out.println("Mark3: "+m3);
        System.out.println("Grade "+calculateGrade());
    }
}

public class StudentMain{
    public static void main(String[]args){
        Student s1=new Student("Thamarai","ECE001",80,70,75);
        Student s2=new Student("Kannan","CSC002",60,65,50);
        s1.display();
        s2.display();
    }
}

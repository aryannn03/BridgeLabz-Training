class Student{
    private static String universityName="Global University";
    private static int totalStudents=0;

    private final int rollNumber;
    private String name;
    private String grade;

    Student(int rollNumber,String name,String grade){
        this.rollNumber=rollNumber;
        this.name=name;
        this.grade=grade;
        totalStudents++;
    }

    static void displayTotalStudents(){
        System.out.println("Total Students Enrolled: "+totalStudents);
    }

    void updateGrade(String grade){
        this.grade=grade;
        System.out.println("Grade updated to: "+grade);
    }

    void display(){
        if(this instanceof Student){
            System.out.println("University Name: "+universityName);
            System.out.println("Roll Number: "+rollNumber);
            System.out.println("Name: "+name);
            System.out.println("Grade: "+grade);
        }
    }
}

public class UniversityStudentMain{
    public static void main(String[]args){
        Student s1=new Student(101,"Hemashree","A");
        Student s2=new Student(102,"Sharmila","B");

        Student.displayTotalStudents();
        s1.display();
        s2.display();

        s2.updateGrade("A");
        s2.display();
    }
}

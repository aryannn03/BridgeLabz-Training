import java.util.*;

class Person{
    private String name;
    private int age;
    private String email;
    private String phoneNumber;
    Person(String name,int age,String email,String phoneNumber){
        this.name=name;
        this.age=age;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }
}

class CourseLimitExceededException extends Exception{
    CourseLimitExceededException(String msg){
        super(msg);
    }
}

abstract class RegistrationService{
    abstract void courseenrollment(List<String> courses,Scanner sc)throws CourseLimitExceededException;
}

class Student extends Person{
    private int studentId;
    private List<String> courseEnrolled;
    private List<Integer> grades;
    private static final int MAX_COURSES=5;

    Student(String name,int age,int studentId,String email,String phoneNumber){
        super(name,age,email,phoneNumber);
        this.studentId=studentId;
        this.courseEnrolled=new ArrayList<>();
        this.grades=new ArrayList<>();
    }

    public void courseenrollment(List<String> courses,Scanner sc)throws CourseLimitExceededException{
        System.out.println("Available Courses: "+courses);
        for(String course:courses){
            if(courseEnrolled.size()>=MAX_COURSES){
                throw new CourseLimitExceededException("Course limit exceeded (Max "+MAX_COURSES+")");
            }
            System.out.print("Enroll in "+course+"? (1-Yes / 0-No): ");
            int choice=sc.nextInt();
            if(choice==1){
                courseEnrolled.add(course);
                System.out.println("Enrolled in "+course);
            }
        }
    }

    public void dropCourse(Scanner sc){
        if(courseEnrolled.isEmpty()){
            System.out.println("No courses to drop");
            return;
        }
        System.out.println("Courses Enrolled: "+courseEnrolled);
        sc.nextLine();
        while(true){
            System.out.print("Enter course to drop (or exit): ");
            String course=sc.nextLine();
            if(course.equalsIgnoreCase("exit")){
                break;
            }
            if(courseEnrolled.remove(course)){
                System.out.println("Dropped "+course);
            }else{
                System.out.println("Course not found");
            }
        }
    }

    public void gradeAssignment(){
        Random r=new Random();
        grades.clear();
        for(int i=0;i<courseEnrolled.size();i++){
            grades.add(r.nextInt(101));
        }
    }

    public void gradeReport(){
        if(courseEnrolled.isEmpty()){
            System.out.println("No courses enrolled");
            return;
        }
        for(int i=0;i<courseEnrolled.size();i++){
            System.out.println("Course: "+courseEnrolled.get(i)+" | Grade: "+grades.get(i));
        }
    }
}

public class StudentCourseRegistrationSystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        List<String> availableCourses=new ArrayList<>(Arrays.asList("DSA","Web Dev","App Dev","Game Dev","Cloud Computing","AI/ML","Cyber Security","Data Science","Blockchain","DevOps","UI/UX Design"));
        while(true){
            System.out.print("Enter 1 to register student or 0 to exit: ");
            int ch=sc.nextInt();
            if(ch==0){
                System.out.println("Exiting system");
                break;
            }

            sc.nextLine();
            System.out.print("Enter Name: ");
            String name=sc.nextLine();
            System.out.print("Enter Age: ");
            int age=sc.nextInt();
            System.out.print("Enter Student ID: ");
            int id=sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Email: ");
            String email=sc.nextLine();
            System.out.print("Enter Phone: ");
            String phone=sc.nextLine();

            Student s=new Student(name,age,id,email,phone);

            boolean loop=true;
            while(loop){
                System.out.println("1.Course Enrollment");
                System.out.println("2.Drop Course");
                System.out.println("3.Assign Grades");
                System.out.println("4.View Grade Report");
                System.out.println("0.Exit");
                System.out.print("Choice: ");
                int choice=sc.nextInt();

                try{
                    switch(choice){
                        case 1:
                            s.courseenrollment(availableCourses,sc);
                            break;
                        case 2:
                            s.dropCourse(sc);
                            break;
                        case 3:
                            s.gradeAssignment();
                            System.out.println("Grades Assigned");
                            break;
                        case 4:
                            s.gradeReport();
                            break;
                        case 0:
                            loop=false;
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                }catch(CourseLimitExceededException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}

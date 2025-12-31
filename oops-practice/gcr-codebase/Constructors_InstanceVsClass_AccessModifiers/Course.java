public class Course{
    String courseName;
    int duration;
    double fee;
    static String instituteName="GLA";

    public Course(String courseName,int duration,double fee){
        this.courseName=courseName;
        this.duration=duration;
        this.fee=fee;
    }

    void displayCourseDetails(){
        System.out.println(courseName+" "+duration+" "+fee+" "+instituteName);
    }

    static void updateInstituteName(String name){
        instituteName=name;
    }

    public static void main(String[]args){
        Course c=new Course("Java",6,3000);
        updateInstituteName("Tech");
        c.displayCourseDetails();
    }
}

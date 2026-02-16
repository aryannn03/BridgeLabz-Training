import java.time.LocalDate;

public class Enrollment {
    private String student_name;
    private String course_name;
    private String course_category;
    private LocalDate enrollment_date;
    public Enrollment(String name,String course,String category,LocalDate date){
        this.student_name=name;
        this.course_name=course;
        this.course_category=category;
        this.enrollment_date=date;
    }
    String getStudentName(){
        return student_name;
    }
    String getCourseName(){
        return course_name;
    }
    String getCourseCategory(){
        return course_category;
    }
    LocalDate getEnrollmentDate(){
        return enrollment_date;
    }
    
}

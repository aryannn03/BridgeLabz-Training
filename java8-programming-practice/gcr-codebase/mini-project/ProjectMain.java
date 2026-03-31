import java.util.ArrayList;
import java.util.List;
import java.time.*;

public class ProjectMain {
    
    static List<Enrollment> enrollments = List.of(
        new Enrollment(
            "Aryan Malik",
            "Java Fundamentals",
            "Programming",
            LocalDate.of(2024, 1, 15)
        ),
        new Enrollment(
            "Rahul Sharma",
            "Java Fundamentals",
            "Backend",
            LocalDate.of(2024, 3, 10)
        ),
        new Enrollment(
            "Neha Gupta",
            "Data Structures",
            "Programming",
            LocalDate.of(2023, 12, 20)
        ),
    
        new Enrollment(
            "Priya Singh",
            "Data Structures",
            "Frontend",
            LocalDate.of(2024, 2, 5)
        ),
    
        new Enrollment(
            "Amit Verma",
            "Microservices",
            "Backend",
            LocalDate.of(2024, 4, 1)
        )
    
    );
    public static void main(String[] args) {
        Functionalities f= new Functionalities();
        System.out.println("Filter By Course:");
        System.out.println(
            f.filterByCourse("Java Fundamentals", enrollments)
        );
        System.out.println("\nFilter By Category:");
        System.out.println(
            f.filterByCategory("Backend", enrollments)
        );
        
        System.out.println("\nGroup By Course:");
        System.out.println(
            f.groupByEnrollments(enrollments)
        );
        
        System.out.println("\nCount Per Category:");
        System.out.println(
            f.countEnrollmentsPerCategory(enrollments)
        );
        
        System.out.println("\nSorted By Enrollment Date:");
        System.out.println(
            f.sortByEnrollmentdate(enrollments)
        );
    }

}

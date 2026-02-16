import java.util.*;
import java.util.stream.*;

public class Functionalities {
    List<Enrollment> filterByCourse(String course_name,List<Enrollment> lst){
        return lst.stream().filter(e->(e.getCourseName().equals(course_name))).collect(Collectors.toList());
    }
    List<Enrollment> filterByCategory(String course_category,List<Enrollment> lst){
        return lst.stream().filter(e->(e.getCourseCategory().equals(course_category))).collect(Collectors.toList());
    }
    Map<String,List<String>> groupByEnrollments(List<Enrollment> lst){
        return lst.stream().collect(Collectors.groupingBy(Enrollment::getCourseName,Collectors.mapping(Enrollment::getStudentName,Collectors.toList())));
    }
    Map<String,Long> countEnrollmentsPerCategory(List<Enrollment> lst){
        return lst.stream().collect(Collectors.groupingBy(Enrollment::getCourseCategory,Collectors.counting()));
    }
    List<Enrollment> sortByEnrollmentdate(List<Enrollment> lst){
        return lst.stream().sorted(Comparator.comparing(Enrollment::getEnrollmentDate)).toList();
    }

}

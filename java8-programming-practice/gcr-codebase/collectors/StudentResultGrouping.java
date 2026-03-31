import java.util.*;
import java.util.stream.*;

public class StudentResultGrouping {

    static class Student {
        String name;
        String grade;

        Student(String name,String grade){
            this.name=name;
            this.grade=grade;
        }

        String getName(){
            return name;
        }

        String getGrade(){
            return grade;
        }
    }

    public static void main(String[] args){

        List<Student> students=Arrays.asList(
                new Student("Aryan","A"),
                new Student("Rohit","B"),
                new Student("Neha","A"),
                new Student("Simran","C"),
                new Student("Kunal","B")
        );

        Map<String,List<String>> groupedResult=
                students.stream()
                        .collect(Collectors.groupingBy(
                                Student::getGrade,
                                Collectors.mapping(Student::getName,Collectors.toList())
                        ));

        groupedResult.forEach((grade,names)->{
            System.out.println(grade+" -> "+names);
        });
    }
}

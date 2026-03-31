import java.util.*;
import java.util.stream.*;

public class EmployeeSalaryCategorization {

    static class Employee {
        String name;
        String department;
        double salary;

        Employee(String name,String department,double salary){
            this.name=name;
            this.department=department;
            this.salary=salary;
        }

        String getName(){
            return name;
        }

        String getDepartment(){
            return department;
        }

        double getSalary(){
            return salary;
        }
    }

    public static void main(String[] args){

        List<Employee> employees=Arrays.asList(
                new Employee("Aryan","IT",60000),
                new Employee("Rohit","HR",45000),
                new Employee("Neha","IT",75000),
                new Employee("Simran","Finance",50000),
                new Employee("Kunal","HR",55000)
        );

        Map<String,Double> avgSalaryByDepartment=
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        ));

        avgSalaryByDepartment.forEach((department,average)->{
            System.out.println(department+" -> "+average);
        });
    }
}

interface Department{
    void setDepartment(String dept);
    String getDepartmentDetails();
}
abstract class Employee{
    private int employeeId;
    private String name;
    protected double baseSalary;
    Employee(int employeeId,String name,double baseSalary){
        this.employeeId=employeeId;
        this.name=name;
        this.baseSalary=baseSalary;
    }
    abstract double calculateSalary();
    void displayDetails(){
        System.out.println("ID:"+employeeId);
        System.out.println("Name:"+name);
        System.out.println("Salary:"+calculateSalary());
    }
}
class FullTimeEmployee extends Employee implements Department{
    private String department;
    FullTimeEmployee(int id,String name,double salary){
        super(id,name,salary);
    }
    double calculateSalary(){
        return baseSalary;
    }
    public void setDepartment(String dept){
        department=dept;
    }
    public String getDepartmentDetails(){
        return department;
    }
}
class PartTimeEmployee extends Employee{
    int hours;
    PartTimeEmployee(int id,String name,double rate,int hours){
        super(id,name,rate);
        this.hours=hours;
    }
    double calculateSalary(){
        return baseSalary*hours;
    }
}
public class EmployeeManagement{
    public static void main(String[] args){
        Employee e1=new FullTimeEmployee(1,"Amit",50000);
        Employee e2=new PartTimeEmployee(2,"Neha",500,40);

        e1.displayDetails();
        e2.displayDetails();
    }
}

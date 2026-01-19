abstract class Employee{
    private final String name;
    private final int salary;
    public Employee(String name,int salary){
        this.name=name;
        this.salary=salary;
    }
    public String getName(){
        return name;
    }
    public int getSalary(){
        return salary;
    }
    abstract double getBonus(int salary);
}
class Manager extends Employee{
    public Manager(String name, int salary){
        super(name, salary);
    }
    double getBonus(int salary){
        if(salary>50000){
            return 0.1*salary;
        }
        return salary;
    }
}
class Developer extends Employee{
    public Developer(String name, int salary){
        super(name, salary);
    }
    double getBonus(int salary){
        if(salary>50000){
            return 0.05*salary;
        }
        return salary;
    }
}

public class EmployeeRolePolymorphism {
    public static void main(String[] args) {
        Employee emp1=new Manager("Alice", 80000);
        System.out.println(emp1.getBonus(emp1.getSalary()));
        Employee emp2=new Developer("Bob", 60000);    
        System.out.print(emp2.getBonus(emp1.getSalary()));
    }
}

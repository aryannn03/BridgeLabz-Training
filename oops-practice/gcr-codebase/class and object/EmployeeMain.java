class Employee{
    private String name;
    private int id;
    private double salary;

    Employee(String name,int id,double salary){
        this.name=name;
        this.id=id;
        this.salary=salary;
    }

    void display(){
        System.out.println("Employee Name: "+name);
        System.out.println("Employee id: "+id);
        System.out.println("Employee Salary: "+salary);
    }
}

public class EmployeeMain{
    public static void main(String[]args){
        Employee e=new Employee("Rohan",1,500000);
        e.display();
    }
}

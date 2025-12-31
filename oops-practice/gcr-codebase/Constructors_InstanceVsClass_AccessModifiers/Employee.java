public class Employee{
    public int employeeID;
    protected String department;
    private double salary;

    public void setSalary(double salary){
        this.salary=salary;
    }

    public static void main(String[]args){
        Employee e=new Employee();
        e.employeeID=1;
        e.department="IT";
        e.setSalary(60000);
    }
}

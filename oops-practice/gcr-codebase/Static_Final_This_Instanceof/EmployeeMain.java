class Employee{
    private static String companyName="Tech Solutions Inc.";
    private static int totalEmployees=0;

    private final int id;
    private String name;
    private String designation;

    Employee(int id,String name,String designation){
        this.id=id;
        this.name=name;
        this.designation=designation;
        totalEmployees++;
    }

    static void displayTotalEmployees(){
        System.out.println("Total Employees: "+totalEmployees);
    }

    void display(){
        if(this instanceof Employee){
            System.out.println("Company Name: "+companyName);
            System.out.println("Employee ID: "+id);
            System.out.println("Name: "+name);
            System.out.println("Designation: "+designation);
        }
    }
}

public class EmployeeMain{
    public static void main(String[]args){
        Employee e1=new Employee(101,"Thamarai","Software Engineer");
        Employee e2=new Employee(102,"Rohan","Project Manager");

        Employee.displayTotalEmployees();
        e1.display();
        e2.display();
    }
}

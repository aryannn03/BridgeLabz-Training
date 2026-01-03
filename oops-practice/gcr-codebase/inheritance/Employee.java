class Employee {
    String name;
    int id;
    double sal;

    Employee(String n,int i,double s){
        name=n;
        id=i;
        sal=s;
    }

    void displayDetails(){
        System.out.println("Name: "+name);
        System.out.println("ID: "+id);
        System.out.println("Salary: "+sal);
    }
}

class Manager extends Employee {
    int teamSize;

    Manager(String n,int i,double s,int t){
        super(n,i,s);
        teamSize=t;
    }

    void displayDetails(){
        super.displayDetails();
        System.out.println("Team Size: "+teamSize);
    }
}

class Developer extends Employee {
    String lang;

    Developer(String n,int i,double s,String l){
        super(n,i,s);
        lang=l;
    }

    void displayDetails(){
        super.displayDetails();
        System.out.println("Language: "+lang);
    }
}

class Intern extends Employee {
    int months;

    Intern(String n,int i,double s,int m){
        super(n,i,s);
        months=m;
    }

    void displayDetails(){
        super.displayDetails();
        System.out.println("Duration: "+months+" months");
    }
}

public class Main {
    public static void main(String[] args){
        Employee e1=new Manager("Naman",101,80000,5);
        Employee e2=new Developer("Amit",102,60000,"Java");
        Employee e3=new Intern("Riya",103,15000,6);

        e1.displayDetails();
        System.out.println();
        e2.displayDetails();
        System.out.println();
        e3.displayDetails();
    }
}

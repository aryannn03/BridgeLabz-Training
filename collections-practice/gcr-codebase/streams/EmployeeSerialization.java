import java.io.*;
import java.util.*;
class Employee implements Serializable{
    int id;
    String name;
    String department;
    double salary;
    Employee(int id,String name,String department,double salary){
        this.id=id;
        this.name=name;
        this.department=department;
        this.salary=salary;
    }
    public String toString(){
        return id+" "+name+" "+department+" "+salary;
    }
}
public class EmployeeSerialization{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String file=sc.nextLine();
        int n=sc.nextInt();
        List<Employee> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new Employee(sc.nextInt(),sc.next(),sc.next(),sc.nextDouble()));
        }
        try{
            ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(list);
            out.close();
            ObjectInputStream in=new ObjectInputStream(new FileInputStream(file));
            List<Employee> res=(List<Employee>)in.readObject();
            in.close();
            for(Employee e:res){
                System.out.println(e);
            }
        }catch(IOException|ClassNotFoundException e){
            System.out.println("Error");
        }
    }
}

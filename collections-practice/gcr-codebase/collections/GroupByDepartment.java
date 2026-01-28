import java.util.*;
class Employee{
    String name;
    String dept;
    Employee(String name,String dept){
        this.name=name;
        this.dept=dept;
    }
    public String toString(){
        return name;
    }
}
public class GroupByDepartment{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Map<String,List<Employee>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            String name=sc.next();
            String dept=sc.next();
            Employee e=new Employee(name,dept);
            if(!map.containsKey(dept)){
                map.put(dept,new ArrayList<>());
            }
            map.get(dept).add(e);
        }
        for(String d:map.keySet()){
            System.out.println(d+": "+map.get(d));
        }
    }
}

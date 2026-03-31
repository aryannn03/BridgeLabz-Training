import java.util.*;

class InsufficientLeaveBalanceException extends Exception{
    public InsufficientLeaveBalanceException(String msg){
        super(msg);
    }
}

class Employee{
    private int id;
    private String name;
    private int leaveBalance;

    public Employee(int id,String name,int leaveBalance){
        this.id=id;
        this.name=name;
        this.leaveBalance=leaveBalance;
    }

    public int getId(){
        return id;
    }

    public int getLeaveBalance(){
        return leaveBalance;
    }

    public void reduceLeave(int days){
        leaveBalance-=days;
    }

    public String getName(){
        return name;
    }
}

class LeaveRequest{
    private Employee employee;
    private int days;
    private String status;

    public LeaveRequest(Employee employee,int days){
        this.employee=employee;
        this.days=days;
        this.status="Pending";
    }

    public void approve()throws InsufficientLeaveBalanceException{
        if(employee.getLeaveBalance()<days){
            throw new InsufficientLeaveBalanceException("Insufficient Leave Balance");
        }
        employee.reduceLeave(days);
        status="Approved";
    }

    public void reject(){
        status="Rejected";
    }

    public String toString(){
        return employee.getName()+" Leave:"+days+" Status:"+status;
    }
}

public class LeaveManagementSystem{
    public static void main(String[] args){
        try{
            Map<Integer,Employee> employees=new HashMap<>();
            List<LeaveRequest> requests=new ArrayList<>();

            Employee e1=new Employee(1,"Amit",10);
            Employee e2=new Employee(2,"Neha",5);

            employees.put(e1.getId(),e1);
            employees.put(e2.getId(),e2);

            LeaveRequest r1=new LeaveRequest(e1,4);
            LeaveRequest r2=new LeaveRequest(e2,6);

            requests.add(r1);
            requests.add(r2);

            for(LeaveRequest r:requests){
                try{
                    r.approve();
                }catch(Exception ex){
                    r.reject();
                }
                System.out.println(r);
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
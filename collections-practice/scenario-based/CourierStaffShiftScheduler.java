import java.util.*;

class ShiftAlreadyAssignedException extends Exception{
    public ShiftAlreadyAssignedException(String msg){
        super(msg);
    }
}

class Employee{
    private int id;
    private String name;
    public Employee(int id,String name){
        this.id=id;
        this.name=name;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
}

class ShiftTime{
    private String shiftName;
    public ShiftTime(String shiftName){
        this.shiftName=shiftName;
    }
    public String getShiftName(){
        return shiftName;
    }
    public boolean equals(Object o){
        if(this==o)return true;
        if(o==null||getClass()!=o.getClass())return false;
        ShiftTime s=(ShiftTime)o;
        return shiftName.equals(s.shiftName);
    }
    public int hashCode(){
        return shiftName.hashCode();
    }
}

class ShiftManager{
    private List<Employee> employees=new ArrayList<>();
    private Map<ShiftTime,List<Employee>> shiftMap=new HashMap<>();
    public void addEmployee(Employee e){
        employees.add(e);
    }
    public void assignShift(ShiftTime shift,Employee e)throws ShiftAlreadyAssignedException{
        if(!shiftMap.containsKey(shift)){
            shiftMap.put(shift,new ArrayList<>());
        }
        List<Employee> list=shiftMap.get(shift);
        if(list.contains(e)){
            throw new ShiftAlreadyAssignedException("AlreadyAssigned");
        }
        list.add(e);
    }
}

public class CourierStaffShiftScheduler{
    public static void main(String[] args){
        ShiftManager manager=new ShiftManager();
        Employee e1=new Employee(1,"Aryan");
        Employee e2=new Employee(2,"Rahul");
        manager.addEmployee(e1);
        manager.addEmployee(e2);
        ShiftTime morning=new ShiftTime("Morning");
        try{
            manager.assignShift(morning,e1);
            manager.assignShift(morning,e1);
        }catch(ShiftAlreadyAssignedException e){}
    }
}

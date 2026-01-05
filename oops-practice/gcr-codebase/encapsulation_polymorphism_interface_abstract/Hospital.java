interface MedicalRecord{
    void addRecord(String r);
    void viewRecords();
}
abstract class Patient{
    protected int patientId;
    protected String name;
    protected int age;
    private String record="";
    Patient(int id,String n,int a){
        patientId=id;
        name=n;
        age=a;
    }
    abstract double calculateBill();
    void getPatientDetails(){
        System.out.println(patientId+" "+name+" "+age);
    }
    void addRecord(String r){
        record=r;
    }
    void viewRecords(){
        System.out.println("Record:"+record);
    }
}
class InPatient extends Patient{
    int days;
    InPatient(int i,String n,int a,int d){
        super(i,n,a);
        days=d;
    }
    double calculateBill(){
        return days*2000;
    }
}
class OutPatient extends Patient{
    OutPatient(int i,String n,int a){
        super(i,n,a);
    }
    double calculateBill(){
        return 500;
    }
}
public class Hospital{
    public static void main(String[] args){
        Patient p1=new InPatient(1,"Parth",22,3);
        Patient p2=new OutPatient(2,"Amit",30);
        p1.getPatientDetails();
        System.out.println("Bill:"+p1.calculateBill());
        p2.getPatientDetails();
        System.out.println("Bill:"+p2.calculateBill());
    }
}

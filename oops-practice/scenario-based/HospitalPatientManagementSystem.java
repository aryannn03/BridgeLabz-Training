import java.util.*;
interface IPayable{
    double calculateBill();
}
abstract class Patient implements IPayable{
    private int patientId;
    private String patientName;
    private int age;
    private String gender;
    private String contactNumber;
    public Patient(int patientId,String patientName,int age,String gender,String contactNumber){
        this.patientId=patientId;
        this.patientName=patientName;
        this.age=age;
        this.gender=gender;
        this.contactNumber=contactNumber;
    }
    public int getPatientId(){
        return patientId;
    }
    public String getPatientName(){
        return patientName;
    }
    public void setContactNumber(String contactNumber){
        this.contactNumber=contactNumber;
    }
    public abstract void displayInfo();
}
class InPatient extends Patient{
    private int daysAdmitted;
    private double dailyCharge;
    public InPatient(int id,String name,int age,String gender,String contact,int days,double charge){
        super(id,name,age,gender,contact);
        this.daysAdmitted=days;
        this.dailyCharge=charge;
    }
    public double calculateBill(){
        return daysAdmitted*dailyCharge;
    }
    public void displayInfo(){
        System.out.println("InPatient ID:"+getPatientId()+" Name:"+getPatientName()+" Bill:"+calculateBill());
    }
}
class OutPatient extends Patient{
    private double consultationFee;
    public OutPatient(int id,String name,int age,String gender,String contact,double fee){
        super(id,name,age,gender,contact);
        this.consultationFee=fee;
    }
    public double calculateBill(){
        return consultationFee;
    }
    public void displayInfo(){
        System.out.println("OutPatient ID:"+getPatientId()+" Name:"+getPatientName()+" Bill:"+calculateBill());
    }
}
class Doctor{
    private int doctorId;
    private String doctorName;
    private String specialization;
    public Doctor(int doctorId,String doctorName,String specialization){
        this.doctorId=doctorId;
        this.doctorName=doctorName;
        this.specialization=specialization;
    }
    public void displayDoctor(){
        System.out.println("Doctor ID:"+doctorId+" Name:"+doctorName+" Specialization:"+specialization);
    }
}
class Bill implements IPayable{
    private int billId;
    private Patient patient;
    public Bill(int billId,Patient patient){
        this.billId=billId;
        this.patient=patient;
    }
    public double calculateBill(){
        return patient.calculateBill();
    }
    public void displayBill(){
        System.out.println("Bill ID:"+billId+" Patient:"+patient.getPatientName()+" Amount:"+calculateBill());
    }
}
public class HospitalPatientManagementSystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Patient> patients=new ArrayList<>();
        while(true){
            System.out.println("1.Add InPatient");
            System.out.println("2.Add OutPatient");
            System.out.println("3.Display Patients");
            System.out.println("4.Update Patient Contact");
            System.out.println("5.Delete Patient");
            System.out.println("6.Generate Bill");
            System.out.println("7.Exit");
            int choice=sc.nextInt();
            sc.nextLine();
            if(choice==1){
                int id=sc.nextInt();
                sc.nextLine();
                String name=sc.nextLine();
                int age=sc.nextInt();
                sc.nextLine();
                String gender=sc.nextLine();
                String contact=sc.nextLine();
                int days=sc.nextInt();
                double charge=sc.nextDouble();
                patients.add(new InPatient(id,name,age,gender,contact,days,charge));
            }
            else if(choice==2){
                int id=sc.nextInt();
                sc.nextLine();
                String name=sc.nextLine();
                int age=sc.nextInt();
                sc.nextLine();
                String gender=sc.nextLine();
                String contact=sc.nextLine();
                double fee=sc.nextDouble();
                patients.add(new OutPatient(id,name,age,gender,contact,fee));
            }
            else if(choice==3){
                for(Patient p:patients)
                    p.displayInfo();
            }
            else if(choice==4){
                int id=sc.nextInt();
                sc.nextLine();
                for(Patient p:patients){
                    if(p.getPatientId()==id){
                        String newContact=sc.nextLine();
                        p.setContactNumber(newContact);
                    }
                }
            }
            else if(choice==5){
                int id=sc.nextInt();
                patients.removeIf(p->p.getPatientId()==id);
            }
            else if(choice==6){
                int billId=sc.nextInt();
                int pid=sc.nextInt();
                for(Patient p:patients){
                    if(p.getPatientId()==pid){
                        Bill b=new Bill(billId,p);
                        b.displayBill();
                    }
                }
            }
            else if(choice==7){
                return;
            }
        }
    }
}

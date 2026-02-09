package presentation;

import service.ClinicService;
import model.*;
import java.util.*;

public class HealthClinicApp{

    public static void main(String[] args)throws Exception{

        ClinicService service=new ClinicService();
        Scanner sc=new Scanner(System.in);

        while(true){

            System.out.println("\n--- HEALTH CLINIC MENU ---");
            System.out.println("1.Register Patient");
            System.out.println("2.Add Doctor");
            System.out.println("3.Book Appointment");
            System.out.println("4.Record Visit");
            System.out.println("5.Generate Bill");
            System.out.println("6.View Outstanding Bills");
            System.out.println("0.Exit");

            int choice=sc.nextInt();
            sc.nextLine();

            if(choice==0)
                break;

            switch(choice){

                case 1:
                    System.out.print("Name:");
                    String name=sc.nextLine();
                    System.out.print("DOB:");
                    String dob=sc.nextLine();
                    System.out.print("Phone:");
                    String phone=sc.nextLine();
                    System.out.print("Email:");
                    String email=sc.nextLine();
                    System.out.print("Address:");
                    String address=sc.nextLine();
                    System.out.print("Blood Group:");
                    String bg=sc.nextLine();

                    Patient p=service.registerPatient(
                        name,dob,phone,email,address,bg
                    );
                    System.out.println("Patient registered with ID:"+p.getId());
                    break;

                case 2:
                    System.out.print("Doctor Name:");
                    String dname=sc.nextLine();
                    System.out.print("Specialty:");
                    String spec=sc.nextLine();
                    System.out.print("Consultation Fee:");
                    double fee=sc.nextDouble();

                    Doctor d=service.addDoctor(dname,spec,fee);
                    System.out.println("Doctor added with ID:"+d.getId());
                    break;

                case 3:
                    System.out.print("Patient ID:");
                    int pid=sc.nextInt();
                    System.out.print("Doctor ID:");
                    int did=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Date (YYYY-MM-DD):");
                    String date=sc.nextLine();

                    Appointment a=service.bookAppointment(pid,did,date);
                    System.out.println("Appointment booked with ID:"+a.getId());
                    break;

                case 4:
                    System.out.print("Appointment ID:");
                    int aid=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Diagnosis:");
                    String diag=sc.nextLine();
                    System.out.print("Notes:");
                    String notes=sc.nextLine();

                    Visit v=service.recordVisit(aid,diag,notes);
                    System.out.println("Visit recorded with ID:"+v.getId());
                    break;

                case 5:
                    System.out.print("Visit ID:");
                    int vid=sc.nextInt();
                    System.out.print("Amount:");
                    double amt=sc.nextDouble();

                    Bill b=service.generateBill(vid,amt);
                    System.out.println("Bill generated");
                    break;

                case 6:
                    System.out.println(
                        "Outstanding bills:"+service.outstandingBills().size()
                    );
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }
        sc.close();
    }
}

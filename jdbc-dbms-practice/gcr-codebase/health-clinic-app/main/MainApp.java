package main;

import dao.*;
import model.*;
import java.util.*;

public class MainApp{

    public static void main(String[]args){

        Scanner sc=new Scanner(System.in);

        PatientDAO patientDAO=new PatientDAO();
        DoctorDAO doctorDAO=new DoctorDAO();
        AppointmentDAO apptDAO=new AppointmentDAO();
        VisitDAO visitDAO=new VisitDAO();
        PrescriptionDAO presDAO=new PrescriptionDAO();
        MedicalHistoryDAO historyDAO=new MedicalHistoryDAO();
        BillingDAO billingDAO=new BillingDAO();
        PaymentDAO paymentDAO=new PaymentDAO();

        while(true){

            System.out.println("\n===== Health Clinic Menu =====");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. Record Visit");
            System.out.println("5. Generate Bill");
            System.out.println("6. Record Payment");
            System.out.println("7. View Medical History");
            System.out.println("8. Exit");

            int choice=sc.nextInt();

            switch(choice){

                case 1:
                    System.out.print("Name: ");
                    String name=sc.next();
                    System.out.print("DOB (YYYY-MM-DD): ");
                    String dob=sc.next();
                    System.out.print("Phone: ");
                    String phone=sc.next();
                    System.out.print("Address: ");
                    String address=sc.next();
                    System.out.print("Blood Group: ");
                    String bg=sc.next();

                    Patient p=new Patient(name,dob,phone,address,bg);
                    patientDAO.addPatient(p);
                    break;

                case 2:
                    System.out.print("Doctor Name: ");
                    String dname=sc.next();
                    System.out.print("Specialization: ");
                    String spec=sc.next();
                    System.out.print("Phone: ");
                    String dphone=sc.next();
                    System.out.print("Fee: ");
                    double fee=sc.nextDouble();

                    Doctor d=new Doctor(dname,spec,dphone,fee);
                    doctorDAO.addDoctor(d);
                    break;

                case 3:
                    patientDAO.viewPatients();
                    System.out.print("Patient Id: ");
                    int pid=sc.nextInt();

                    doctorDAO.viewDoctors();
                    System.out.print("Doctor Id: ");
                    int did=sc.nextInt();

                    System.out.print("Date: ");
                    String date=sc.next();
                    System.out.print("Time: ");
                    String time=sc.next();

                    Appointment appt=new Appointment(pid,did,date,time);
                    apptDAO.bookAppointment(appt);
                    break;

                case 4:
                    apptDAO.viewAppointments();
                    System.out.print("Appointment Id: ");
                    int aid=sc.nextInt();

                    System.out.print("Diagnosis: ");
                    String diag=sc.next();
                    System.out.print("Notes: ");
                    String notes=sc.next();
                    System.out.print("Visit Date: ");
                    String vdate=sc.next();

                    Visit visit=new Visit(aid,diag,notes,vdate);
                    int visitId=visitDAO.recordVisitAndCompleteAppointment(visit);

                    System.out.print("Medicine: ");
                    String med=sc.next();
                    System.out.print("Dosage: ");
                    String dosage=sc.next();
                    System.out.print("Duration: ");
                    String duration=sc.next();

                    List<Prescription>list=new ArrayList<>();
                    list.add(new Prescription(visitId,med,dosage,duration));
                    presDAO.addPrescriptionBatch(list);
                    break;

                case 5:
                    visitDAO.viewVisits();
                    System.out.print("Visit Id: ");
                    int vid=sc.nextInt();

                    System.out.print("Amount: ");
                    double amt=sc.nextDouble();
                    System.out.print("Bill Date: ");
                    String bdate=sc.next();

                    Bill bill=new Bill(vid,amt,bdate);
                    billingDAO.generateBill(bill);
                    break;

                case 6:
                    billingDAO.viewBills();
                    System.out.print("Bill Id: ");
                    int billId=sc.nextInt();

                    System.out.print("Mode: ");
                    String mode=sc.next();
                    System.out.print("Payment Date: ");
                    String pdate=sc.next();

                    Payment payment=new Payment(billId,mode,pdate);
                    paymentDAO.recordPayment(payment);
                    break;

                case 7:
                    patientDAO.viewPatients();
                    System.out.print("Enter Patient Id: ");
                    int phid=sc.nextInt();
                    historyDAO.viewHistory(phid);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }
}
package service;
import dao.*;
import model.*;
import java.util.*;

public class ClinicService{

    private PatientDAO patientDAO=new PatientDAO();
    private DoctorDAO doctorDAO=new DoctorDAO();
    private AppointmentDAO appointmentDAO=new AppointmentDAO();
    private VisitDAO visitDAO=new VisitDAO();
    private BillDAO billDAO=new BillDAO();

    public Patient registerPatient(String n,String d,String p,String e,String a,String bg)throws Exception{
        if(patientDAO.exists(p,e))
            throw new Exception("Patient already exists");
        return patientDAO.add(n,d,p,e,a,bg);
    }

    public Doctor addDoctor(String n,String s,double f){
        return doctorDAO.add(n,s,f);
    }

    public Appointment bookAppointment(int pid,int did,String date)throws Exception{
        if(!appointmentDAO.isDoctorAvailable(did,date))
            throw new Exception("Doctor not available");
        return appointmentDAO.book(pid,did,date);
    }

    public Visit recordVisit(int apptId,String diag,String notes){
        return visitDAO.add(apptId,diag,notes);
    }

    public Bill generateBill(int visitId,double amt){
        return billDAO.generate(visitId,amt);
    }

    public List<Bill> outstandingBills(){
        return billDAO.unpaid();
    }
}

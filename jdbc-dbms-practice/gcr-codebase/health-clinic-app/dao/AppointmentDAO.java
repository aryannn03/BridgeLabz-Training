package dao;

import model.Appointment;
import java.util.*;

public class AppointmentDAO{
    private List<Appointment> list=new ArrayList<>();
    private int idCounter=1;

    public Appointment book(int pid,int did,String date){
        Appointment a=new Appointment(idCounter++,pid,did,date);
        list.add(a);
        return a;
    }

    public boolean isDoctorAvailable(int did,String date){
        for(Appointment a:list){
            if(a.getDoctorId()==did&&a.getDate().equals(date))
                return false;
        }
        return true;
    }
}

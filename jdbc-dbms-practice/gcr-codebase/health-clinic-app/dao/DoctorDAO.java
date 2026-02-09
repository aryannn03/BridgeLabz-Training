package dao;

import model.Doctor;
import java.util.*;

public class DoctorDAO{
    private List<Doctor> doctors=new ArrayList<>();
    private int idCounter=1;

    public Doctor add(String name,String spec,double fee){
        Doctor d=new Doctor(idCounter++,name,spec,fee);
        doctors.add(d);
        return d;
    }

    public List<Doctor> bySpecialty(String spec){
        List<Doctor> res=new ArrayList<>();
        for(Doctor d:doctors){
            if(d.getSpecialty().equals(spec)&&d.isActive())
                res.add(d);
        }
        return res;
    }

    public void deactivate(int id){
        for(Doctor d:doctors){
            if(d.getId()==id)
                d.deactivate();
        }
    }
}

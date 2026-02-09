package dao;

import model.Patient;
import java.util.*;

public class PatientDAO{
    private List<Patient> patients=new ArrayList<>();
    private int idCounter=1;

    public boolean exists(String phone,String email){
        for(Patient p:patients){
            if(p.getPhone().equals(phone)||p.getEmail().equals(email))
                return true;
        }
        return false;
    }

    public Patient add(String name,String dob,String phone,String email,String address,String bg){
        Patient p=new Patient(idCounter++,name,dob,phone,email,address,bg);
        patients.add(p);
        return p;
    }

    public List<Patient> search(String key){
        List<Patient> res=new ArrayList<>();
        for(Patient p:patients){
            if(p.getName().contains(key)||p.getPhone().equals(key))
                res.add(p);
        }
        return res;
    }
}



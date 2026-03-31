package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Patient;
import util.DBConnection;

public class PatientDAO{

    public void addPatient(Patient patient){
        String sql="INSERT INTO patients(name,dob,contact,address,blood_group)VALUES(?,?,?,?,?)";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setString(1,patient.getName());
            ps.setString(2,patient.getDob());
            ps.setString(3,patient.getContact());
            ps.setString(4,patient.getAddress());
            ps.setString(5,patient.getBloodGroup());

            ps.executeUpdate();
            System.out.println("Patient added successfully");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /* Search by ID */
    public void searchPatientById(int id){
        String sql="SELECT * FROM patients WHERE patient_id=?";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                System.out.println(rs.getInt("patient_id")+" "+rs.getString("name")+" "+rs.getString("contact"));
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /* Show all patients (important for menu input) */
    public void viewPatients(){
        String sql="SELECT * FROM patients";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery()){

            System.out.println("\nAvailable Patients:");
            while(rs.next()){
                System.out.println(rs.getInt("id")+" - "+rs.getString("name")+" - "+rs.getString("contact"));
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
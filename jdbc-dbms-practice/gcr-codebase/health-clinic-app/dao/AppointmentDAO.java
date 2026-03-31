package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Appointment;
import util.DBConnection;

public class AppointmentDAO{

    public void bookAppointment(Appointment appt){
        String sql="INSERT INTO appointments(patient_id,doctor_id,appointment_date,appointment_time,status)VALUES(?,?,?,?,?)";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setInt(1,appt.getPatientId());
            ps.setInt(2,appt.getDoctorId());
            ps.setString(3,appt.getDate());
            ps.setString(4,appt.getTime());
            ps.setString(5,"SCHEDULED");

            ps.executeUpdate();
            System.out.println("Appointment booked successfully");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void viewAppointments(){
        String sql="SELECT * FROM appointments";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery()){

            System.out.println("\nAppointments:");
            while(rs.next()){
                System.out.println(rs.getInt("appointment_id")+" - Patient:"+rs.getInt("patient_id")+" Doctor:"+rs.getInt("doctor_id")+" Date:"+rs.getString("appointment_date"));
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
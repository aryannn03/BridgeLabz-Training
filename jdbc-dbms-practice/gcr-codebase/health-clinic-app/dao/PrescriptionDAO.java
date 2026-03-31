package dao;

import util.DBConnection;
import model.Prescription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class PrescriptionDAO{

    public void addPrescriptionBatch(List<Prescription>list){
        String sql="INSERT INTO prescriptions(visit_id,medicine,dosage,duration)VALUES(?,?,?,?)";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            for(Prescription p:list){
                ps.setInt(1,p.getVisitId());
                ps.setString(2,p.getMedicine());
                ps.setString(3,p.getDosage());
                ps.setString(4,p.getDuration());
                ps.addBatch();
            }

            ps.executeBatch();
            System.out.println("Prescriptions added successfully");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
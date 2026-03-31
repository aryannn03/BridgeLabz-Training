package dao;

import util.DBConnection;
import model.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PaymentDAO{

    public void recordPayment(Payment payment){
        String insertPayment="INSERT INTO payments(bill_id,payment_mode,payment_date)VALUES(?,?,?)";
        String updateBill="UPDATE bills SET payment_status='PAID' WHERE id=?";

        try(Connection con=DBConnection.getConnection()){
            con.setAutoCommit(false);

            try(PreparedStatement ps1=con.prepareStatement(insertPayment);
                PreparedStatement ps2=con.prepareStatement(updateBill)){

                ps1.setInt(1,payment.getBillId());
                ps1.setString(2,payment.getMode());
                ps1.setString(3,payment.getDate());
                ps1.executeUpdate();

                ps2.setInt(1,payment.getBillId());
                ps2.executeUpdate();

                con.commit();
                System.out.println("Payment recorded successfully");

            }catch(Exception e){
                con.rollback();
                System.out.println(e.getMessage());
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
import java.sql.*;
import java.io.*;

public class EmployeeCSVReport {

    public static void main(String[] args) {

        String dbUrl = "jdbc:mysql://localhost:3306/companydb";
        String dbUser = "root";
        String dbPassword = "password";

        String csvPath = "collections-practice/gcr-codebase/CSV_Data_Handling/employees_report.csv";

        try (
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, name, department, salary FROM employees");
            BufferedWriter bw = new BufferedWriter(new FileWriter(csvPath))
        ) {

            bw.write("Employee ID,Name,Department,Salary");
            bw.newLine();

            while (rs.next()) {
                bw.write(
                    rs.getInt("id") + "," +
                    rs.getString("name") + "," +
                    rs.getString("department") + "," +
                    rs.getDouble("salary")
                );
                bw.newLine();
            }

            System.out.println("CSV report generated successfully");

        } catch (Exception e) {
            System.out.println("Error generating CSV report");
        }
    }
}

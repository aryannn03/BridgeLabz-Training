import java.io.*;

public class EmployeeCSVWriter{
    public static void main(String[]args){
        String filePath="collections-practice/gcr-codebase/CSV_Data_Handling/employees.csv";
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(filePath))){
            bw.write("ID,Name,Department,Salary\n");
            bw.write("1,Parth,IT,50000\n");
            bw.write("2,Amit,HR,40000\n");
            bw.write("3,Neha,IT,55000\n");
            bw.write("4,Ravi,Sales,45000\n");
            bw.write("5,Kiran,IT,60000\n");
            System.out.println("CSV Created Successfully");
        }catch(IOException e){
            System.out.println("Error writing CSV file");
        }
    }
}

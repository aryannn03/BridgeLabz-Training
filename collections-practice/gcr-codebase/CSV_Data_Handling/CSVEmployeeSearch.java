import java.io.*;
import java.util.Scanner;

public class CSVEmployeeSearch{
    public static void main(String[]args){
        String filePath="collections-practice/gcr-codebase/CSV_Data_Handling/employees.csv";
        Scanner sc=new Scanner(System.in);
        String searchName=sc.nextLine();
        boolean found=false;

        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            br.readLine();
            String line;
            while((line=br.readLine())!=null){
                String[]data=line.split(",");
                if(data[1].equalsIgnoreCase(searchName)){
                    System.out.println("Department: "+data[2]);
                    System.out.println("Salary: "+data[3]);
                    found=true;
                    break;
                }
            }
            if(!found){
                System.out.println("Employee not found");
            }
        }catch(IOException e){
            System.out.println("Error");
        }
        sc.close();
    }
}

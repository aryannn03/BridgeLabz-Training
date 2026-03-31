import java.io.*;

public class CSVSalaryUpdater{
    public static void main(String[]args){
        String inputPath="io-programming-practice/gcr-codebase/csv-data-handling/employees.csv";
        String outputPath="io-programming-practice/gcr-codebase/csv-data-handling/employees_updated.csv";

        try(
            BufferedReader br=new BufferedReader(new FileReader(inputPath));
            BufferedWriter bw=new BufferedWriter(new FileWriter(outputPath))
        ){
            String line;
            bw.write(br.readLine());
            bw.newLine();

            while((line=br.readLine())!=null){
                String[]data=line.split(",");
                if(data[2].equalsIgnoreCase("IT")){
                    double salary=Double.parseDouble(data[3]);
                    salary=salary+(salary*0.10);
                    data[3]=String.valueOf((int)salary);
                }
                bw.write(String.join(",",data));
                bw.newLine();
            }
            System.out.println("Salary updated successfully");
        }catch(IOException e){
            System.out.println("Error");
        }
    }
}

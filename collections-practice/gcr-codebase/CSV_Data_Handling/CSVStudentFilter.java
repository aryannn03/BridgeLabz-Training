import java.io.*;

public class CSVStudentFilter{
    public static void main(String[]args){
        String filePath="collections-practice/gcr-codebase/CSV_Data_Handling/students.csv";

        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            br.readLine();
            String line;
            while((line=br.readLine())!=null){
                String[]data=line.split(",");
                int marks=Integer.parseInt(data[3]);
                if(marks>80){
                    System.out.println(line);
                }
            }
        }catch(IOException e){
            System.out.println("Error");
        }
    }
}

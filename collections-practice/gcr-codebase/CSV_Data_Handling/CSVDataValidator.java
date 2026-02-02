import java.io.*;

public class CSVDataValidator{
    public static void main(String[]args){
        String filePath="collections-practice/gcr-codebase/CSV_Data_Handling/users.csv";
        String emailRegex="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex="\\d{10}";

        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            br.readLine();
            String line;
            while((line=br.readLine())!=null){
                String[]data=line.split(",");
                boolean emailValid=data[2].matches(emailRegex);
                boolean phoneValid=data[3].matches(phoneRegex);

                if(!emailValid||!phoneValid){
                    System.out.println("Invalid Row: "+line);
                }
            }
        }catch(IOException e){
            System.out.println("Error");
        }
    }
}

import java.io.*;

public class StudentCSVReader{
    public static void main(String[]args){
        String fileName="io-programming-practice/gcr-codebase/csv-data-handling/students.csv";
        try{
            BufferedReader br=new BufferedReader(new FileReader(fileName));
            String line;
            while((line=br.readLine())!=null){
                String[]data=line.split(",");
                System.out.println("ID: "+data[0]);
                System.out.println("Name: "+data[1]);
                System.out.println("Age: "+data[2]);
                System.out.println("Marks: "+data[3]);
                System.out.println("--------------------");
            }
            br.close();
        }catch(IOException e){
            System.out.println("Error reading file");
        }
    }
}

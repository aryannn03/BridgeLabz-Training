import java.io.*;
import java.util.*;

public class CSVMerger{
    public static void main(String[]args){
        String file1="io-programming-practice/gcr-codebase/csv-data-handling/students1.csv";
        String file2="io-programming-practice/gcr-codebase/csv-data-handling/students2.csv";
        String output="io-programming-practice/gcr-codebase/csv-data-handling/students_merged.csv";

        Map<String,String[]> map=new HashMap<>();

        try(BufferedReader br1=new BufferedReader(new FileReader(file1))){
            br1.readLine();
            String line;
            while((line=br1.readLine())!=null){
                String[]d=line.split(",");
                map.put(d[0],new String[]{d[1],d[2]});
            }
        }catch(IOException e){
            System.out.println("Error");
        }

        try(
            BufferedReader br2=new BufferedReader(new FileReader(file2));
            BufferedWriter bw=new BufferedWriter(new FileWriter(output))
        ){
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();
            br2.readLine();
            String line;
            while((line=br2.readLine())!=null){
                String[]d=line.split(",");
                if(map.containsKey(d[0])){
                    String[]info=map.get(d[0]);
                    bw.write(d[0]+","+info[0]+","+info[1]+","+d[1]+","+d[2]);
                    bw.newLine();
                }
            }
            System.out.println("CSV files merged successfully");
        }catch(IOException e){
            System.out.println("Error");
        }
    }
}

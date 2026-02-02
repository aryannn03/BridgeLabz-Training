import java.io.*;
import java.util.*;

public class CSVSalarySorter{
    public static void main(String[]args){
        String filePath="collections-practice/gcr-codebase/CSV_Data_Handling/employees.csv";
        List<String[]> list=new ArrayList<>();

        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            br.readLine();
            String line;
            while((line=br.readLine())!=null){
                list.add(line.split(","));
            }

            list.sort((a,b)->Integer.parseInt(b[3])-Integer.parseInt(a[3]));

            int limit=Math.min(5,list.size());
            for(int i=0;i<limit;i++){
                String[]d=list.get(i);
                System.out.println(d[1]+" "+d[2]+" "+d[3]);
            }
        }catch(IOException e){
            System.out.println("Error");
        }
    }
}

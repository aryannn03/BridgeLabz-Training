import java.io.*;
import java.util.*;

public class CSVDuplicateDetector{
    public static void main(String[]args){
        String filePath="collections-practice/gcr-codebase/CSV_Data_Handling/students.csv";
        Map<String,Integer>countMap=new HashMap<>();
        List<String>rows=new ArrayList<>();

        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            br.readLine();
            String line;
            while((line=br.readLine())!=null){
                rows.add(line);
                String id=line.split(",")[0];
                countMap.put(id,countMap.getOrDefault(id,0)+1);
            }
        }catch(IOException e){
            System.out.println("Error");
        }

        for(String row:rows){
            String id=row.split(",")[0];
            if(countMap.get(id)>1){
                System.out.println("Duplicate Record: "+row);
            }
        }
    }
}

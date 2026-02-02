import java.io.*;

public class CSVChunkReader{
    public static void main(String[]args){
        String filePath="collections-practice/gcr-codebase/CSV_Data_Handling/large_data.csv";
        int batchSize=100;
        int totalCount=0;
        int batchCount=0;

        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            br.readLine();
            while(true){
                batchCount=0;
                while(batchCount<batchSize&& br.readLine()!=null){
                    batchCount++;
                    totalCount++;
                }
                if(batchCount==0){
                    break;
                }
                System.out.println("Records processed: "+totalCount);
            }
        }catch(IOException e){
            System.out.println("Error");
        }
    }
}

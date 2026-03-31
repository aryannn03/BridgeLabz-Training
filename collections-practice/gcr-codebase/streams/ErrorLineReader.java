import java.io.*;
import java.util.*;
public class ErrorLineReader{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String path=sc.nextLine();
        try{
            BufferedReader br=new BufferedReader(new FileReader(path));
            String line;
            while((line=br.readLine())!=null){
                if(line.toLowerCase().contains("error")){
                    System.out.println(line);
                }
            }
            br.close();
        }catch(IOException e){
            System.out.println("Error");
        }
    }
}



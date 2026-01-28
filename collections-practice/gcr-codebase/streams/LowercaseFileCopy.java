import java.io.*;
import java.util.*;
public class LowercaseFileCopy{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String src=sc.nextLine();
        String dest=sc.nextLine();
        try{
            BufferedReader br=new BufferedReader(new FileReader(src));
            BufferedWriter bw=new BufferedWriter(new FileWriter(dest));
            int c;
            while((c=br.read())!=-1){
                bw.write(Character.toLowerCase((char)c));
            }
            br.close();
            bw.close();
            System.out.println("Done");
        }catch(IOException e){
            System.out.println("Error");
        }
    }
}

import java.util.*;
import java.io.*;
public class FileCopy{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String src=sc.nextLine();
        String dest=sc.nextLine();
        try{
            FileInputStream in=new FileInputStream(src);
            FileOutputStream out=new FileOutputStream(dest);
            int b;
            while((b=in.read())!=-1){
                out.write(b);
            }
            in.close();
            out.close();
            System.out.println("File copied");
        }catch(IOException e){
            System.out.println("Source file does not exist");
        }
    }
}

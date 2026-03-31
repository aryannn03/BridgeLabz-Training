import java.io.*;
import java.util.*;
public class ImageByteConversion{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String src=sc.nextLine();
        String dest=sc.nextLine();
        try{
            FileInputStream in=new FileInputStream(src);
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            byte[] buf=new byte[4096];
            int len;
            while((len=in.read(buf))!=-1){
                baos.write(buf,0,len);
            }
            in.close();
            byte[] data=baos.toByteArray();
            ByteArrayInputStream bais=new ByteArrayInputStream(data);
            FileOutputStream out=new FileOutputStream(dest);
            while((len=bais.read(buf))!=-1){
                out.write(buf,0,len);
            }
            out.close();
            FileInputStream in2=new FileInputStream(dest);
            ByteArrayOutputStream baos2=new ByteArrayOutputStream();
            while((len=in2.read(buf))!=-1){
                baos2.write(buf,0,len);
            }
            in2.close();
            System.out.println(Arrays.equals(data,baos2.toByteArray()));
        }catch(IOException e){
            System.out.println("Error");
        }
    }
}

import java.util.*;
import java.io.*;
public class BufferedVsUnbufferedCopy{
    static long copyUnbuffered(String src,String dest)throws IOException{
        FileInputStream in=new FileInputStream(src);
        FileOutputStream out=new FileOutputStream(dest);
        byte[] buf=new byte[4096];
        long start=System.nanoTime();
        int len;
        while((len=in.read(buf))!=-1){
            out.write(buf,0,len);
        }
        long end=System.nanoTime();
        in.close();
        out.close();
        return end-start;
    }
    static long copyBuffered(String src,String dest)throws IOException{
        BufferedInputStream in=new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(dest));
        byte[] buf=new byte[4096];
        long start=System.nanoTime();
        int len;
        while((len=in.read(buf))!=-1){
            out.write(buf,0,len);
        }
        out.flush();
        long end=System.nanoTime();
        in.close();
        out.close();
        return end-start;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String src=sc.nextLine();
        String dest1=sc.nextLine();
        String dest2=sc.nextLine();
        try{
            long t1=copyUnbuffered(src,dest1);
            long t2=copyBuffered(src,dest2);
            System.out.println("UNBUFFERED "+t1);
            System.out.println("BUFFERED "+t2);
        }catch(IOException e){
            System.out.println("File error");
        }
    }
}

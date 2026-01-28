import java.io.*;
class WriterThread extends Thread{
    PipedOutputStream out;
    WriterThread(PipedOutputStream out){
        this.out=out;
    }
    public void run(){
        try{
            String msg="Hello from writer thread";
            out.write(msg.getBytes());
            out.close();
        }catch(IOException e){
            System.out.println("Write error");
        }
    }
}
class ReaderThread extends Thread{
    PipedInputStream in;
    ReaderThread(PipedInputStream in){
        this.in=in;
    }
    public void run(){
        try{
            int ch;
            while((ch=in.read())!=-1){
                System.out.print((char)ch);
            }
            in.close();
        }catch(IOException e){
            System.out.println("Read error");
        }
    }
}
public class PipedStreamDemo{
    public static void main(String[] args){
        try{
            PipedOutputStream out=new PipedOutputStream();
            PipedInputStream in=new PipedInputStream(out);
            WriterThread w=new WriterThread(out);
            ReaderThread r=new ReaderThread(in);
            r.start();
            w.start();
        }catch(IOException e){
            System.out.println("Connection error");
        }
    }
}

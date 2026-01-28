import java.util.*;
import java.io.*;
public class StudentBinaryFile{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String file=sc.nextLine();
        int n=sc.nextInt();
        try{
            DataOutputStream out=new DataOutputStream(new FileOutputStream(file));
            out.writeInt(n);
            for(int i=0;i<n;i++){
                out.writeInt(sc.nextInt());
                out.writeUTF(sc.next());
                out.writeDouble(sc.nextDouble());
            }
            out.close();
            DataInputStream in=new DataInputStream(new FileInputStream(file));
            int count=in.readInt();
            for(int i=0;i<count;i++){
                int roll=in.readInt();
                String name=in.readUTF();
                double gpa=in.readDouble();
                System.out.println(roll+" "+name+" "+gpa);
            }
            in.close();
        }catch(IOException e){
            System.out.println("Error");
        }
    }
}

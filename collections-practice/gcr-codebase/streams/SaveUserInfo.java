import java.io.*;
public class SaveUserInfo{
    public static void main(String[] args){
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter file name");
            String file=br.readLine();
            System.out.println("Enter name");
            String name=br.readLine();
            System.out.println("Enter age");
            String age=br.readLine();
            System.out.println("Enter favorite language");
            String lang=br.readLine();
            FileWriter fw=new FileWriter(file);
            fw.write("Name: "+name+"\n");
            fw.write("Age: "+age+"\n");
            fw.write("Language: "+lang+"\n");
            fw.close();
            System.out.println("Data saved");
        }catch(Exception e){
            System.out.println("Error occurred");
        }
    }
}

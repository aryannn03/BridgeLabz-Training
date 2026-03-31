import java.io.*;

public class FileProcessor{
    public void writeToFile(String filename,String content) throws IOException{
        FileWriter fw=new FileWriter(filename);
        fw.write(content);
        fw.close();
    }
    public String readFromFile(String filename) throws IOException{
        BufferedReader br=new BufferedReader(new FileReader(filename));
        String line;
        String result="";
        while((line=br.readLine())!=null){
            result+=line;
        }
        br.close();
        return result;
    }
    public static void main(String[]args) throws IOException{
        FileProcessor f=new FileProcessor();
        f.writeToFile("sample.txt","HelloWorld");
        System.out.println(f.readFromFile("sample.txt"));
    }
}

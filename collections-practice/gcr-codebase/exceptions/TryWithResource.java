import java.io.*;
public class TryWithResource {
    public static void main(String[] args) {
        try(BufferedReader br=new BufferedReader(new FileReader("data.txt"))) {
            System.out.println(br.readLine());
        } catch(IOException e) {
            System.out.println("Error reading file");
        }
    }
}
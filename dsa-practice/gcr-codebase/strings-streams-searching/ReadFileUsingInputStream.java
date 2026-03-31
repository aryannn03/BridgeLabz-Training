import java.io.*;
import java.nio.charset.*;
import java.util.*;

public class ReadFileUsingInputStream{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String filePath=sc.nextLine();
		try(FileInputStream fis=new FileInputStream(filePath);
			InputStreamReader isr=new InputStreamReader(fis,StandardCharsets.UTF_8);
			BufferedReader br=new BufferedReader(isr)){
			String line;
			while((line=br.readLine())!=null){
				System.out.println(line);
			}
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}

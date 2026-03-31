import java.io.*;
import java.util.*;

public class ReadFileLineByLine{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String filePath=sc.nextLine();
		try(FileReader fr=new FileReader(filePath);
			BufferedReader br=new BufferedReader(fr)){
			String line;
			while((line=br.readLine())!=null){
				System.out.println(line);
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		sc.close();
	}
}

import java.io.*;
import java.util.*;

public class WriteUserInputToFile{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String filePath=sc.nextLine();
		try(InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			FileWriter fw=new FileWriter(filePath)){
			String line;
			while(true){
				line=br.readLine();
				if(line.equals("exit")){
					break;
				}
				fw.write(line);
				fw.write(System.lineSeparator());
			}
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}

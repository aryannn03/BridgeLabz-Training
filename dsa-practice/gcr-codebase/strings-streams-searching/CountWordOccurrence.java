import java.io.*;
import java.util.Scanner;

public class CountWordOccurrence{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String filePath=sc.nextLine();
		String target=sc.nextLine();
		int count=0;
		try(FileReader fr=new FileReader(filePath);
			BufferedReader br=new BufferedReader(fr)){
			String line;
			while((line=br.readLine())!=null){
				String[] words=line.split("\\s+");
				for(String word:words){
					if(word.equals(target)){
						count++;
					}
				}
			}
			System.out.println(count);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		sc.close();
	}
}

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class LargeFileReadingComparison{
	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		String filePath=sc.nextLine();

		long start,end;

		start=System.currentTimeMillis();
		readUsingFileReader(filePath);
		end=System.currentTimeMillis();
		System.out.println("FileReader Time: "+(end-start)+" ms");

		start=System.currentTimeMillis();
		readUsingInputStreamReader(filePath);
		end=System.currentTimeMillis();
		System.out.println("InputStreamReader Time: "+(end-start)+" ms");

		sc.close();
	}

	static void readUsingFileReader(String path) throws Exception{
		try(BufferedReader br=new BufferedReader(new FileReader(path))){
			while(br.readLine()!=null){}
		}
	}

	static void readUsingInputStreamReader(String path) throws Exception{
		try(FileInputStream fis=new FileInputStream(path);
			InputStreamReader isr=new InputStreamReader(fis,StandardCharsets.UTF_8);
			BufferedReader br=new BufferedReader(isr)){
			while(br.readLine()!=null){}
		}
	}
}

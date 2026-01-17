import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class PerformanceComparison{
	public static void main(String[] args) throws Exception{

		compareStringBuilderAndBuffer();

		String filePath="largefile.txt";

		long start,end;

		start=System.currentTimeMillis();
		int words1=countWordsUsingFileReader(filePath);
		end=System.currentTimeMillis();
		System.out.println("FileReader Word Count: "+words1);
		System.out.println("FileReader Time: "+(end-start)+" ms");

		start=System.currentTimeMillis();
		int words2=countWordsUsingInputStreamReader(filePath);
		end=System.currentTimeMillis();
		System.out.println("InputStreamReader Word Count: "+words2);
		System.out.println("InputStreamReader Time: "+(end-start)+" ms");
	}

	public static void compareStringBuilderAndBuffer(){
		List<String> list=new ArrayList<>();
		list.add("hello");

		long start,end;

		start=System.currentTimeMillis();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<1_000_000;i++){
			for(String s:list){
				sb.append(s);
			}
		}
		end=System.currentTimeMillis();
		System.out.println("StringBuilder Time: "+(end-start)+" ms");

		start=System.currentTimeMillis();
		StringBuffer sbuf=new StringBuffer();
		for(int i=0;i<1_000_000;i++){
			for(String s:list){
				sbuf.append(s);
			}
		}
		end=System.currentTimeMillis();
		System.out.println("StringBuffer Time: "+(end-start)+" ms");
	}

	public static int countWordsUsingFileReader(String path) throws Exception{
		int count=0;
		try(BufferedReader br=new BufferedReader(new FileReader(path))){
			String line;
			while((line=br.readLine())!=null){
				String[] words=line.split("\\s+");
				count+=words.length;
			}
		}
		return count;
	}

	public static int countWordsUsingInputStreamReader(String path) throws Exception{
		int count=0;
		try(FileInputStream fis=new FileInputStream(path);
			InputStreamReader isr=new InputStreamReader(fis,StandardCharsets.UTF_8);
			BufferedReader br=new BufferedReader(isr)){
			String line;
			while((line=br.readLine())!=null){
				String[] words=line.split("\\s+");
				count+=words.length;
			}
		}
		return count;
	}
}

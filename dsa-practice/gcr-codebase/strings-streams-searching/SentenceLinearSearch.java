import java.util.Scanner;

public class SentenceLinearSearch{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();
		sc.nextLine();

		String[] sentences=new String[n];
		for(int i=0;i<n;i++){
			sentences[i]=sc.nextLine();
		}

		String word=sc.nextLine();

		String result=findSentenceContainingWord(sentences,word);
		System.out.println(result);

		sc.close();
	}

	public static String findSentenceContainingWord(String[] sentences,String word){
		for(String sentence:sentences){
			if(sentence.contains(word)){
				return sentence;
			}
		}
		return "Not Found";
	}
}

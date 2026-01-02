import java.util.*;
public class StringAnalysis{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the paragraph:");
        String para=sc.nextLine();
        if(para==null||para.trim().isEmpty()){
            System.out.println("paragraph is empty or contains only spaces.");
            return;
        }
        int wordCount=countWords(para);
        String longestWord=findLongestWord(para);
        System.out.println("Word Count: "+wordCount);
        System.out.println("Longest Word: "+longestWord);
        System.out.println("Enter word to replace:");
        String oldWord=sc.nextLine();
        System.out.println("Enter replacement word:");
        String newWord=sc.nextLine();
        String replacedText=replaceWord(para,oldWord,newWord);
        System.out.println("Updated para:");
        System.out.println(replacedText);
    }
    public static int countWords(String text){
        String[] words=text.trim().split("\\s+");
        return words.length;
    }
    public static String findLongestWord(String text){
        String[] words=text.trim().split("\\s+");
        String longest=words[0];
        for(int i=1;i<words.length;i++){
            if(words[i].length()>longest.length()){
                longest=words[i];
            }
        }
        return longest;
    }
    public static String replaceWord(String text,String oldWord,String newWord){
        return text.replaceAll("(?i)\\b"+oldWord+"\\b",newWord);
    }
}
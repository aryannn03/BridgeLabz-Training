import java.util.Scanner;
public class WordLengthTable{
    public static int findLength(String text){
        int count=0;
        try{
            while(true){
                text.charAt(count);
                count++;
            }
        }catch(Exception e){
        }
        return count;
    }
    public static String[]splitWords(String text){
        int length=findLength(text);
        int wordCount=1;
        for(int i=0;i<length;i++){
            if(text.charAt(i)==' '){
                wordCount++;
            }
        }
        String[]words=new String[wordCount];
        int index=0;
        String current="";
        for(int i=0;i<length;i++){
            if(text.charAt(i)==' '){
                words[index++]=current;
                current="";
            }else{
                current+=text.charAt(i);
            }
        }
        words[index]=current;
        return words;
    }
    static String[][]buildTable(String[]words){
        String[][]table=new String[words.length][2];
        for(int i=0;i<words.length;i++){
            table[i][0]=words[i];
            table[i][1]=String.valueOf(findLength(words[i]));
        }
        return table;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine();
        String[]words=splitWords(text);
        String[][]table=buildTable(words);
        for(int i=0;i<table.length;i++){
            System.out.println(table[i][0]+" "+Integer.parseInt(table[i][1]));
        }
    }
}

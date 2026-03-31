import java.util.Scanner;
public class ShortLongWord{
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
        int count=1;
        for(int i=0;i<length;i++){
            if(text.charAt(i)==' '){
                count++;
            }
        }
        String[]words=new String[count];
        int index=0;
        String temp="";
        for(int i=0;i<length;i++){
            if(text.charAt(i)==' '){
                words[index++]=temp;
                temp="";
            }else{
                temp+=text.charAt(i);
            }
        }
        words[index]=temp;
        return words;
    }
    public static int[]findShortLong(String[]words){
        int min=findLength(words[0]);
        int max=min;
        for(int i=1;i<words.length;i++){
            int len=findLength(words[i]);
            if(len<min){
                min=len;
            }
            if(len>max){
                max=len;
            }
        }
        return new int[]{min,max};
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine();
        String[]words=splitWords(text);
        int[]result=findShortLong(words);
        System.out.println("Shortest="+result[0]);
        System.out.println("Longest="+result[1]);
    }
}

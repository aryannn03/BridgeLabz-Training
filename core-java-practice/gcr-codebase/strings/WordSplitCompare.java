import java.util.Scanner;
public class WordSplitCompare{
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
        int[]spaceIndex=new int[wordCount];
        int pos=0;
        spaceIndex[pos++]=-1;
        for(int i=0;i<length;i++){
            if(text.charAt(i)==' '){
                spaceIndex[pos++]=i;
            }
        }
        String[]words=new String[wordCount];
        for(int i=0;i<wordCount;i++){
            int start=spaceIndex[i]+1;
            int end=i+1<wordCount?spaceIndex[i+1]:length;
            String word="";
            for(int j=start;j<end;j++){
                word+=text.charAt(j);
            }
            words[i]=word;
        }
        return words;
    }
    static boolean compareArrays(String[]first,String[]second){
        if(first.length!=second.length){
            return false;
        }
        for(int i=0;i<first.length;i++){
            if(!first[i].equals(second[i])){
                return false;
            }
        }
        return true;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine();
        String[]custom=splitWords(text);
        String[]builtIn=text.split(" ");
        System.out.println(compareArrays(custom,builtIn));
    }
}

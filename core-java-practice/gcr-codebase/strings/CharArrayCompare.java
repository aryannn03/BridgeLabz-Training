import java.util.Scanner;
public class CharArrayCompare{
    public static char[]getCharacters(String text){
        char[]result=new char[text.length()];
        for(int i=0;i<text.length();i++){
            result[i]=text.charAt(i);
        }
        return result;
    }
    public static boolean compareArrays(char[]first,char[]second){
        if(first.length!=second.length){
            return false;
        }
        for(int i=0;i<first.length;i++){
            if(first[i]!=second[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String text=sc.next();
        char[]customArray=getCharacters(text);
        char[]builtInArray=text.toCharArray();
        System.out.println(compareArrays(customArray,builtInArray));
    }
}

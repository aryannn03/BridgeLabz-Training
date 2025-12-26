import java.util.Scanner;
public class ReplaceWord{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String sentence=sc.nextLine();
        String oldWord=sc.next();
        String newWord=sc.next();
        String[]words=sentence.split(" ");
        String result="";
        for(int i=0;i<words.length;i++){
            if(words[i].equals(oldWord)){
                result+=newWord;
            }else{
                result+=words[i];
            }
            if(i<words.length-1){
                result+=" ";
            }
        }
        System.out.println(result);
    }
}

import java.util.Scanner;
public class FrequencyNested{
    public static String[]findFrequency(String text){
        char[]chars=text.toCharArray();
        int[]freq=new int[chars.length];
        for(int i=0;i<chars.length;i++){
            freq[i]=1;
            for(int j=i+1;j<chars.length;j++){
                if(chars[i]==chars[j]){
                    freq[i]++;
                    chars[j]='0';
                }
            }
        }
        String[]result=new String[chars.length];
        int index=0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]!='0'){
                result[index++]=chars[i]+" "+freq[i];
            }
        }
        String[]finalResult=new String[index];
        for(int i=0;i<index;i++){
            finalResult[i]=result[i];
        }
        return finalResult;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine();
        String[]result=findFrequency(text);
        for(String s:result){
            System.out.println(s);
        }
    }
}

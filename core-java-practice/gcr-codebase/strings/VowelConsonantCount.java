import java.util.Scanner;
public class VowelConsonantCount{
    public static int checkChar(char value){
        if(value>='A'&&value<='Z'){
            value=(char)(value+32);
        }
        if(value>='a'&&value<='z'){
            if(value=='a'||value=='e'||value=='i'||value=='o'||value=='u'){
                return 1;
            }
            return 2;
        }
        return 0;
    }
    public static int[]countVowelsConsonants(String text){
        int vowels=0;
        int consonants=0;
        for(int i=0;i<text.length();i++){
            int result=checkChar(text.charAt(i));
            if(result==1){
                vowels++;
            }else if(result==2){
                consonants++;
            }
        }
        return new int[]{vowels,consonants};
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine();
        int[]result=countVowelsConsonants(text);
        System.out.println("Vowels="+result[0]);
        System.out.println("Consonants="+result[1]);
    }
}

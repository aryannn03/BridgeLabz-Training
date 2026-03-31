import java.util.Scanner;
public class CharacterTypeTable{
    public static String checkChar(char value){
        if(value>='A'&&value<='Z'){
            value=(char)(value+32);
        }
        if(value>='a'&&value<='z'){
            if(value=='a'||value=='e'||value=='i'||value=='o'||value=='u'){
                return "Vowel";
            }
            return "Consonant";
        }
        return "Not a Letter";
    }
    public static String[][]buildTable(String text){
        String[][]table=new String[text.length()][2];
        for(int i=0;i<text.length();i++){
            table[i][0]=String.valueOf(text.charAt(i));
            table[i][1]=checkChar(text.charAt(i));
        }
        return table;
    }
    public static void display(String[][]table){
        for(int i=0;i<table.length;i++){
            System.out.println(table[i][0]+" "+table[i][1]);
        }
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine();
        display(buildTable(text));
    }
}

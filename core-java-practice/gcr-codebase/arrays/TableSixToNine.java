import java.util.Scanner;
public class TableSixToNine{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        int[]results=new int[4];
        int position=0;
        for(int i=6;i<=9;i++){
            results[position]=number*i;
            position++;
        }
        position=0;
        for(int i=6;i<=9;i++){
            System.out.println(number+"*"+i+"="+results[position]);
            position++;
        }
    }
}

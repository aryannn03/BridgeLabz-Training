import java.util.Scanner;
public class MultiplicationTable{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        int[]table=new int[10];
        for(int count=1;count<=10;count++){
            table[count-1]=number*count;
        }
        for(int count=1;count<=10;count++){
            System.out.println(number+"*"+count+"="+table[count-1]);
        }
    }
}

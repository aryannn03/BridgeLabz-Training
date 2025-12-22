import java.util.Scanner;
public class VotingEligibility{
    public static int[]generateAges(int count){
        int[]ages=new int[count];
        for(int i=0;i<count;i++){
            ages[i]=(int)(Math.random()*90);
        }
        return ages;
    }
    public static String[][]checkVoting(int[]ages){
        String[][]result=new String[ages.length][2];
        for(int i=0;i<ages.length;i++){
            result[i][0]=String.valueOf(ages[i]);
            result[i][1]=ages[i]>=18?"true":"false";
        }
        return result;
    }
    public static void display(String[][]table){
        for(int i=0;i<table.length;i++){
            System.out.println(table[i][0]+" "+table[i][1]);
        }
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int count=sc.nextInt();
        display(checkVoting(generateAges(count)));
    }
}

import java.util.Scanner;

public class MaximumOfThree{
    public static int[]takeInput(Scanner sc){
        int[]numbers=new int[3];
        for(int i=0;i<3;i++){
            numbers[i]=sc.nextInt();
        }
        return numbers;
    }
    public static int findMaximum(int[]numbers){
        int max=numbers[0];
        for(int i=1;i<numbers.length;i++){
            if(numbers[i]>max){
                max=numbers[i];
            }
        }
        return max;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int[]values=takeInput(sc);
        int maxValue=findMaximum(values);
        System.out.println("Maximum value="+maxValue);
    }
}

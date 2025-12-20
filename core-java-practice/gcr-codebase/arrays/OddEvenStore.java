import java.util.Scanner;
public class OddEvenStore{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        if(number<=0){
            System.out.println("Invalid number");
            return;
        }
        int[]even=new int[number/2+1];
        int[]odd=new int[number/2+1];
        int evenIndex=0;
        int oddIndex=0;
        for(int value=1;value<=number;value++){
            if(value%2==0){
                even[evenIndex]=value;
                evenIndex++;
            }else{
                odd[oddIndex]=value;
                oddIndex++;
            }
        }
        for(int i=0;i<oddIndex;i++){
            System.out.print(odd[i]+" ");
        }
        System.out.println();
        for(int i=0;i<evenIndex;i++){
            System.out.print(even[i]+" ");
        }
    }
}

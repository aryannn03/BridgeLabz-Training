import java.util.*;
public class TryNested{
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        System.out.print("Enter array size:");
        int size=ob.nextInt();
        int[] arr=new int[size];
        System.out.print("Enter array elements:");
        for(int i=0;i<size;i++) {
            arr[i]=ob.nextInt();
        }
        System.out.print("Enter index to access:");
        int index=ob.nextInt();
        System.out.print("Enter divisor:");
        int divisor=ob.nextInt();
        try {
            try {
                int value=arr[index];
                int result=value/divisor;
                System.out.println("Result:"+result);
            } catch(ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
    }
}
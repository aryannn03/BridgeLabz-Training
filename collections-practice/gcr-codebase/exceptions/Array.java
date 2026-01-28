import java.util.*;
public class Array {
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        try {
            System.out.print("Enter array size:");
            int size=ob.nextInt();
            int[] arr=new int[size];
            System.out.print("Enter array elements:");
            for(int i=0;i<size;i++) {
                arr[i]=ob.nextInt();
            }
            System.out.print("Enter index to access:");
            int index=ob.nextInt();
            System.out.println("Value at index "+index+":"+arr[index]);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch(NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}
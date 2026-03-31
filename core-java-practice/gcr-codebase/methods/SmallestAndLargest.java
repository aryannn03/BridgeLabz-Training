import java.util.Scanner;

public class SmallestAndLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int n3=sc.nextInt();
        int arr[]=findSmallestAndLargest(n1, n2, n3);
        System.out.printf("Smallest Number of three is %d\n",arr[0]);
        System.out.printf("Largest Number of three is %d",arr[1]);

    }
    public static int[] findSmallestAndLargest(int n1,int n2,int n3){
        int largest=(n1>=n2 && n1>=n3)?n1:(n2>=n1 && n2>=n3)?n2:n3;
        int smallest=(n1<=n2 && n1<=n3)?n1:(n2<=n1 && n2<=n3)?n2:n3;
        return new int[]{smallest,largest};
    }    
}

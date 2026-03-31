import java.util.Scanner;

public class FirstNegativeLinearSearch{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();
		int[] arr=new int[n];

		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}

		int index=findFirstNegative(arr);
		System.out.println(index);

		sc.close();
	}

	public static int findFirstNegative(int[] arr){
		for(int i=0;i<arr.length;i++){
			if(arr[i]<0){
				return i;
			}
		}
		return -1;
	}
}

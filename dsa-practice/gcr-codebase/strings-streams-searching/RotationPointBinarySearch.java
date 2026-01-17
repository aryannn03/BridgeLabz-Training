import java.util.Scanner;

public class RotationPointBinarySearch{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}

		int index=findRotationPoint(arr);
		System.out.println(index);

		sc.close();
	}

	public static int findRotationPoint(int[] arr){
		int left=0;
		int right=arr.length-1;

		while(left<right){
			int mid=left+(right-left)/2;

			if(arr[mid]>arr[right]){
				left=mid+1;
			}else{
				right=mid;
			}
		}
		return left;
	}
}

import java.util.*;

public class LinearBinaryChallenge{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}

		int target=sc.nextInt();

		int missing=findFirstMissingPositive(arr.clone());
		System.out.println(missing);

		Arrays.sort(arr);
		int index=binarySearch(arr,target);
		System.out.println(index);

		sc.close();
	}

	public static int findFirstMissingPositive(int[] arr){
		int n=arr.length;

		for(int i=0;i<n;i++){
			while(arr[i]>0&&arr[i]<=n&&arr[arr[i]-1]!=arr[i]){
				int temp=arr[i];
				arr[i]=arr[temp-1];
				arr[temp-1]=temp;
			}
		}

		for(int i=0;i<n;i++){
			if(arr[i]!=i+1){
				return i+1;
			}
		}
		return n+1;
	}

	public static int binarySearch(int[] arr,int target){
		int left=0;
		int right=arr.length-1;

		while(left<=right){
			int mid=left+(right-left)/2;

			if(arr[mid]==target){
				return mid;
			}else if(arr[mid]<target){
				left=mid+1;
			}else{
				right=mid-1;
			}
		}
		return -1;
	}
}

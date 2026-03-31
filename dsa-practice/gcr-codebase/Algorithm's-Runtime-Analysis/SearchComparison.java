import java.util.*;
public class SearchComparison{
	public static void main(String[] args){
		int n=1000000;
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=i;
		}
		int target=n-1;
		long start,end;
		start=System.nanoTime();
		linearSearch(arr,target);
		end=System.nanoTime();
		System.out.println("Linear Search Time: "+(end-start)+" ns");
		Arrays.sort(arr);
		start=System.nanoTime();
		binarySearch(arr,target);
		end=System.nanoTime();
		System.out.println("Binary Search Time: "+(end-start)+" ns");
	}
	public static int linearSearch(int[] arr,int target){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==target){
				return i;
			}
		}
		return -1;
	}
	public static int binarySearch(int[] arr,int target){
		int left=0,right=arr.length-1;
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
